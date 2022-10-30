package Day13_Excell_Screenshot_IsExecutor;

import Utility.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class D06_JSExecuter extends TestBase {

    @Test
    public void jsExecuterTest(){

        // Amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");


        // Sell butonuna JS Executer ile basalim
        WebElement sellLinki= driver.findElement(By.xpath("//a[text()=\"Sell\"]"));

        JavascriptExecutor javaScript = (JavascriptExecutor) driver;

        javaScript.executeScript("arguments[0].click();", sellLinki);


        // Bir alert olusturup "Yasasinnnn" yazdirin
        javaScript.executeScript("alert('Yasasinnnn');");

        threadSleep(3);

        driver.switchTo().alert().accept();


    }

}
