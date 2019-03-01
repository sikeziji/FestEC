package com.example.latte_core.net;

import com.example.latte_core.net.callback.IError;
import com.example.latte_core.net.callback.IFailure;
import com.example.latte_core.net.callback.IRequest;
import com.example.latte_core.net.callback.ISuccess;

import java.util.Map;

import okhttp3.RequestBody;

public class RestClient {

    //URL
    private final String URL;
    //参数
    private final Map<String,Object> PARAMS;

    private final IRequest REQUEST;

    private final ISuccess SUCCESS;

    private final IFailure FAILURE;

    private final IError ERROR;

    private final RequestBody BODY;


    public RestClient(String url,
                      Map<String, Object> params,
                      IRequest request,
                      ISuccess success,
                      IFailure failure,
                      IError error,
                      RequestBody body) {
        URL = url;
        PARAMS = params;
        REQUEST = request;
        SUCCESS = success;
        FAILURE = failure;
        ERROR = error;
        BODY = body;
    }

    public static  RestClientBuilder builder(){
        return new RestClientBuilder();
    }
}
