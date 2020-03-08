package org.julius.mybatis.executor;

import org.julius.mybatis.mapping.MappedStatement;
import org.julius.mybatis.result.ResultHandler;
import org.julius.mybatis.result.RowBounds;

import java.sql.SQLException;
import java.util.List;

/**
 * @date: 2020/3/8
 * @author: yibozhang
 */
public interface Executor {

    int update(MappedStatement ms, Object parameter) throws SQLException;

    <R> List<R> query(MappedStatement ms, Object parameter, ResultHandler resultHandler);

    <R> List<R> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler);

    void commit(boolean required) throws SQLException;

    void rollback(boolean required) throws SQLException;

    void close(boolean forceRollback);

    boolean isClosed();

}
