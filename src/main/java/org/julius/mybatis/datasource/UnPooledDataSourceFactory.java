package org.julius.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author yibozhang
 * @date 2020/3/7 3:30 下午
 */
public class UnPooledDataSourceFactory implements DataSourceFactory {

    protected DataSource dataSource;

    public UnPooledDataSourceFactory() {
        this.dataSource = new UnPooledDataSource();
    }

    @Override
    public void setProperties(Properties props) {

    }

    @Override
    public DataSource getDataSource() {
        return null;
    }
}
