package com.tonyben1991.dao;

import com.tonyben1991.bean.Car;
import com.tonyben1991.bean.User;

import java.util.LinkedList;

/**
 * @author oaec
 * @date 2018-05-16
 **/
public interface CarDao {

    /**
     * da
     *
     * @return da
     */
    LinkedList<Car> checkAllCars();
}
