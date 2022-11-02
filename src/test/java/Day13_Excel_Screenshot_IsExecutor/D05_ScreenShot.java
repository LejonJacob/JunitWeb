package Day13_Excel_Screenshot_IsExecutor;

import Utility.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class D05_ScreenShot extends TestBase {

    @Test
    public void test01() throws IOException {
        // Amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");


        // Tüm sayfanin fotografini cekelim
        fullPageScreenShot();


        // Arama kutusuna "Nutella" yazip, fotografini cekelim
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella");
        webElementScreenShot(aramaKutusu);
        aramaKutusu.submit();


        // Aramayi yapip, sonucun Nutella icerdigini test edin ve sonuc yazisinin fotografini cekin
        WebElement aramaSonucElementi = driver.findElement(By.xpath("//div[@class=\"sg-col-inner\"]"));

        String expectedkelime="Nutella";
        String actualYazi= aramaSonucElementi.getText();

        Assert.assertTrue(actualYazi.contains(expectedkelime));

        webElementScreenShot(aramaSonucElementi);


    }
}