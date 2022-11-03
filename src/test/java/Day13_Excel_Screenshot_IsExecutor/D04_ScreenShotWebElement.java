package Day13_Excel_Screenshot_IsExecutor;

import Utility.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class D04_ScreenShotWebElement extends TestBase {

    @Test
    public void testAmazon3() throws IOException {


        // https://www.amazon.com ana sayfasina gidin
        driver.get("https://www.amazon.com");

        // Arama kutusuna "Nutella" yazdirip aratalim
        WebElement searchBoxElementi = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        searchBoxElementi.sendKeys("Nutella" + Keys.ENTER);


        // Arama sonuclarinin "Nutella" icerdigini test edelim
        WebElement aramaSonucElementi = driver.findElement(By.xpath("//div[@class=\"sg-col-inner\"]"));

        String expectedKelime = "Nutella";
        String actualYazi = aramaSonucElementi.getText();

        Assert.assertTrue(actualYazi.contains(expectedKelime));


        // Sadece sonuc yazisi elementinin ScreenShot'ini cekelim

        // 1. adim ScreenShot cekecegimiz webElementi locate edelim

        // 2. 3. ve 4. adimlar tüm sayfa ScreenShot ile ayni

        File locateElementSShot = new File("target/Screenshot/SeleniumSShot.jpeg");

        File geciciResim = aramaSonucElementi.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciResim, locateElementSShot);


    }

}
