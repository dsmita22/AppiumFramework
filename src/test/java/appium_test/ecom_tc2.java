package appium_test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;


public class ecom_tc2 extends ecom_base {
    public static void main(String[] args)  throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@text ='Female']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));");
        driver.findElement(By.xpath("//*[@text ='Australia']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
        int count=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for(int i=0 ;i<count;i++)
        {
            String text=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

            if(text.equalsIgnoreCase("Air Jordan 9 Retro"))
            {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                break;
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        String cartpagetext = (driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText());
        Assert.assertEquals("Air Jordan 9 Retro",cartpagetext);
    }
}
