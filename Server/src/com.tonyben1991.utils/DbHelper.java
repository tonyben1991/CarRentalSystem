package com.tonyben1991.utils;

import com.tonyben1991.bean.DbConfig;

import java.sql.*;

/**
 * @author oaec
 * @date 2018-05-14
 **/
public class DbHelper {
    private Connection connection;
    private DbConfig dbConfig;

    public DbHelper() {
        dbConfig = new ConfigReader().readDbConfig();
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(dbConfig.getDriver());
                connection = DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUser(), dbConfig.getPassword());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getSeqNextVal(String seq) {
        int result = 0;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT " + seq + ".nextval " + "FROM DUAL";
        try {
            try {
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                if (resultSet != null && resultSet.next()) {
                    result = resultSet.getInt(1);
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
        return result;
    }
}
