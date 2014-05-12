import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by zhao lin on 4/18/2014.
 */
public class MainApp {

    public static void main(String[] args){
        System.out.println("damnyou...........");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");

        UserDao userDao;
        userDao = (UserDao) ctx.getBean("userDao");
        String name = userDao.getUsernameById("89ee97a2455ee2f601455ee2f75c0000");
        System.out.println("Name is: " + name);

        System.out.print(userDao.getTestStr());

        // prepare for User insertion
        User user = new User();
        user.setId("xx00xx00_" + new Integer(new Date().getMinutes()).toString());
        user.setUsername("Test_" + new Integer(new Date().getMinutes()).toString());
        user.setPassword("4321");
        user.setCreateTime(new Date());
        user.setExpireTime(new Date());

        //
        // insert user
//        userDao.insertUser(user);
        //userDao.i



    }
}
