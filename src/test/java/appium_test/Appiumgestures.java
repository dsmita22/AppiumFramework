package appium_test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import org.openqa.selenium.interactions.touch.TouchActions;
import static io.appium.java_client.touch.offset.ElementOption.element;


import java.net.MalformedURLException;

import java.util.concurrent.TimeUnit;

public class Appiumgestures extends  base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver= Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        //Tap gesture
        TouchAction t = new TouchAction(driver);
        WebElement expandList= driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(expandList))).perform();
        driver.findElementByXPath("//android.widget.TextView[@text ='1. Custom Adapter']").click();
        WebElement longprs = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");

        t.longPress(longPressOptions().withElement(element(longprs))).release().perform();
        System.out.println(driver.findElementById("android:id/title").isDisplayed());


        driver.quit();
    }

}
