package Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBase {

    protected WebDriver driver;

    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void teardown(){

        driver.quit();
    }

    public static void threadSleep(int beklenecekSaniye){

        try{
            Thread.sleep(beklenecekSaniye*1000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void fullPageScreenShotMethod() throws IOException {

        // Tüm sayfanin screenshot'ini almak icin 4 adim gerekiyor

        // 1- TakesScreenShot objesini olusturup deger olarak cast ettigimiz driver'i atayalim
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2- Resmi kaydedecegimiz bir klasör olusturulur
        //    Resim isimlerini dinamik yapmak ve resmin tarihini eklemek icin
        //    Resim dosya yoluna tarih ekleyelim
        LocalDateTime ldt = LocalDateTime.now();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");

        File fullPageSShot = new File("target/Screenshot/SeleniumSShot"+ ldt.format(dtf) +".jpeg");


        // 3- ScreenShot objesini kullanarak ekran fotografini cekip gecici dosyaya kaydedelim
        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        // 4- Gecici dosyayi hazirladigimiz file'a kopyalayalim
        FileUtils.copyFile(geciciResim, fullPageSShot);


    }

    public void webElementScreenShot(WebElement target) throws IOException{

        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("YYMMddHHmmss");

        File locateElementSShot = new File("target/Screenshot/SeleniumSShot"+ ldt.format(dtf) +".jpeg");

        File geciciResim = target.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciResim, locateElementSShot);


    }

}
