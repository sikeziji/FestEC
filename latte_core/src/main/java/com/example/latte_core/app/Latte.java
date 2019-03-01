package com.example.latte_core.app;


import android.content.Context;

import java.util.HashMap;
import java.util.WeakHashMap;

public final class Latte {

    /**
     * 初始化Configurator
     * @param context 传入当前Context
     * @return  返回Configurator
     */
    public static Configurator init(Context context){
            getConfigrations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
            return Configurator.getInstance();
    }

    /**
     * 获取LATTE_CONFIG   Map集合
     * @return
     */
    public static HashMap<String ,Object> getConfigrations(){
        return Configurator.getInstance().getLatteConfigs();
    }
}
