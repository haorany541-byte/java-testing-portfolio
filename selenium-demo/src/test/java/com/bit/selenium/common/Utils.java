package com.bit.selenium.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class Utils {
    public static WebDriver driver=null;
    public WebDriverWait wait=null;
    public static String detailUrl=
            "http://121.199.51.208:8080/blog_detail.html";
    public Utils(){

    }
    public Utils(String url){
        //调用driver对象
        driver=createDriver();
        driver.get(url);

        wait=new WebDriverWait(driver,Duration.ofSeconds(3));

    }
    /**
    * 获取驱动对象
    * */
    public static WebDriver createDriver(){

        if(driver==null){

            WebDriverManager.chromedriver().setup();

            ChromeOptions options=new ChromeOptions();

            options.addArguments("--remote-allow-origins=*");

            driver=new ChromeDriver(options);

        }

        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(3));


        return driver;
    }
    /**
     * 屏幕截图
     * 屏幕截图文件目录
     * ./src/test/java/images/
     *                      /2026-08-07/
     *                                  /test01-13183010.png
     *                                  /test01-13193510.png
     *                      /2026-08-08/
     *                                  /test01-13183010.png
     *                                  /test01-13193510.png
     */
    public void ScreenShot(String str) throws IOException {
        //年月日
        SimpleDateFormat sim1=new SimpleDateFormat("yyyy-MM-dd");
        //时分秒
        SimpleDateFormat sim2=new SimpleDateFormat("HHmmSS");
        String dirTime=sim1.format(System.currentTimeMillis());
        String fileTime=sim2.format(System.currentTimeMillis());

        //创建文件
        //图片文件名：路径+名称
        //  ./src/test/java/com/bit/selenium/image/2026-08-07/test01-13273010.png
        String filename="./src/test/java/com/bit/selenium/image/"+dirTime+"/"+str+"-"+fileTime+".png";
        System.out.println("filename:"+filename);

        File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //getScreenshotAs(...)  获取截图，并以某种形式返回。
        //OutputType.FILE  这里告诉 Selenium：请把截图返回成 File 文件。
        //Java 要先做：(TakesScreenshot)driver    得到：TakesScreenshot
        FileUtils.copyFile(srcFile,new File(filename));

    }
    /**
     * 销毁driver对象-关闭浏览器
     */
    public static void quit(){
        if(driver!=null){
            driver.quit();
        }
    }
    /**
     * 关闭JavaScript弹窗
     */



    public static void closeAlerts(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        while(true){

            try {

                // 等待弹窗出现
                Alert alert = wait.until(
                        ExpectedConditions.alertIsPresent()
                );

                // 打印弹窗内容
                System.out.println("关闭弹窗：" + alert.getText());

                // 点击确定
                alert.accept();

                // 给页面JS一点反应时间
                Thread.sleep(500);


            } catch (Exception e) {

                // 3秒内没有新的弹窗，退出循环
                break;

            }

        }

    }


}

























