package com.example.latte_core.ui.loader;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.example.latte_core.R;
import com.example.latte_core.ui.util.DimenUtil;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

public class LatteLoader {


    //设置默认缩放
    private static final int LOADER_SIZE_SCALE = 8;
    //设置默认偏移
    private static final int LOADER_OFFSET_SCALE = 10;

    // Dialog 容器
    private static final ArrayList<AppCompatDialog> LOADERS = new ArrayList<>();


    //默认的Dialog的属性
    private static final String DEFAULT_LOADER = LoaderStyle.BallClipRotatePulseIndicator.name();



    public static void showLoading(Context context) {
        showLoading(context, DEFAULT_LOADER);
    }

    public static void showLoading(Context context, Enum<LoaderStyle> type) {
        showLoading(context, type.name());
    }

    /**
     * 显示Loading
     * @param context
     * @param type
     */
    public static void showLoading(Context context, String type) {
        //设置Dialog AVLoading默认实在View上进行的，我们添加一个Dialog ，让其在Dialog上显示
        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.Theme_AppCompat);
//        创建AVLoadingView对象
        final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.create(context, type);
//        设置View
        dialog.setContentView(avLoadingIndicatorView);


//        获取到宽高
        int deviceWidth = DimenUtil.getScreenWidth();
        int deviceHeight = DimenUtil.getScreenHeight();

//      获取当前Dialog 的window
        final Window dialogWindow = dialog.getWindow();
        if (dialogWindow != null){
            final WindowManager.LayoutParams layoutParams = dialogWindow.getAttributes();
            //设置宽度
            layoutParams.width = deviceWidth / LOADER_SIZE_SCALE;
            //设置高度
            layoutParams.height = deviceHeight / LOADER_SIZE_SCALE;
            //在高度上设置偏移量
            layoutParams.height = layoutParams.height + deviceHeight / LOADER_OFFSET_SCALE;
            //设置为居中
            layoutParams.gravity = Gravity.CENTER;
        }
        LOADERS.add(dialog);
        dialog.show();
    }

    /**
     * 关闭Loading
     */
    public static void stopLoading() {
        for (AppCompatDialog dialog : LOADERS) {
            if (dialog != null) {
                if (dialog.isShowing()) {
                    dialog.cancel();
                }
            }
        }
    }

}
