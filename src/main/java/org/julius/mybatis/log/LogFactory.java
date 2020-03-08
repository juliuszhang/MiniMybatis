package org.julius.mybatis.log;

import org.julius.mybatis.exception.LogException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @date: 2020/3/8
 * @author: yibozhang
 */
public class LogFactory {

    public static final String MARKER = "MiniMybatis";

    private static Constructor<? extends Log> logConstructor;

    private LogFactory() {
    }

    static {

    }

    public static Log getLog(Class<?> clazz) {

    }

    public static Log getLog(String logger) {
        try {
            return logConstructor.newInstance(logger);
        } catch (Exception e) {
            throw new LogException("Error creating logger for logger " + logger + ".  Cause: " + e, e);
        }
    }

}
