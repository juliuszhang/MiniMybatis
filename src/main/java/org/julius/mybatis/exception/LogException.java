package org.julius.mybatis.exception;

/**
 * @date: 2020/3/8
 * @author: yibozhang
 */
public class LogException extends MiniMybatisException {

    public LogException() {
    }

    public LogException(String message) {
        super(message);
    }

    public LogException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogException(Throwable cause) {
        super(cause);
    }
}
