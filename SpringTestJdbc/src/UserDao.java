import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Types;

/**
 * Created by zhao lin on 4/18/2014.
 */
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    @Value("testing........")
    private String testStr;

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    //    public User getUserById(String id){
//        User user = new User();
//        user = getJdbcTemplate().???????????????????
//    }

    public String getUsernameById(String id){
        String sql = "select username from user where id = ?";
        Object[] objs = new Object[]{id};
        JdbcTemplate template = this.getJdbcTemplate();
        String name = (String) template.queryForObject(sql, objs, String.class);
        return name;
    }

    public void insertUser(User user){
        String sql = "insert into user (id, username, password, createTime, expireTime) values (?, ?, ?, ?, ?)";
        Object[] objects = new Object[]{user.getId(), user.getUsername(), user.getPassword(), user.getCreateTime(), user.getExpireTime()};
        int[] types = new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.DATE, Types.DATE};
        JdbcTemplate template = this.getJdbcTemplate();
        try{
            template.update(sql, objects, types);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Insertion execution complete.");
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    @Qualifier("jdbcTemplate")
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
