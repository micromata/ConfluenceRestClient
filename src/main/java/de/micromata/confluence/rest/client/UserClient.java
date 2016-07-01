package de.micromata.confluence.rest.client;

import de.micromata.confluence.rest.core.domain.UserBean;

/**
 * Created by cschulc on 01.07.2016.
 */
public interface UserClient {

    UserBean getUserByUsername(String username);

    UserBean getUserByKey(String key);
}
