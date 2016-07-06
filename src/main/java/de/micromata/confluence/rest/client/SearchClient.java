package de.micromata.confluence.rest.client;

import de.micromata.confluence.rest.core.cql.CqlSearchBean;
import de.micromata.confluence.rest.core.domain.cql.CqlSearchResult;

import java.net.URISyntaxException;
import java.util.concurrent.Future;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 04.07.2016
 * Project: ConfluenceTransferPlugin
 */
public interface SearchClient {

    Future<CqlSearchResult> searchContent(CqlSearchBean searchBean) throws URISyntaxException;
}
