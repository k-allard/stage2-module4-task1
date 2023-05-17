package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() {
        Properties props = new Properties();
        try (InputStream input = H2ConnectionFactory.class.getClassLoader()
                .getResourceAsStream("h2database.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Class.forName(props.getProperty("jdbc_driver"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = props.getProperty("db_url");
        String username = props.getProperty("user");
        String password = props.getProperty("password");
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

