package de.micromata.confluence.rest.client;

import de.micromata.confluence.rest.core.domain.UserBean;

import java.net.URISyntaxException;
import java.util.concurrent.Future;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 01.07.2016
 * Project: ConfluenceTransferPlugin
 */
public interface UserClient {

    /**
     * Get the confluence user by username (example: admin)
     *
     * @param username the username
     * @return Future with the UserBean
     */
    Future<UserBean> getUserByUsername(String username) throws URISyntaxException;

    /**
     * Get the confluence user by key (example: 402880824ff933a4014ff9345d7c0002)
     *
     * @param key the key
     * @return Future with the UserBean
     */
    Future<UserBean> getUserByKey(String key) throws URISyntaxException;

    /**
     * Get the current logged in user
     *
     * @return Future with the UserBean
     */
    Future<UserBean> getCurrentUser() throws URISyntaxException;

    /**
     * Get the Anonymous User
     *
     * @return Future with the UserBean
     */
    Future<UserBean> getAnonymousUser() throws URISyntaxException;
}
