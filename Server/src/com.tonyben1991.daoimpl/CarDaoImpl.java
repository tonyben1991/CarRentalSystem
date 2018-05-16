package com.tonyben1991.daoimpl;

import com.tonyben1991.bean.Car;
import com.tonyben1991.bean.TableInfo;
import com.tonyben1991.bean.User;
import com.tonyben1991.dao.CarDao;
import com.tonyben1991.dao.UserDao;
import com.tonyben1991.utils.DbHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * @author oaec
 * @date 2018-05-16
 **/
public class CarDaoImpl implements CarDao {
    private Connection connection;

    public CarDaoImpl() {
        connection = new DbHelper().getConnection();
    }

    @Override
    public LinkedList<Car> checkAllCars() {
        LinkedList<Car> cars = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT " +
                TableInfo.Car.ID + "," +
                TableInfo.Car.CAR_NUMBER + "," +
                TableInfo.Brand.NAME + "," + //TableInfo.Car.BRAND_ID + "," +
                TableInfo.Car.MODEL + "," +
                TableInfo.Car.COLOR + "," +
                TableInfo.Category.NAME + "," + //TableInfo.Car.CATEGORY_ID + "," +
                TableInfo.Car.COMMENTS + "," +
                TableInfo.Car.PRICE + "," +
                TableInfo.Car.RENT + "," +
                TableInfo.Car.STATUS + "," +
                TableInfo.Car.USEABLE +
                " FROM " + TableInfo.Car.TABLE + "," + TableInfo.Brand.TABLE + "," + TableInfo.Category.TABLE +
                " WHERE " + TableInfo.Brand.ID + "=" + TableInfo.Car.BRAND_ID + " AND " +
                TableInfo.Category.ID + "=" + TableInfo.Car.CATEGORY_ID;
        System.out.println(sql);
        try {

            try {
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                if (resultSet != null) {
                    while (resultSet.next()) {
//                        cars.add(new Car(
//                            resultSet.getInt(TableInfo.Car.ID),
//                            resultSet.getString(TableInfo.Car.CAR_NUMBER),
//                            resultSet.getString(TableInfo.Brand.NAME),
//                            resultSet.getString(TableInfo.Car.MODEL),
//                            resultSet.getString(TableInfo.Car.COLOR),
//                            resultSet.getString(TableInfo.Category.NAME),
//                            resultSet.getString(TableInfo.Car.COMMENTS),
//                            resultSet.getDouble(TableInfo.Car.PRICE),
//                            resultSet.getDouble(TableInfo.Car.RENT),
//                            resultSet.getInt(TableInfo.Car.STATUS),
//                            resultSet.getInt(TableInfo.Car.USEABLE)
//                        ));
                        cars.add(new Car(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6),
                                resultSet.getString(7),
                                resultSet.getDouble(8),
                                resultSet.getDouble(9),
                                resultSet.getInt(10),
                                resultSet.getInt(11)
                        ));
                    }
                }
            } finally {
                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                    resultSet = null;
                }
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                    ;
                    preparedStatement = null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
