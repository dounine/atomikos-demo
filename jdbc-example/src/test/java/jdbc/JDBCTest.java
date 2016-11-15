package jdbc;

import com.dounine.jta.entity.User;
import com.dounine.jta.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by huanghuanlai on 2016/11/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyConfiguration.class)
public class JDBCTest {

    @Autowired
    private IUserService userService;

    /**
     * 此方法会执行会抛出DaoException异常,但是两个库的表并不会插入数据
     * 要想成功插入可把UserDao中的异常代码处删除,两个数据库可正常插入数据
     */
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("admin");
        userService.register(user);
    }
}
