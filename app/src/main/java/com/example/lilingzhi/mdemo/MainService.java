package com.example.lilingzhi.mdemo;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mylibrary.RouterURLS;
import com.example.mylibrary.TestService;

@Route(path = RouterURLS.BASE_MYSERVICE, name="宿主的服务")
public class MainService implements TestService {

    @Override
    public void showToast(Context context) {
        Toast.makeText(context,"成功调用宿主模块的服务",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void init(Context context) {

    }
}
