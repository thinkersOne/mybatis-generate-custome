package com.baomidou.service;

/**
 *
 */
public enum EnumRmsVehicleErrorCode {
    OK(1, "成功"),
    NOT_NULL(-10000, "不能为空!"),
    NAME_NOT_NULL(-10001, "名称不能为空!"),
    CODE_NOT_NULL(-10002, "编码不能为空!");
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    EnumRmsVehicleErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}