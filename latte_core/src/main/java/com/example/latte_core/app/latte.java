package com.example.latte_core.app;


import android.content.Context;

import java.util.WeakHashMap;

public final class latte {

    public static Configurator init(Context context){
            getConfigrations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
            return Configurator.getInstance();
    }

    /**
     * 获取LATTE_CONFIG   Map集合
     * @return
     */
    private static WeakHashMap<String ,Object> getConfigrations(){
        return Configurator.getInstance().getLatteConfigs();
    }
}
