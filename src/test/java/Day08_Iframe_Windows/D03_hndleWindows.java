package Day08_Iframe_Windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class D03_hndleWindows {


        WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void handleWindowTesti() throws InterruptedException {

        /*

        ● Amazon anasayfa adresine gidin.
        ● Sayfa’nin window handle degerini String bir degiskene atayin
        ● Sayfa title’nin “Amazon” icerdigini test edin
        ● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        ● Sayfa title’nin “Wise Quarter” icerdigini test edin
        ● Yeni bir window olusturup, acilan sayfada wallmart.com adresine gidin
        ● Sayfa title’nin “Walmart” icerdigini test edin
        ● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

        */

        // ● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

        // ● Sayfa’nin window handle degerini String bir degiskene atayin
        String ilksayfaHandleDegeri= driver.getWindowHandle();

        // ● Sayfa title’nin “Amazon” icerdigini test edin
        String expectedTitle= "Amazon";
        String actulaTitle = driver.getTitle();

        Assert.assertTrue(actulaTitle.contains(expectedTitle));

        // ● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin

        /*

          driver.switchTo().newWindow() method'u ile yeni bir sayfa olusturup
          driver'i o sayfaya switch ederiz
          bu gecis driver uzerinden yapildigi icin driver da yeni sayfaya gecer
          ve biz yeni sayfada islem yapabiliriz

        */

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");

        // ● Sayfa title’nin “Wise Quarter” icerdigini test edin
        String expectedTitle1 = "Wise Quarter";
        String actualTitle1 = driver.getTitle();

        System.out.println(actualTitle1);
        Assert.assertTrue(actualTitle1.contains(expectedTitle1));

        // ● Yeni bir window olusturup, acilan sayfada wallmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.walmart.com");
        Thread.sleep(3000);

        // ● Sayfa title’nin “Walmart” icerdigini test edin
        String expectedTitle2 = "Walmart";
        String actualTitle2 = driver.getTitle();

        System.out.println(actualTitle2);
        Assert.assertTrue(actualTitle2.contains(expectedTitle2));

        // ● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

        /*

          driver'i switchTo() ile yeni bir tab veya window'a gecirebiliriz
          yeni window olusturmak disinda
          herhangi bir window'a gecmenin TEK BIR YOLU VARDIR
          o da gecmek istedigimiz sayfanin window handle degerini kullanmak
          YANI;
          bir test sirasinda yeniden donmeniz gereken bir window'da iseniz
          o sayfanin window handle degerini KAYDETMELISINIZ

         */

        driver.switchTo().window(ilksayfaHandleDegeri);

        expectedTitle= "Amazon";
        actulaTitle = driver.getTitle();

        Assert.assertTrue(actulaTitle.contains(expectedTitle));


        Thread.sleep(2500);

    }

    @After
    public void teardown(){

        driver.quit();
    }
}
