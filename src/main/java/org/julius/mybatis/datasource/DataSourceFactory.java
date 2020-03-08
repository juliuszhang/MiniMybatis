package org.julius.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author yibozhang
 * @date 2020/3/7 3:27 下午
 */
public interface DataSourceFactory {

    /**
     * 设置 DataSource的属性
     *
     * @param props
     */
    void setProperties(Properties props);

    /**
     * 获得DataSource
     * @return
     */
    DataSource getDataSource();
}
