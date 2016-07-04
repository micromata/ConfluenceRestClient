package de.micromata.confluence.rest.junit;

import de.micromata.confluence.rest.client.SpaceClient;
import de.micromata.confluence.rest.core.domain.space.ResultsBean;
import de.micromata.confluence.rest.core.domain.space.SpaceBean;
import de.micromata.confluence.rest.core.misc.SpaceStatus;
import de.micromata.confluence.rest.core.misc.SpaceType;
import org.junit.Assert;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 04.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class TestSpaceClient extends BaseTest {

    private static final String SPACE_KEY_TO_SEARCH = "DEMO";

    @Test
    public void testGetSpaces() throws URISyntaxException, ExecutionException, InterruptedException {
        List<String> spaceKeys = new ArrayList<>();
        spaceKeys.add("DEMO");
        List<String> labels = new ArrayList<>();
        List<String> expand  = new ArrayList<>();
        SpaceClient spaceClient = confluenceRestClient.getSpaceClient();
        Future<ResultsBean> future = spaceClient.getSpaces(spaceKeys, SpaceType.GLOBAL, SpaceStatus.CURRENT, labels, expand, 0, 0);
        ResultsBean resultsBean = future.get();
        Assert.assertNotNull(resultsBean);
    }

    @Test
    public void testGetSpaceByKey() throws ExecutionException, InterruptedException {
        SpaceClient spaceClient = confluenceRestClient.getSpaceClient();
        Future<SpaceBean> future = spaceClient.getSpaceByKey("DEMO", null);
        SpaceBean spaceBean = future.get();
        Assert.assertNotNull(spaceBean);
        Assert.assertEquals(spaceBean.getKey(), SPACE_KEY_TO_SEARCH);
    }
}
