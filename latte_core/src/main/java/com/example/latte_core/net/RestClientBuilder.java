package com.example.latte_core.net;

import com.example.latte_core.net.callback.IError;
import com.example.latte_core.net.callback.IFailure;
import com.example.latte_core.net.callback.IRequest;
import com.example.latte_core.net.callback.ISuccess;

import java.util.Map;

import okhttp3.RequestBody;

public class RestClientBuilder {
    //URL
    private  String mUrl;
    //参数
    private Map<String,Object> mParams;

    private IRequest mRequest;

    private ISuccess mSuccess;

    private IFailure mFailure;

    private IError mError;

    private RequestBody mBody;
}
