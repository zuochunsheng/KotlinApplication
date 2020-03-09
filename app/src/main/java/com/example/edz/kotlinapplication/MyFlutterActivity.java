package com.example.edz.kotlinapplication;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import io.flutter.view.FlutterView;

public class MyFlutterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//       setContentView(R.layout.activity_flutter);
//        // 通过FlutterFragment引入Flutter编写的页面
//        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
//        tx.replace(R.id.fl_container, Flutter.createFragment("route1"));
//        tx.commit();


        // 通过FlutterView引入Flutter编写的页面
//        View flutterView = Flutter.createView(this, getLifecycle(), "route1");
//        View flutterView = Flutter.createView(this, getLifecycle(),
//                "route1?{\"name\":\"StephenCurry\"}");

//        FrameLayout.LayoutParams layout = new FrameLayout.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.MATCH_PARENT);
//        addContentView(flutterView, layout);

    }
}
