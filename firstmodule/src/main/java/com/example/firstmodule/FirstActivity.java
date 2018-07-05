package com.example.firstmodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.mylibrary.RouterURLS;

@Route(path = RouterURLS.FIRST_MAIN)
public class FirstActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity_main);

        tv=(TextView)findViewById(R.id.first_tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(RouterURLS.SECOND_MAIN).withString("data","来自firstmodule FirstActivity的消息").navigation();
            }
        });
    }
}
