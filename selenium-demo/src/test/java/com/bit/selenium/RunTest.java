package com.bit.selenium;

import com.bit.selenium.common.Utils;
import com.bit.selenium.tests.DetailPage;
import com.bit.selenium.tests.EditPage;
import com.bit.selenium.tests.ListPage;
import com.bit.selenium.tests.LoginPage;

import java.io.IOException;

public class RunTest {

    public static void main(String[] args)
            throws IOException, InterruptedException {


//        LoginPage login=new LoginPage();
//
//
//        login.checkPageRight();
//
//        login.LoginFail();
//
//        login.LoginSuc();
//
//
//        Utils.closeAlerts();
//
//
//        Thread.sleep(3000);
//
//
//
//        ListPage list=new ListPage();
//
//
//        list.checkBlogList();
//
//        //进入创建博客页面
//
//        list.clickCreateBlog();
//
//
////
////        EditPage edit=
////                new EditPage();
////
////
////        edit.createBlog();
//
//
//
//        //进入详情页
//        list.clickDetail();
//
//        DetailPage detail=new DetailPage();
//
//        detail.checkPage();
//
//        detail.checkDeleteBlog();
//
//
////        DetailPage detail=new DetailPage();
////
////
////        detail.checkPage();
////
////
////        detail.checkDetaileEdit();
//
//
//
//        Utils.quit();

///----------------------检查详情页
//        LoginPage login = new LoginPage();
//
//        // 1. 检查登录页面
//        login.checkPageRight();
//
//        // 2. 错误登录测试
//        login.LoginFail();
//
//        // 3. 正确登录
//        login.LoginSuc();
//
//        Utils.closeAlerts();
//
//        Thread.sleep(3000);
//
//        // 4. 博客列表
//        ListPage list = new ListPage();
//
//        list.checkBlogList();
//
//        // 这里不要进入创建博客页面
//        // list.clickCreateBlog();
//
//        // 5. 从博客列表进入详情页
//        list.clickDetail();
//
//        Thread.sleep(2000);
//
//        // 6. 测试详情页面
//        DetailPage detail = new DetailPage();
//
//        detail.checkPage();
//
//        // 先不要删除
//        // detail.checkDeleteBlog();
//
//        Utils.quit();

///-------------删除博客

//        LoginPage login = new LoginPage();
//
//        login.checkPageRight();
//
//        login.LoginFail();
//
//        login.LoginSuc();
//
//        Utils.closeAlerts();
//
//        Thread.sleep(3000);
//
//        ListPage list = new ListPage();
//
//        list.checkBlogList();
//
//
//        // =========================
//        // 进入详情页
//        // =========================
//
//        list.clickDetail();
//
//        Thread.sleep(2000);
//
//        DetailPage detail = new DetailPage();
//
//        // 检查详情页
//        detail.checkPage();
//
//        Thread.sleep(2000);
//
//        // 删除博客
//        detail.checkDeleteBlog();
//
//
//        Utils.quit();

///------------修改详情页
        LoginPage login = new LoginPage();

        login.LoginSuc();

        Utils.closeAlerts();

        Thread.sleep(3000);

        ListPage list = new ListPage();

        // 创建自己的博客
        list.clickCreateBlog();

        EditPage edit = new EditPage();

        edit.createBlog();

        Thread.sleep(3000);

        // 进入详情页
        list.clickDetail();

        Thread.sleep(2000);

        // 修改博客
        DetailPage detail = new DetailPage();

        detail.checkDetaileEdit();

        Thread.sleep(2000);

        Utils.quit();
    }
}