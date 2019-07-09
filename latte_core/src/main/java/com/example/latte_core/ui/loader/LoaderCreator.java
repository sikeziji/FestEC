package com.example.latte_core.ui.loader;

import android.content.Context;

import com.wang.avi.AVLoadingIndicatorView;
import com.wang.avi.Indicator;

import java.util.WeakHashMap;

public class LoaderCreator {

    //设置一个弱引用的hashMap 缓存loading,不用每次都通过反射去调用，提高性能
    private static final WeakHashMap<String, Indicator> LOADING_MAP = new WeakHashMap<>();

    //创建一个AVLoading (默认为protected )
    static AVLoadingIndicatorView create(Context context, String type) {
        final AVLoadingIndicatorView avLoadingIndicatorView = new AVLoadingIndicatorView(context);

        if (avLoadingIndicatorView != null) {
            final Indicator indicator = getIndicator(type);
            LOADING_MAP.put(type, indicator);
        }
        //设置Indicator 从Map中获取
        avLoadingIndicatorView.setIndicator(LOADING_MAP.get(type));
        return avLoadingIndicatorView;
    }

    /**
     * 获取Indicator对象
     *
     * @param name class name
     * @return
     */
    private static Indicator getIndicator(String name) {
        if (name == null && name.isEmpty()) {
            return null;
        }
        //设置String字节
        final StringBuilder drawableClassName = new StringBuilder();
        if (!name.contains(".")) {//如果传入的name 不包含"."
            //获取AVLoadingIndicatorView的PackageName
            final String defaultPackageName = AVLoadingIndicatorView.class.getPackage().getName();
            //拼接 indicators .
            drawableClassName.append(defaultPackageName)
                    .append(".indicators")
                    .append(".");
        }
        //最后把传入的name拼接成一个完整的路径
        drawableClassName.append(name);
        try {
            //通过反射获取当前传入name映射的Class
            final Class<?> drawableClass = Class.forName(drawableClassName.toString());
            //创建当前class的实例
            return (Indicator) drawableClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
