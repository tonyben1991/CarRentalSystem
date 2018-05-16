package com.tonyben1991.biz;

import com.tonyben1991.bean.User;
import com.tonyben1991.dao.UserDao;
import com.tonyben1991.daoimpl.UserDaoImpl;

/**
 * @author oaec
 * @date 2018-05-16
 **/
public interface UserBiz {

    /**
     * @param user
     * @return
     */
    int login(User user);

    /**
     * 根据用户名查找用户
     *
     * @param user
     * @return 返回查找到的用户
     */
    User getUserByName(User user);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    boolean register(User user);

    /**
     * 修改用户密码
     *
     * @param user
     * @return 成功返回true, 失败返回false
     */
    boolean modifyPassword(User user);


}
