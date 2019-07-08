package com.example.latte_core.net;

import com.example.latte_core.net.callback.IError;
import com.example.latte_core.net.callback.IFailure;
import com.example.latte_core.net.callback.IRequest;
import com.example.latte_core.net.callback.ISuccess;
import com.example.latte_core.net.callback.RequestCallbacks;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

public class RestClient {

    //URL
    private final String URL;
    //参数
    private final Map<String, Object> PARAMS;

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

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }


    private void request(HttpMrthod mrthod) {
        final RestService service = RestCreator.getRestService();
        Call<String> call = null;


        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }


        switch (mrthod) {
            case GET:
                break;
            case POST:
                break;
            case PUT:
                break;
            case DELETE:
                break;
            default:
                break;
        }

        if (call != null) {
            call.enqueue(getRequestCallback());
        }

    }


    private Callback<String> getRequestCallback() {
        return new RequestCallbacks(REQUEST, SUCCESS, FAILURE, ERROR);
    }

    public final void get() {
        request(HttpMrthod.GET);
    }

    public final void post() {
        request(HttpMrthod.POST);
    }

    public final void put() {
        request(HttpMrthod.PUT);
    }

    public final void delete() {
        request(HttpMrthod.DELETE);
    }
}


