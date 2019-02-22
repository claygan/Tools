package com.quest.test.json.tools;

/**
 * Created by sixtynine on 2017/4/24.
 */
public class ResponseBean<T> {
    private int code;
    private String msg;
    private T body;

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
