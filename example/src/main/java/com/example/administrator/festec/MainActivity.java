package com.example.administrator.festec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.latte_core.app.Latte;
import com.example.latte_core.ui.loader.LatteLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LatteLoader.showLoading(this);
    }
}
