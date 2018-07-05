package com.example.lilingzhi.mdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.routes.ARouter$$Group$$arouter;
import com.example.firstmodule.FirstActivity;
import com.example.mylibrary.RouterURLS;

@Route(path = RouterURLS.BASE_MAIN)
public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=(TextView)findViewById(R.id.main_tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发起路由跳转
                ARouter.getInstance().build(RouterURLS.FIRST_MAIN).navigation(MainActivity.this);


            }
        });

    }
}
