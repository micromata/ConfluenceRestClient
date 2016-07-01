package de.micromata.confluence.rest;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.CookieStore;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

/**
 * Created by cschulc on 01.07.2016.
 */
public class ConfluenceRestClient {


    private static final String HTTP = "http";
    private static final String HTTPS = "https";

    protected final ExecutorService executorService;

    private URI baseUri;
    private String username = StringUtils.EMPTY;
    private CloseableHttpClient httpclient;
    private HttpHost proxy;
    private CookieStore cookieStore = new BasicCookieStore();
    private HttpClientContext clientContext;

    public ConfluenceRestClient(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public int connect(URI uri, String username, String password) throws IOException, URISyntaxException, ExecutionException, InterruptedException {
        return connect(uri, username, password, null);
    }

    private int connect(URI uri, String username, String password, HttpHost procxyHost) {
        return 0;
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
