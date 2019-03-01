package com.example.latte_core.delegate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

public abstract class BaseDelegate extends SwipeBackFragment {

    private Unbinder mUnbinder = null;

    /**
     * 设置Layout(View 视图)
     */
    public abstract Object setLayout();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //创建基础视图
        View rootView = null;
        if (setLayout() instanceof Integer) {
            //判断设置的视图类型是否为视图id（也就是R.id.）
            rootView = inflater.inflate((Integer) setLayout(), container, false);

        } else if (setLayout() instanceof View) {
            //判断设置的视图类型为View
            rootView = (View) setLayout();
        }

        if (rootView != null) {
            //通过ButterKnife绑定视图
            mUnbinder = ButterKnife.bind(this, rootView);
            onBandView(savedInstanceState, rootView);
        }

        return rootView;
    }


    /**
     * 绑定视图
     *
     * @param savedInstanceState 可为空的 Bundle
     * @param view               根视图
     */
    public abstract void onBandView(@Nullable Bundle savedInstanceState, View view);


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();

        }
    }
}
