package de.micromata.confluence.rest.core;

import com.google.gson.stream.JsonReader;
import de.micromata.confluence.rest.ConfluenceRestClient;
import de.micromata.confluence.rest.client.SearchClient;
import de.micromata.confluence.rest.core.cql.CqlSearchBean;
import de.micromata.confluence.rest.core.domain.cql.CqlSearchResult;
import de.micromata.confluence.rest.core.misc.RestException;
import de.micromata.confluence.rest.core.util.HttpMethodFactory;
import de.micromata.confluence.rest.core.util.URIHelper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 06.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class SearchClientImpl extends BaseClient implements SearchClient {

    public SearchClientImpl(ConfluenceRestClient confluenceRestClient, ExecutorService executorService) {
        super(confluenceRestClient, executorService);
    }

    @Override
    public Future<CqlSearchResult> searchContent(CqlSearchBean searchBean) throws URISyntaxException {
        Validate.notNull(searchBean);
        Validate.notNull(StringUtils.trimToNull(searchBean.getCql()));

        String cql = searchBean.getCql();
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair(CQL, cql));
        if(StringUtils.trimToNull(searchBean.getCqlcontext()) != null){
            nameValuePairs.add(new BasicNameValuePair(CQL_CONTEXT, searchBean.getCqlcontext()));
        }
        if(searchBean.getExcerpt() != null){
            nameValuePairs.add(new BasicNameValuePair(EXCERPT, searchBean.getExcerpt().getName()));
        }
        if(CollectionUtils.isNotEmpty(searchBean.getExpand()) == true){
            String join = StringUtils.join(searchBean.getExpand(), ",");
            nameValuePairs.add(new BasicNameValuePair(EXPAND, join));
        }
        if(searchBean.getStart() > 0){
            nameValuePairs.add(new BasicNameValuePair(START, String.valueOf(searchBean.getStart())));
        }
        if(searchBean.getLimit() > 0){
            nameValuePairs.add(new BasicNameValuePair(LIMIT, String.valueOf(searchBean.getLimit())));
        }
        URIBuilder uriBuilder = URIHelper.buildPath(baseUri, SEARCH).addParameters(nameValuePairs);
        return executorService.submit(() -> {
            HttpGet method = HttpMethodFactory.createGetMethod(uriBuilder.build());
            CloseableHttpResponse response = client.execute(method, clientContext);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = getJsonReader(response);
                CqlSearchResult result = gson.fromJson(jsonReader, CqlSearchResult.class);
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
