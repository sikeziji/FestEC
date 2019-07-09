package com.example.latte_core.app;


import android.content.Context;
import android.os.Handler;

import java.util.HashMap;
import java.util.WeakHashMap;

public final class Latte {



    /**
     * 初始化Configurator
     * @param context 传入当前Context
     * @return  返回Configurator
     */
    public static Configurator init(Context context) {
        Configurator.getInstance()
                .getLatteConfigs()
                .put(ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();
    }

    /**
     * 获取LATTE_CONFIG   Map集合
     * @return
     */
    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext() {
        return getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }

    public static Handler getHandler() {
        return getConfiguration(ConfigKeys.HANDLER);
    }



}
