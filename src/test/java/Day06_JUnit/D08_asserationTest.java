package Day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class D08_asserationTest {

    static WebDriver driver;

    @BeforeClass
    public static void setupDriver(){

        /*

        1) Bir class oluşturun: BestBuyAssertions
        2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
         ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
         ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
         ○ logoTest => BestBuy logosunun görüntülendigini test edin
         ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

         */

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        }

    @Test
    public void bestBuyUrlTest(){

        driver.get("https://www.bestbuy.com/");
        System.out.println(driver.getCurrentUrl());

        String expectedlUrl="https://www.bestbuy.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(expectedlUrl, actualUrl);

    }

    @Test
    public void bestBuyTitleTest(){

        driver.get("https://www.bestbuy.com/");

        String expectedYanlisTitle= "Rest";
        String actulaTitle= driver.getTitle();

        Assert.assertFalse(expectedYanlisTitle.contains(actulaTitle));

    }

    @Test
    public void bestBuyLogoTest(){

        driver.get("https://www.bestbuy.com/");

        WebElement logoElement = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));

        Assert.assertTrue(logoElement.isDisplayed());

    }

    @Test
    public void bestBuyFrancaiseTest(){

        driver.get("https://www.bestbuy.com/");

        WebElement francaiseElement = driver.findElement(By.xpath("//button[@lang='fr']"));

        Assert.assertTrue(francaiseElement.isDisplayed());


    }

       @AfterClass
        public static void tearDawn(){

            driver.close();

       }

}
