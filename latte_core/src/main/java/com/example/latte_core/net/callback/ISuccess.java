package com.example.latte_core.net.callback;

@FunctionalInterface
public interface ISuccess {

    /**
     * 返回成功
     * @param response  传入response
     */
    void onSuccess(String response);
}
