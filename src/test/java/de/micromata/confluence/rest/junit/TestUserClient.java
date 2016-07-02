package de.micromata.confluence.rest.junit;

import de.micromata.confluence.rest.client.UserClient;
import de.micromata.confluence.rest.core.domain.UserBean;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by cschulc on 01.07.2016.
 */
public class TestUserClient extends BaseTest {

    public static final String ANONYMOUS = "Anonymous";

    @Test
    public void testGetUserByUsernameAndbyKey() throws IOException, ExecutionException, InterruptedException, URISyntaxException {
        UserClient userClient = confluenceRestClient.getUserClient();
        Future<UserBean> futureByUsername = userClient.getUserByUsername(USERNAME_TO_SEARCH);
        UserBean userBeanByUsername = futureByUsername.get();
        Assert.assertNotNull(userBeanByUsername);
        String userKey = userBeanByUsername.getUserKey();
        Future<UserBean> futureByKey = userClient.getUserByKey(userKey);
        UserBean userBeanByKey = futureByKey.get();
        Assert.assertNotNull(userBeanByKey);
        Assert.assertEquals(userBeanByKey.getUsername(), userBeanByUsername.getUsername());
        Assert.assertEquals(userBeanByKey.getUserKey(), userBeanByUsername.getUserKey());
    }

    @Test
    public void testGetCurrentUser() throws URISyntaxException, ExecutionException, InterruptedException {
        UserClient userClient = confluenceRestClient.getUserClient();
        Future<UserBean> future = userClient.getCurrentUser();
        UserBean userBean = future.get();
        Assert.assertNotNull(userBean);
        Assert.assertEquals(userBean.getUsername(), USERNAME_TO_SEARCH);
    }

    @Test
    public void testGetAnonymousUser() throws URISyntaxException, ExecutionException, InterruptedException {
        UserClient userClient = confluenceRestClient.getUserClient();
        Future<UserBean> future = userClient.getAnonymousUser();
        UserBean userBean = future.get();
        Assert.assertNotNull(userBean);
        Assert.assertEquals(userBean.getDisplayName(), ANONYMOUS);
    }
}
