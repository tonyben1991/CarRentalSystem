package com.tonyben1991.utils;

import com.tonyben1991.bean.DbConfig;

import java.io.IOException;
import java.util.Properties;

/**
 * @author oaec
 * @date 2018-05-14
 **/
public class ConfigReader {
    public DbConfig readDbConfig() {
        Properties properties = new Properties();
        try {
            properties.load(ConfigReader.class.getClassLoader().getResourceAsStream("config/db_config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new DbConfig(
                properties.getProperty("driver"),
                properties.getProperty("url"),
                properties.getProperty("user"),
                properties.getProperty("password")
        );
    }
}
