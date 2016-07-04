package de.micromata.confluence.rest.core;

import com.google.gson.stream.JsonReader;
import de.micromata.confluence.rest.ConfluenceRestClient;
import de.micromata.confluence.rest.client.ContentClient;
import de.micromata.confluence.rest.core.domain.content.ContentBean;
import de.micromata.confluence.rest.core.domain.content.ContentResultsBean;
import de.micromata.confluence.rest.core.misc.ContentStatus;
import de.micromata.confluence.rest.core.misc.ContentType;
import de.micromata.confluence.rest.core.misc.RestException;
import de.micromata.confluence.rest.core.util.HttpMethodFactory;
import de.micromata.confluence.rest.core.util.URIHelper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 04.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class ContentClientImpl extends BaseClient implements ContentClient {

    public SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public ContentClientImpl(ConfluenceRestClient confluenceRestClient, ExecutorService executorService) {
        super(confluenceRestClient, executorService);
    }

    @Override
    public Future<ContentBean> getContentById(String id, int version, List<String> expand) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = URIHelper.buildPath(baseUri, CONTENT, id);
            if(version > 0){
                uriBuilder.addParameter(VERSION, String.valueOf(version));
            }
            if(CollectionUtils.isNotEmpty(expand) == true){
                String join = StringUtils.join(expand, ",");
                uriBuilder.addParameter(EXPAND, join);
            }
            HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = getJsonReader(response);
                ContentBean result = gson.fromJson(jsonReader, ContentBean.class);
                method.releaseConnection();
                return result;
            } else if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED || statusCode == HttpURLConnection.HTTP_FORBIDDEN) {
                return null;
            } else {
                RestException restException = new RestException(response);
                response.close();
                method.releaseConnection();
                throw restException;
            }
        });
    }

    @Override
    public Future<ContentResultsBean> getContent(ContentType type, String spacekey, String title, ContentStatus status, Date postingDay, List<String> expand, int start, int limit) throws URISyntaxException {
        URIBuilder uriBuilder = URIHelper.buildPath(baseUri, CONTENT);
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        if(type != null){
            nameValuePairs.add(new BasicNameValuePair(TYPE, type.getName()));
        }
        if(StringUtils.trimToNull(spacekey) != null){
            nameValuePairs.add(new BasicNameValuePair(SPACEKEY, spacekey));
        }
        if(StringUtils.trimToNull(title) != null){
            nameValuePairs.add(new BasicNameValuePair(TITLE, title));
        }
        if(status != null){
            nameValuePairs.add(new BasicNameValuePair(STATUS, status.getName()));
        }
        if(postingDay != null){
            nameValuePairs.add(new BasicNameValuePair(POSTING_DAY, sdf.format(postingDay)));
        }
        if(expand != null && expand.isEmpty() == false){
            String join = StringUtils.join(expand, ",");
            nameValuePairs.add(new BasicNameValuePair(EXPAND, join));
        }
        if(start > 0){
            nameValuePairs.add(new BasicNameValuePair(START, String.valueOf(start)));
        }
        if(limit > 0){
            nameValuePairs.add(new BasicNameValuePair(LIMIT, String.valueOf(limit)));
        }
        uriBuilder.addParameters(nameValuePairs);
        return executorService.submit(() -> {
            HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = getJsonReader(response);
                ContentResultsBean result = gson.fromJson(jsonReader, ContentResultsBean.class);
                method.releaseConnection();
                return result;
            } else if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED || statusCode == HttpURLConnection.HTTP_FORBIDDEN) {
                return null;
            } else {
                RestException restException = new RestException(response);
                response.close();
                method.releaseConnection();
                throw restException;
            }
        });
    }
}
