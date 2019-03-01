package com.example.latte_core.net.callback;

public interface IError {

    /**
     * 返回错误
     * @param code
     * @param msg
     */
    void onError(int code,String msg);
}
