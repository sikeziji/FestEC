package com.example.latte_core.net;

import com.example.latte_core.app.ConfigType;
import com.example.latte_core.app.Latte;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RestCreator {

    /**
     * 返回RestService
     * @return  返回值
     */
    public static RestService getRestService(){
        return RestServiceHolder.REST_SERVICE;
    }


    private static final class RetrofitHolder {
        //获取初始化后的URL
        private static final String BASE_URL = (String) Latte.getConfigrations().get(ConfigType.API_HOST.name());

        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)//设置初始化后的URL
                .client(OKhttpHolder.OK_HTTP_CLIENT)//设置Client
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    private static final class OKhttpHolder {
        //超时时间
        private static final int TIME_OUT = 60;

        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient
                .Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)//设置超时时间，单位为秒
                .build();

    }

    private static final class RestServiceHolder {
        private static final RestService REST_SERVICE = RetrofitHolder
                .RETROFIT_CLIENT.create(RestService.class);
    }
}
