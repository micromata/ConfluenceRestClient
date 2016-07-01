package de.micromata.confluence.rest.core.util;

import org.apache.commons.validator.routines.UrlValidator;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by cschulc on 01.07.2016.
 */
public class URIHelper {

    public static URI parseStringToURI(String uri) {
        String[] schemes = {"http","https"};
        UrlValidator urlValidator = new UrlValidator(schemes, UrlValidator.ALLOW_LOCAL_URLS);
        if(urlValidator.isValid(uri)){
            try {
                return new URI(uri);
            } catch (URISyntaxException e) {
                return null;
            }
        }
        return null;
    }


    public static URIBuilder buildPath(URI baseUri, String... paths) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(baseUri);
        String basePath = uriBuilder.getPath();
        for (String path : paths) {
            if(path.startsWith("/")){
                basePath = basePath.concat(path);
            }else{
                basePath = basePath.concat("/").concat(path);
            }
        }
        uriBuilder.setPath(basePath);
        return uriBuilder;
    }
}
