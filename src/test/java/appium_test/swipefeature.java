package appium_test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class swipefeature extends base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
        driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
        //If any tag like class name ,id has special character xpath will not recognize that element
        //If want to skip tag name we have to use star in place of tag name
        driver.findElementByXPath("//*[@content-desc='9']").click();
        TouchAction t = new TouchAction(driver);
        //long press on element // move to another element // release //perform
        WebElement swipefrom = driver.findElementByXPath("//*[@content-desc='15']");
        WebElement swipeto = driver.findElementByXPath("//*[@content-desc='45']");

        t.longPress(longPressOptions().withElement(element(swipefrom))).moveTo(element(swipeto)).release().perform();

    }
}

