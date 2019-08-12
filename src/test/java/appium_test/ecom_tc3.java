package appium_test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class ecom_tc3 extends ecom_base {
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
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        //after click on first add to cart[index 0] the text is changed to added to cart and second element add to cart value updated to '0 ' index
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        String amnt1 = ( driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText());

//        amnt1 = amnt1.substring(1);
        //160.97[string]
//        double amnt1val = Double.parseDouble(amnt1);
//        //string to double

        double amount1 = getAmount(amnt1);

        String amnt2 = ( driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText());
//        amnt2 = amnt2.substring(1);
//        double amnt2val = Double.parseDouble(amnt2);
        double amount2 = getAmount(amnt2);
        //total value of two items
        double sumofproduct = amount1 + amount2;
        System.out.println(sumofproduct + "Sum of the products");

        String Total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Total = Total.substring(1);
        double Totalval = Double.parseDouble(Total);
        System.out.println(Totalval+ "Total price of the cart");

        Assert.assertEquals(sumofproduct,Totalval,0);
    }
    public  static  double  getAmount(String value)
    {
        value = value.substring(1);
        double amount = Double.parseDouble(value);
        return  amount;
    }
}
