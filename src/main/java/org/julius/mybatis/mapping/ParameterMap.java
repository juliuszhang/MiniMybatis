package org.julius.mybatis.mapping;

/**
 * @date: 2020/3/8
 * @author: yibozhang
 */
public class ParameterMap {

    private String id;

    private Class<?> type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }
}
