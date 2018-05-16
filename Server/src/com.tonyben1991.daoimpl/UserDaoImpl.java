package com.tonyben1991.daoimpl;

import com.tonyben1991.bean.TableInfo;
import com.tonyben1991.bean.User;
import com.tonyben1991.dao.UserDao;
import com.tonyben1991.utils.DbHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author oaec
 * @date 2018-05-16
 **/
public class UserDaoImpl implements UserDao {
    private Connection connection;

    public UserDaoImpl() {
        connection = new DbHelper().getConnection();
    }

    @Override
    public User getUserByName(User user) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT " +
                TableInfo.User.ID + "," +
                TableInfo.User.USER_NAME + "," +
                TableInfo.User.PASSWORD + "," +
                TableInfo.User.GENDER + "," +
                TableInfo.User.ID_NUMBER + "," +
                TableInfo.User.TELEPHONE + "," +
                TableInfo.User.ADDRESS + "," +
                TableInfo.User.TYPE +
                " FROM " + TableInfo.User.TABLE + " WHERE " + TableInfo.User.USER_NAME + "=?";
        try {

            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getUserName());
                resultSet = preparedStatement.executeQuery();
                if (resultSet != null && resultSet.next()) {
                    user = new User(
                            resultSet.getInt(TableInfo.User.ID),
                            resultSet.getString(TableInfo.User.USER_NAME),
                            resultSet.getString(TableInfo.User.PASSWORD),
                            resultSet.getInt(TableInfo.User.GENDER),
                            resultSet.getString(TableInfo.User.ID_NUMBER),
                            resultSet.getString(TableInfo.User.TELEPHONE),
                            resultSet.getString(TableInfo.User.ADDRESS),
                            resultSet.getInt(TableInfo.User.TYPE)
                    );
                } else {
                    user = null;
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
        return user;
    }

    @Override
    public Boolean addUser(User user) {
        PreparedStatement preparedStatement = null;
        int result = 0;
        String sql = "INSERT INTO " + TableInfo.User.TABLE + "(" +
                TableInfo.User.ID + "," +
                TableInfo.User.USER_NAME + "," +
                TableInfo.User.PASSWORD + "," +
                TableInfo.User.GENDER + "," +
                TableInfo.User.ID_NUMBER + "," +
                TableInfo.User.TELEPHONE + "," +
                TableInfo.User.ADDRESS + "," +
                TableInfo.User.TYPE +
                ")" + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, new DbHelper().getSeqNextVal(TableInfo.User.SEQ));
                preparedStatement.setString(2, user.getUserName());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.setInt(4, user.getGender());
                preparedStatement.setString(5, user.getIdNumber());
                preparedStatement.setString(6, user.getTelephone());
                preparedStatement.setString(7, user.getAddress());
                preparedStatement.setInt(8, 0);
                result = preparedStatement.executeUpdate();

            } finally {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                    ;
                    preparedStatement = null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result > 0;
    }

    @Override
    public boolean modifyPassword(User user) {
        return false;
    }
}
