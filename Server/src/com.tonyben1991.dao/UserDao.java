package com.tonyben1991.dao;

import com.tonyben1991.bean.User;
import com.tonyben1991.utils.DbHelper;

/**
 * @author oaec
 * @date 2018-05-16
 **/
public interface UserDao {
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
     * @return 添加成功返回true, 失败返回false
     */
    Boolean addUser(User user);

    /**
     * 修改用户密码
     *
     * @param user
     * @return 成功返回true, 失败返回false
     */
    boolean modifyPassword(User user);
}
