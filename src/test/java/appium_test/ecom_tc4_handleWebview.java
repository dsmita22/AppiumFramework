package appium_test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import org.junit.Assert;
import org.junit.Test;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ecom_tc4_handleWebview extends ecom_base {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@text ='Female']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));");
        driver.findElement(By.xpath("//*[@text ='Australia']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        //after click on first add to cart[index 0] the text is changed to added to cart and second element add to cart value updated to '0 ' index
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        // Mobile gesture to connect to webview
        WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
        TouchAction t = new TouchAction(driver);
        t.tap(TapOptions.tapOptions().withElement(element(checkbox))).perform();
        WebElement longpress =driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
        t.longPress(longPressOptions().withElement(element(longpress))).release().perform();
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(7000);
        Set<String> context =driver.getContextHandles();

        //Switching appium context to selenium context
        //ref..http://appium.io/docs/en/writing-running-appium/web/hybrid/
        for(String contextName :context)
        {
            System.out.println(contextName);
        }
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("Good Morning!!");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");
    }

}

