package com.example.latte_core.app;


import java.util.WeakHashMap;

public class Configurator {


    private static final WeakHashMap<String,Object> LATTE_CONFIGS = new WeakHashMap<>();


    private Configurator(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),false);
    }

    //单例模式
    @org.jetbrains.annotations.Contract(pure = true)
    public static Configurator  getInstance(){
       return Holder.INSTANCE;
    }

    /**
     * 获取LATTE_CONFIGS 全局配置Map集合
     * @return  LATTE_CONFIGS
     */
    final  WeakHashMap<String,Object> getLatteConfigs(){
        return LATTE_CONFIGS;
    }

    //静态内部类
    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    /**
     * 设置初始化成功
     */
    public final void  configure(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }


    /**
     *  设置 API_HOST 网络请求域名
     * @param host  传入网络请求域名
     * @return 当前配置域名后的Configurator
     */
    public final Configurator withApiHost(String host){
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return  this;
    }

    //检查配置项是否完成
    private void checkConfiguration(){
        final boolean isReady  = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady)
        {
            throw new RuntimeException("Configuration is not ready,configure");
        }
    }
    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key){
        checkConfiguration();
        return (T) LATTE_CONFIGS.get(key.name());
    }
}
