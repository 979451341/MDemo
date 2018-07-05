package com.example.mylibrary;

/**
 * @Created by TOME .
 * @时间 2018/4/26 10:20
 * @描述 ${路由地址}
 */
// 注意事项！！！  /模块/页面名称   或  /模块/子模块../页面名称   至少两级  例子 /商城/商品详情 /shop/shopDetails
    //url 第一次相同会报错??
public interface RouterURLS {

    String BASE_MAIN = "/base/main";
    String FIRST_MAIN = "/first/main";
    String SECOND_MAIN = "/second/main";
    String BASE_MYSERVICE = "/base/myservice";
}
