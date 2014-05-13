import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by zhao lin on 5/12/2014.
 */
@Aspect
public class Guard {

    private String userId;

    @Pointcut( "execution(* UserDao.getUsernameById(String)) && args(userId)")
    public void getUsernameById(String userId){}

    @Before("getUsernameById(userId)")
    public void checkUser(String userId){
        this.userId = userId;
        System.out.println("Stop! Who are you?");
    }

    @After("getUsernameById(userId)")
    public void letGo(String userId){
        this.userId = userId;
        System.out.println("Let me check your id....." + userId + ".....");
        System.out.println("OK, you can go now.");
    }
}
