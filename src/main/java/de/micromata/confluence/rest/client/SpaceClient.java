package de.micromata.confluence.rest.client;

import de.micromata.confluence.rest.core.domain.space.SpaceResultsBean;
import de.micromata.confluence.rest.core.domain.space.SpaceBean;
import de.micromata.confluence.rest.core.misc.SpaceStatus;
import de.micromata.confluence.rest.core.misc.SpaceType;

import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Client to recieve spaces from a confluence server.
 *
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 02.07.2016
 * Project: ConfluenceTransferPlugin
 */
public interface SpaceClient {

    /**
     * Get a ResultBean with spaces filtered by the given arguments
     * Every parameter can be NULL, then you get all spaces
     *
     * @param keys a list of space keys
     * @param type filter the list of spaces returned by type (global, personal)
     * @param status filter the list of spaces returned by status (current, archived)
     * @param label filter the list of spaces returned by label
     * @param expand a comma separated list of properties to expand on the spaces
     * @param start the start point of the collection to return
     * @param limit the limit of the number of spaces to return, this may be restricted by fixed system limits
     * @return Future with the ResultBean
     */
   Future<SpaceResultsBean> getSpaces(List<String> keys, SpaceType type, SpaceStatus status, List<String> label, List<String> expand, int start, int limit) throws URISyntaxException;

    /**
     * Get a SpaceBean for the given key
     *
     * @param key the key
     * @param expand a comma separated list of properties to expand on the spaces
     * @return Future with the SpaceBean
     */
    Future<SpaceBean> getSpaceByKey(String key, List<String> expand);
}
