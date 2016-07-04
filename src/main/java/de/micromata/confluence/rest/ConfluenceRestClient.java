package de.micromata.confluence.rest;

import de.micromata.confluence.rest.client.SpaceClient;
import de.micromata.confluence.rest.client.UserClient;
import de.micromata.confluence.rest.core.SpaceClientImpl;
import de.micromata.confluence.rest.core.UserClientImpl;
import de.micromata.confluence.rest.core.misc.RestParamConstants;
import de.micromata.confluence.rest.core.misc.RestPathConstants;
import de.micromata.confluence.rest.core.util.HttpMethodFactory;
import de.micromata.confluence.rest.core.util.URIHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

/**
 * Created by cschulc on 01.07.2016.
 */
public class ConfluenceRestClient implements RestPathConstants, RestParamConstants {


    private static final String HTTP = "http";
    private static final String HTTPS = "https";

    protected final ExecutorService executorService;

    private URI baseUri;
    private String username = StringUtils.EMPTY;
    private CloseableHttpClient httpclient;
    private HttpHost proxy;
    private CookieStore cookieStore = new BasicCookieStore();
    private HttpClientContext clientContext;

    private UserClient userClient;

    private SpaceClient spaceClient;

    public ConfluenceRestClient(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public int connect(URI uri, String username, String password) throws IOException, URISyntaxException, ExecutionException, InterruptedException {
        return connect(uri, username, password, null);
    }

    private int connect(URI uri, String username, String password, HttpHost procxyHost) throws URISyntaxException, IOException {
        this.username = username;
        String host = uri.getHost();
        int port = getPort(uri.toURL());
        String scheme = HTTP;
        if (port == 443) scheme = HTTPS;
        HttpHost target = new HttpHost(host, port, scheme);
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(target.getHostName(), target.getPort()),
                new UsernamePasswordCredentials(username, password));
        httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .build();
        // Create AuthCache instance
        AuthCache authCache = new BasicAuthCache();
        // Generate BASIC scheme object and add it to the local
        // auth cache
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(target, basicAuth);
        // Add AuthCache to the execution context
        clientContext = HttpClientContext.create();
        clientContext.setAuthCache(authCache);
        this.baseUri = buildBaseURI(uri);
        URIBuilder uriBuilder = URIHelper.buildPath(baseUri, USER);
        uriBuilder.addParameter(USERNAME, username);
        HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
        CloseableHttpResponse response = httpclient.execute(method, clientContext);
        return response.getStatusLine().getStatusCode();
    }


    public UserClient getUserClient(){
        if(userClient == null){
            userClient = new UserClientImpl(this, executorService);
        }
        return userClient;
    }

    public SpaceClient getSpaceClient(){
        if(spaceClient == null){
            spaceClient = new SpaceClientImpl(this, executorService);
        }
        return spaceClient;
    }

    /**
     * Extract port from URL
     *
     * @param endpointUrl
     * @return
     */
    private int getPort(URL endpointUrl) {
        int port = (endpointUrl.getPort() != -1 ? endpointUrl.getPort() : endpointUrl.getDefaultPort());
        if (port != -1) {
            return port;
        }
        if (HTTPS.equals(endpointUrl.getProtocol())) {
            return 443;
        }
        return 80;
    }

    private URI buildBaseURI(URI uri) throws URISyntaxException {
        String path = uri.getPath();
        if (path.isEmpty() == false) {
            if (path.endsWith("/")) {
                path = path.substring(0, path.length() - 1);
            }
            path = path.concat(BASE_REST_PATH);
        } else {
            path = BASE_REST_PATH;
        }
        return new URIBuilder(uri).setPath(path).build();
    }

    public URI getBaseUri() {
        return baseUri;
    }

    public String getUsername() {
        return username;
    }

    public HttpHost getProxy() {
        return proxy;
    }

    public HttpClientContext getClientContext() {
        return clientContext;
    }

    public CloseableHttpClient getHttpclient() {
        return httpclient;
    }
}
