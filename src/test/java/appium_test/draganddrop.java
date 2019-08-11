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
public class draganddrop extends base {
    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
        WebElement dragfrom = driver.findElementsByClassName("android.view.View").get(0);
        WebElement droploc = driver.findElementsByClassName("android.view.View").get(1);

        TouchAction t = new TouchAction(driver);
        //long press //drag to destination//release to the destination//perform
        //if need to perform multiple action with longpress[like withElement,withDuration],need write below code
        t.longPress(longPressOptions().withElement(element(dragfrom))).moveTo(element(droploc)).release().perform();
        //if need to do only long press then write below code
        // t.longPress(element(dragfrom)).moveTo(element(droploc)).release().perform();
        driver.quit();
    }
}

