package com.dounine.jta.dao;

import com.atomikos.icatch.RollbackException;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.dounine.jta.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;

/**
 * Created by huanghuanlai on 2016/11/14.
 */
@Repository
public class UserDao implements IUserDao {

    @Resource(name = "jdbcTemplateMaster")
    protected JdbcTemplate jdbcTemplateMaster;
    @Resource(name = "jdbcTemplateSlave")
    protected JdbcTemplate jdbcTemplateSlave;
    @Autowired
    protected UserTransactionManager transactionManager;

    @Transactional(readOnly=false,rollbackFor=Exception.class,value="jtaTransactionManager")
    public void save(User user) throws Exception {
        try {
            transactionManager.begin();
            //主库
            jdbcTemplateMaster.execute("INSERT INTO USER (username) VALUES ('"+user.getUsername()+"')");
            //从库
            jdbcTemplateSlave.execute("INSERT INTO USER (username) VALUES ('"+user.getUsername()+"')");

            if(true){
                throw new Exception("DaoException");
            }
            transactionManager.commit();
        } catch (NotSupportedException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        }
    }

}
