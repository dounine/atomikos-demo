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

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("admin");
        userService.register(user);
    }
}
