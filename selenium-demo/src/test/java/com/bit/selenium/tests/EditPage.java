package com.bit.selenium.tests;


import com.bit.selenium.common.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class EditPage extends Utils {


    public EditPage(){

    }



    /**
     * 创建博客
     */
    public void createBlog()
            throws InterruptedException {


        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(5)
                );



        //=========================
        // 输入博客标题
        //=========================

        wait.until(
                ExpectedConditions
                        .presenceOfElementLocated(
                                By.id("title")
                        )
        );


        driver.findElement(
                        By.id("title")
                )
                .sendKeys(
                        "Selenium自动化测试"
                );



        //=========================
        // 输入博客内容
        //=========================


        JavascriptExecutor js =
                (JavascriptExecutor)driver;


        js.executeScript(
                "document.getElementById('content').value='这是使用 Selenium 自动创建的博客内容';"
        );



        //=========================
        // 点击发布
        //=========================


        driver.findElement(
                        By.id("submit")
                )
                .click();



        //=========================
        // 处理成功弹窗
        //=========================


        Utils.closeAlerts();



        Thread.sleep(2000);



        System.out.println(
                "博客创建完成"
        );


        // ================================
// 校验新创建博客是否存在
// ================================


// 获取所有博客
        List<WebElement> blogs =
                driver.findElements(
                        By.cssSelector(
                                ".right > div.blog"
                        )
                );


        // 获取最后一篇博客标题
        String lastTitle =
                driver.findElement(
                                By.cssSelector(
                                        ".right > div.blog:nth-child("
                                                + blogs.size()
                                                + ") .title"
                                )
                        )
                        .getText();



        System.out.println(
                "最新博客标题:"
                        + lastTitle
        );


        // 断言
        assert lastTitle.equals(
                "Selenium自动化测试"
        )
                :"博客创建失败";


        System.out.println(
                "博客创建测试成功"
        );

    }


}