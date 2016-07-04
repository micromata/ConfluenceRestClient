package de.micromata.confluence.rest.junit;

import de.micromata.confluence.rest.client.ContentClient;
import de.micromata.confluence.rest.core.domain.content.ContentBean;
import de.micromata.confluence.rest.core.domain.content.ContentResultsBean;
import de.micromata.confluence.rest.core.misc.ContentStatus;
import de.micromata.confluence.rest.core.misc.ContentType;
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
 * Date: 04.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class TestContentClient extends BaseTest {

    @Test
    public void testGetContent() throws URISyntaxException, ExecutionException, InterruptedException {
        String spacekey = "DEMO";
        String title = "";
        ContentClient contentClient = confluenceRestClient.getContentClient();
        Future<ContentResultsBean> future = contentClient.getContent(ContentType.PAGE, spacekey, title, ContentStatus.ANY, null, null, 0, 0);
        ContentResultsBean contentResultsBean = future.get();
        Assert.assertNotNull(contentResultsBean);
    }


    @Test
    public void testGetContentById() throws ExecutionException, InterruptedException {
        String id = "851970";
        List<String> expands = new ArrayList<>();
        expands.add(ExpandField.BODY_VIEW.getName());
        expands.add(ExpandField.RESTRICTIONS.getName());
        ContentClient contentClient = confluenceRestClient.getContentClient();
        Future<ContentBean> future = contentClient.getContentById(id, 0, expands);
        ContentBean contentBean = future.get();
        Assert.assertNotNull(contentBean);
    }
}
