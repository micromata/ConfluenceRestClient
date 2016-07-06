package de.micromata.confluence.rest.junit;

import de.micromata.confluence.rest.client.SearchClient;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 06.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class TestSearchClient extends BaseTest{

    public void testSearchContent(){
        SearchClient searchClient = confluenceRestClient.getSearchClient();
    }
}
