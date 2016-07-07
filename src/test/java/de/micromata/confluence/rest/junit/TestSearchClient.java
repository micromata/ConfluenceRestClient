package de.micromata.confluence.rest.junit;

import de.micromata.confluence.rest.client.SearchClient;
import de.micromata.confluence.rest.core.cql.CqlBuilder;
import de.micromata.confluence.rest.core.cql.CqlSearchBean;
import de.micromata.confluence.rest.core.cql.EField;
import de.micromata.confluence.rest.core.cql.EOperator;
import de.micromata.confluence.rest.core.domain.cql.CqlSearchResult;
import de.micromata.confluence.rest.core.misc.ExpandField;
import org.junit.Assert;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 06.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class TestSearchClient extends BaseTest {

    @Test
    public void testSearchContent() throws URISyntaxException, ExecutionException, InterruptedException {
        SearchClient searchClient = confluenceRestClient.getSearchClient();
        CqlBuilder cqlBuilder = new CqlBuilder();
        String cql = cqlBuilder.addCondition(EField.SPACE, EOperator.EQUALS, "DEMO").build();
        CqlSearchBean searchBean = new CqlSearchBean();
        List<String> expand = new ArrayList<>();
        expand.add(ExpandField.BODY_VIEW.getName());
        searchBean.setCql(cql);
        searchBean.setExpand(expand);
        Future<CqlSearchResult> future = searchClient.searchContent(searchBean);
        CqlSearchResult cqlSearchResult = future.get();
        Assert.assertNotNull(cqlSearchResult);
    }
}
