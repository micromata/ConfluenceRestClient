package de.micromata.confluence.rest.core;

import com.google.gson.stream.JsonReader;
import de.micromata.confluence.rest.ConfluenceRestClient;
import de.micromata.confluence.rest.client.UserClient;
import de.micromata.confluence.rest.core.domain.UserBean;
import de.micromata.confluence.rest.core.misc.RestException;
import de.micromata.confluence.rest.core.misc.RestParamConstants;
import de.micromata.confluence.rest.core.misc.RestPathConstants;
import de.micromata.confluence.rest.core.util.HttpMethodFactory;
import org.apache.commons.lang3.Validate;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;

import java.net.HttpURLConnection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created by cschulc on 01.07.2016.
 */
public class UserClientImpl extends BaseClient implements UserClient, RestParamConstants, RestPathConstants {


    public UserClientImpl(ConfluenceRestClient confluenceRestClient, ExecutorService executorService) {
        super(confluenceRestClient, executorService);
    }

    @Override
    public Future<UserBean> getUserByUsername(String username) {
        Validate.notNull(username);
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(USER);
            uriBuilder.addParameter(USERNAME, username);
            HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = getJsonReader(response);
                UserBean user = gson.fromJson(jsonReader, UserBean.class);
                method.releaseConnection();
                return user;
            }
            else if(statusCode == HttpURLConnection.HTTP_UNAUTHORIZED || statusCode == HttpURLConnection.HTTP_FORBIDDEN ){
                return null;
            }
            else {
                RestException restException = new RestException(response);
                response.close();
                method.releaseConnection();
                throw restException;
            }
        });
    }

    @Override
    public Future<UserBean> getUserByKey(String key) {
        return null;
    }
}
