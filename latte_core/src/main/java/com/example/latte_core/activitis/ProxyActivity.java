package com.example.latte_core.activitis;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.widget.ContentFrameLayout;

import com.example.latte_core.R;
import com.example.latte_core.delegate.LatteDelegate;

import androidx.annotation.Nullable;
import me.yokeyword.fragmentation.SupportActivity;

public abstract class ProxyActivity extends SupportActivity {

    /**
     * 设置默认的rootDelegate
     * @return
     */
    public abstract LatteDelegate setRootDelegare();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
//        initContainer(savedInstanceState);
    }

    @SuppressLint("RestrictedApi")
//    private void initContainer(@Nullable Bundle savedInstanceState){
//        final ContentFrameLayout container = new ContentFrameLayout(this);
//        container.setId(R.id.delegate_container);
//
//        setContentView(container);
//        if (savedInstanceState == null)
//        {
//            loadRootFragment(R.id.delegate_container,setRootDelegare());
//        }
//
//    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
