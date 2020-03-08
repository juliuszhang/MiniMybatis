package org.julius.mybatis.datasource;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * @author yibozhang
 * @date 2020/3/7 3:31 下午
 */
public class UnPooledDataSource implements DataSource {

    private Properties driverProperties;

    private static final Map<String, Driver> REGISTERED_DRIVERS = new ConcurrentHashMap<>();

    private String driver;

    private String url;

    private String username;

    private String password;

    /**
     * 其他的一些额外设置
     */
    private Boolean autoCommit;

    private Integer defaultTransactionIsolationLevel;

    private Integer defaultNetworkTimeout;

    static {
        //将当前classpath下的所有driver都注册到map中管理
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            REGISTERED_DRIVERS.put(driver.getClass().getName(), driver);
        }
    }

    public UnPooledDataSource() {
    }

    public UnPooledDataSource(String driver, String url, String username, String password) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
    }


    @Override
    public Connection getConnection() throws SQLException {
        return this.getConnection(this.username, this.password);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        Properties props = new Properties();
        if (driverProperties != null) props.putAll(props);
        if (username != null) props.setProperty("user", username);
        if (password != null) props.setProperty("password", password);
        Connection connection = DriverManager.getConnection(this.url, props);
        configureConnection(connection);
        return connection;
    }

    private void configureConnection(Connection connection) throws SQLException {
        if (defaultNetworkTimeout != null) {
            connection.setNetworkTimeout(Executors.newSingleThreadExecutor(), this.defaultNetworkTimeout);
        }
        if (autoCommit != null) {
            connection.setAutoCommit(autoCommit);
        }

        if (defaultTransactionIsolationLevel != null) {
            connection.setTransactionIsolation(defaultTransactionIsolationLevel);
        }
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return DriverManager.getLogWriter();
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        DriverManager.setLogWriter(out);
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        DriverManager.setLoginTimeout(seconds);
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return DriverManager.getLoginTimeout();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
