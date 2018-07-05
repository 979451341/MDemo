package com.example.second_module;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.mylibrary.RouterURLS;
import com.example.mylibrary.TestService;

@Route(path = RouterURLS.SECOND_MAIN)
public class SecondMainActivity extends AppCompatActivity {

    TextView tv,tv_getdata;

    @Autowired(name = RouterURLS.BASE_MYSERVICE)
    TestService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_second_main);

        ARouter.getInstance().inject(this);

        //接收参数
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        tv=(TextView)findViewById(R.id.second_tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.showToast(SecondMainActivity.this);
            }
        });

        tv_getdata=(TextView)findViewById(R.id.second_tv_getdata);
        if(!TextUtils.isEmpty(data)){
            tv_getdata.setText(data);

        }


    }
}
