package de.micromata.confluence.rest.core.misc;

import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.IOException;

/**
 * Created by cschulc on 01.07.2016.
 */
public class RestException extends Exception {

    private int statusCode;

    private String reasonPhrase;

    public RestException(CloseableHttpResponse response) throws IOException {
        StatusLine statusLine = response.getStatusLine();
        this.statusCode = statusLine.getStatusCode();
        this.reasonPhrase = statusLine.getReasonPhrase();


    }
}
