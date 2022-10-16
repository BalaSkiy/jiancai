package com.xxx.entity.vo;

public class MessageModel {

    private Integer code = 1;//状态码
    private String msg="成功";//提示信息
    private Object object;//回显对象（基本数据类型，字符串类型，List、Map等）

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
