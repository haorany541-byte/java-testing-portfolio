package com.bit.selenium.tests;

import com.bit.selenium.common.Utils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class LoginPage extends Utils {
    public static String url="http://121.199.51.208:8080/blog_login.html";

    public LoginPage() {
        super(url);
    }
    /**
     * 登录页面可以正常打开
     */
    public void checkPageRight() throws IOException {
        //检查菜单
        driver.findElement(By.cssSelector("body > div.nav > a:nth-child(4)"));
        driver.findElement(By.cssSelector(" body > div.nav > a:nth-child(5)"));
        //检查登录框
        driver.findElement(By.cssSelector("#username"));
        driver.findElement(By.cssSelector("#password"));
        driver.findElement(By.cssSelector("#submit"));
        //System.out.println("method name；"+this.getClass().getSimpleName());
        //System.out.println("method name；"+Thread.currentThread().getStackTrace()[1].getMethodName());
        ScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//        driver.findElement(By.id("username"));
//        driver.findElement(By.name("username"));
//        driver.findElement(By.cssSelector("input[name='username']"));
//        driver.findElement(By.className("row"));
//        driver.findElement(By.cssSelector(".row"));


    }

    /**
     * 成功登录-正确的账号和密码
     */
    public void LoginSuc(){
        //先清空
        driver.findElement(By.cssSelector("#username")).clear();
        driver.findElement(By.cssSelector("#password")).clear();
        //输入正确的账号和密码：zhangsan   123456
        driver.findElement(By.cssSelector("#username")).sendKeys("zhangsan");
        driver.findElement(By.cssSelector("#password")).sendKeys("123456");
        driver.findElement(By.cssSelector("#submit")).click();
        //登录成功过会进入到列表页面-注销
        //closeAlerts();
       // driver.findElement(By.cssSelector(""));
    }
    /**
     * 异常登录
     * -----用户名和密码都为空
     * ---用户名不为空，密码为空
     * ---用户名为空，密码不为空
     * ---正确的用户名，错误 的密码
     * ---错误的用户名 正确的密码
     * ---错误的用户名和密码
     * ----输入框：输入过长的内容，过短的，特殊的字符。。。
     */
    //上课选择一个用例展示一下即可
    //输入正确的账号，错误的密码
    public void LoginFail(){
        //先清空
        driver.findElement(By.cssSelector("#username")).clear();
        driver.findElement(By.cssSelector("#password")).clear();

        driver.findElement(By.cssSelector("#username")).sendKeys("zhangsan");
        driver.findElement(By.cssSelector("#password")).sendKeys("123");
        driver.findElement(By.cssSelector("#submit")).click();
        //处理错误弹窗-警告弹窗
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
















}
