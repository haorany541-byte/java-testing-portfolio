package com.bit.selenium.tests;

import com.bit.selenium.common.Utils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DetailPage extends Utils {


    public DetailPage(){
        super();
    }


    /**
     * 检查博客详情页
     */
    public void checkPage(){


        //标题
        WebElement title =
                driver.findElement(
                        By.cssSelector(".right .content .title")
                );


        //更新时间
        WebElement date =
                driver.findElement(
                        By.cssSelector(".right .content .date")
                );


        //博客正文
        WebElement detail =
                driver.findElement(
                        By.cssSelector("#detail")
                );


        //编辑按钮
        WebElement edit =
                driver.findElement(
                        By.cssSelector(".operating button:nth-child(1)")
                );


        //删除按钮
        WebElement delete =
                driver.findElement(
                        By.cssSelector(".operating button:nth-child(2)")
                );


        //断言
        assert !title.getText().isEmpty()
                :"博客标题为空";


        assert !date.getText().isEmpty()
                :"博客日期为空";


        assert !detail.getText().isEmpty()
                :"博客内容为空";


        System.out.println("详情页检查成功");

        System.out.println("标题:"
                + title.getText());

    }



    /**
     * 编辑博客
     */
    public void checkDetaileEdit()
            throws InterruptedException{


        //点击编辑按钮

        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(5)
                );


        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".operating button:nth-child(1)")
                )
        ).click();


        Thread.sleep(2000);



        //进入编辑页面后修改标题

        WebElement title =
                driver.findElement(
                        By.cssSelector("#title")
                );


        title.clear();


        title.sendKeys(
                "自动化更新数据"
        );



        //点击更新文章

        driver.findElement(
                By.cssSelector("#submit")
        ).click();



        //关闭更新成功弹窗

        Utils.closeAlerts();



        Thread.sleep(2000);



        System.out.println(
                "当前页面:"
                        + driver.getCurrentUrl()
        );


    }

    /**
     * 测试删除博客
     */
    public void checkDeleteBlog() throws InterruptedException {


        //点击删除按钮

        driver.findElement(
                By.cssSelector(
                        ".operating button:nth-child(2)"
                )
        ).click();



        //等待确认弹窗出现

        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(5)
                );


        Alert alert =
                wait.until(
                        ExpectedConditions.alertIsPresent()
                );


        System.out.println(
                "删除确认:"
                        + alert.getText()
        );


        //点击确定

        alert.accept();



        //等待删除成功弹窗

        alert =
                wait.until(
                        ExpectedConditions.alertIsPresent()
                );


        System.out.println(
                "删除结果:"
                        + alert.getText()
        );


        assert alert.getText()
                .equals("博客删除成功")
                :
                "删除提示错误";


        alert.accept();



        //等待跳转

        wait.until(
                ExpectedConditions.urlContains(
                        "blog_list"
                )
        );


        System.out.println(
                "删除成功，返回列表页"
        );


    }

}