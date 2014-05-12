import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by zhao lin on 4/18/2014.
 */
public class UserDaoTest {
    @Resource
    private UserDao userDao = new UserDao();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetUsernameById() throws Exception {
        // todo
//        Assert.assertEquals("Namy", userDao.getUsernameById("89ee97a2455ee2f601455ee2f75c0000"));


    }
}
