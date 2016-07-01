package de.micromata.confluence.rest.client;

import de.micromata.confluence.rest.core.domain.UserBean;

import java.util.concurrent.Future;

/**
 * Created by cschulc on 01.07.2016.
 */
public interface UserClient {

    Future<UserBean> getUserByUsername(String username);

    Future<UserBean> getUserByKey(String key);
}
