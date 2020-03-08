package org.julius.mybatis.exception;

/**
 * @date: 2020/3/8
 * @author: yibozhang
 */
public class MiniMybatisException extends RuntimeException {

    public MiniMybatisException() {
    }

    public MiniMybatisException(String message) {
        super(message);
    }

    public MiniMybatisException(String message, Throwable cause) {
        super(message, cause);
    }

    public MiniMybatisException(Throwable cause) {
        super(cause);
    }
}
