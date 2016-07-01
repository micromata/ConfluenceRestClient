package de.micromata.confluence.rest.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import de.micromata.confluence.rest.ConfluenceRestClient;
import de.micromata.confluence.rest.core.util.URIHelper;
import org.apache.commons.lang3.Validate;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutorService;

/**
 * Created by cschulc on 01.07.2016.
 */
public abstract class BaseClient {

    protected final ConfluenceRestClient confluenceRestClient;
    protected final CloseableHttpClient client;
    protected final HttpClientContext clientContext;
    protected final URI baseUri;
    protected ExecutorService executorService;

    protected Gson gson	= new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public BaseClient(ConfluenceRestClient confluenceRestClient) {
        this.confluenceRestClient = confluenceRestClient;
        this.clientContext = confluenceRestClient.getClientContext();
        this.client = confluenceRestClient.getHttpclient();
        this.baseUri = confluenceRestClient.getBaseUri();
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
