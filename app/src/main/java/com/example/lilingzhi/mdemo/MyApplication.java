package com.example.lilingzhi.mdemo;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.mylibrary.BaseApplication;

/**
 * @Created by TOME .
 * @时间 2018/5/14 17:40
 * @描述 ${应用的application}
 */

public class MyApplication extends BaseApplication {

    private static MyApplication myApplication;

    public static MyApplication getInstance() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this ;


    }
}
