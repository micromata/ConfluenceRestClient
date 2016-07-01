package de.micromata.confluence.rest.junit;

import de.micromata.confluence.rest.core.domain.UserBean;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by cschulc on 01.07.2016.
 */
public class TestUserClient extends BaseTest {

    @Test
    public void testGetUserByUsername() throws IOException, ExecutionException, InterruptedException {
        Future<UserBean> future = confluenceRestClient.getUserClient().getUserByUsername(USERNAME_TO_SEARCH);
        UserBean userBean = future.get();
        Assert.assertNotNull(userBean);
    }
}
