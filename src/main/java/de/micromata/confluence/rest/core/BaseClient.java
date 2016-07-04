package de.micromata.confluence.rest.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import de.micromata.confluence.rest.ConfluenceRestClient;
import de.micromata.confluence.rest.core.domain.BaseBean;
import de.micromata.confluence.rest.core.domain.UserBean;
import de.micromata.confluence.rest.core.misc.RestException;
import de.micromata.confluence.rest.core.misc.RestParamConstants;
import de.micromata.confluence.rest.core.misc.RestPathConstants;
import de.micromata.confluence.rest.core.util.HttpMethodFactory;
import de.micromata.confluence.rest.core.util.URIHelper;
import org.apache.commons.lang3.Validate;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created by cschulc on 01.07.2016.
 */
public abstract class BaseClient implements RestParamConstants, RestPathConstants {

    protected final ConfluenceRestClient confluenceRestClient;
    protected final CloseableHttpClient client;
    protected final HttpClientContext clientContext;
    protected final URI baseUri;
    protected ExecutorService executorService;

    protected Gson gson	= new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public BaseClient(ConfluenceRestClient confluenceRestClient, ExecutorService executorService) {
        this.confluenceRestClient = confluenceRestClient;
        this.clientContext = confluenceRestClient.getClientContext();
        this.client = confluenceRestClient.getHttpclient();
        this.baseUri = confluenceRestClient.getBaseUri();
        this.executorService = executorService;
    }

    protected JsonReader toJsonReader(InputStream inputStream)
            throws UnsupportedEncodingException {
        Validate.notNull(inputStream);
        InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(true);
        return jsonReader;
    }

    protected URIBuilder buildPath(String... paths) throws URISyntaxException {
        return URIHelper.buildPath(baseUri, paths);
    }

    protected JsonReader getJsonReader(CloseableHttpResponse response) throws IOException {
        HttpEntity entity = response.getEntity();
        InputStream inputStream = entity.getContent();
        return toJsonReader(inputStream);
    }

}
