package Day13_Excel_Screenshot_IsExecutor;

import Utility.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class D02_ScreenShotFullPage extends TestBase {

    @Test
    public void testAmazon() throws IOException {


        // amazon.com ana sayfasina gidin
        driver.get("https://www.amazon.com");

        // Arama kutusuna "Nutella" yazdirip aratalim
        WebElement searchBoxElementi = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        searchBoxElementi.sendKeys("Nutella" + Keys.ENTER);


        // Arama sonuclarinin "Nutella" icerdigini test edelim
        WebElement aramaSonucElementi = driver.findElement(By.xpath("//div[@class=\"sg-col-inner\"]"));

        String expectedKelime= "Nutella";
        String actualYazi = aramaSonucElementi.getText();

        Assert.assertTrue(actualYazi.contains(expectedKelime));


        // Tüm sayfanin screenshot'ini almak icin 4 adim gerekiyor

        // 1- TakesScreenShot objesini olusturup deger olarak cast ettigimiz driver'i atayalim
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2- Resmi kaydedecegimiz bir klasör olusturulur
        File fullPageSShot = new File("target/Screenshot/SeleniumSShot.jpeg");

        // 3- ScreenShot objesini kullanarak ekran fotografini cekip gecici dosyaya kaydedelim
        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        // 4- Gecici dosyayi hazirladigimiz file'a kopyalayalim
        FileUtils.copyFile(geciciResim, fullPageSShot);

    }

}
