package com.tonyben1991.bizimpl;

import com.tonyben1991.bean.Car;
import com.tonyben1991.bean.User;
import com.tonyben1991.biz.CarBiz;
import com.tonyben1991.biz.UserBiz;

import java.util.LinkedList;

/**
 * @author oaec
 * @date 2018-05-16
 **/
public class CarBizImpl implements CarBiz {

    @Override
    public LinkedList<Car> checkAllCars() {
        return carDao.checkAllCars();
    }
}
