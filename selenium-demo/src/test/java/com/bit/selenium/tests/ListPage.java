package com.bit.selenium.tests;

import com.bit.selenium.common.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ListPage extends Utils {


    public ListPage(){

    }


    /**
     * 检查博客列表页
     * 三个模块：
     * 1.菜单模块
     * 2.个人信息模块
     * 3.博客列表模块
     */
    public void checkBlogList(){


        //博客标题
        String title =
                driver.findElement(
                                By.cssSelector(
                                        ".right .blog:nth-child(1) .title"
                                )
                        )
                        .getText();


        //博客发布时间
        String publish_time =
                driver.findElement(
                                By.cssSelector(
                                        ".right .blog:nth-child(1) .date"
                                )
                        )
                        .getText();


        //博客内容
        String content =
                driver.findElement(
                                By.cssSelector(
                                        ".right .blog:nth-child(1) .desc"
                                )
                        )
                        .getText();



        //断言
        assert !title.isEmpty()
                :"博客标题为空";


        assert !publish_time.isEmpty()
                :"博客发布时间为空";


        assert !content.isEmpty()
                :"博客内容为空";



        System.out.println("博客列表检查成功");
        System.out.println("标题：" + title);
        System.out.println("发布时间：" + publish_time);
        System.out.println("内容：" + content);

    }



    /**
     * 进入博客详情页
     */
    /**
     * 进入刚刚创建的博客详情页
     */
    public void clickDetail() {

        // 获取页面上的所有博客
        List<WebElement> blogs =
                driver.findElements(
                        By.cssSelector(".right .blog")
                );

        // 遍历所有博客
        for (WebElement blog : blogs) {

            // 获取当前博客标题
            String title =
                    blog.findElement(
                            By.cssSelector(".title")
                    ).getText();

            // 找到刚创建的博客
            if (title.equals("Selenium自动化测试")) {

                // 只在这篇博客里面找“查看全文”
                WebElement detail =
                        blog.findElement(
                                By.cssSelector(
                                        "a[href*='blog_detail']"
                                )
                        );

                detail.click();

                System.out.println(
                        "进入 Selenium自动化测试 详情页"
                );

                return;
            }
        }

        System.out.println(
                "没有找到 Selenium自动化测试"
        );
    }
    public void clickCreateBlog(){


        driver.findElement(
                        By.cssSelector(
                                "a[href*='blog_edit']"
                        )
                )
                .click();


    }

}