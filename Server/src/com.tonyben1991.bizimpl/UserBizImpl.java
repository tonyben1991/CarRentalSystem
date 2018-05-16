package com.tonyben1991.bizimpl;

import com.tonyben1991.bean.User;
import com.tonyben1991.biz.UserBiz;
import com.tonyben1991.dao.UserDao;
import com.tonyben1991.daoimpl.UserDaoImpl;

/**
 * @author oaec
 * @date 2018-05-16
 **/
public class UserBizImpl implements UserBiz {
    UserDao userDao;

    public UserBizImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public int login(User user) {
        int result = 0;
        User userTemp = getUserByName(user);
        if (null == userTemp) {
            result = -1;
        } else if (user.getPassword().equals(userTemp.getPassword())) {
            result = 1;
        }
        return result;
    }

    @Override
    public User getUserByName(User user) {
        return userDao.getUserByName(user);
    }

    @Override
    public boolean register(User user) {
        boolean result = false;
        User userTemp = getUserByName(user);
        if (null != userTemp) {
            result = false;
        } else {
            result = userDao.addUser(user);
        }
        return result;
    }

    @Override
    public boolean modifyPassword(User user) {
        return false;
    }
}
