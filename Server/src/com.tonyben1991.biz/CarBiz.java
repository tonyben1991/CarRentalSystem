package com.tonyben1991.biz;

import com.tonyben1991.bean.Car;
import com.tonyben1991.bean.User;
import com.tonyben1991.dao.CarDao;
import com.tonyben1991.dao.UserDao;
import com.tonyben1991.daoimpl.CarDaoImpl;
import com.tonyben1991.daoimpl.UserDaoImpl;

import java.util.LinkedList;

/**
 * @author oaec
 * @date 2018-05-16
 **/
public interface CarBiz {
    CarDao carDao = new CarDaoImpl();

    /**
     * 查看所有车
     *
     * @return 返回所有车的链表
     */
    LinkedList<Car> checkAllCars();
}
