package Day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class D09_YoutubeTest {

    static WebDriver driver;

    @BeforeClass
    public static void setupDriver(){

        /*

        1) Bir class oluşturun: YoutubeAssertions
        2) https://www.youtube.com adresine gidin
        3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
         ○ titleTest  => Sayfa başlığının “YouTube” oldugunu test edin
         ○ imageTest  => YouTube resminin görüntülendiğini (isDisplayed()) test edin
         ○ Search Box ’in erisilebilir oldugunu test edin (isEnabled())
         ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

         */

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void tittleTestYoutube() throws InterruptedException {

        driver.get("https://www.youtube.com");
        WebElement cookiesElement= driver.findElement(By.xpath("//yt-formatted-string[text()=\"Tümünü reddet\"]"));
        Thread.sleep(1000);
        cookiesElement.click();

        String expectedTitle= "YouTube";
        String actulaTitle= driver.getTitle();

        Assert.assertTrue(expectedTitle.contains(actulaTitle));


    }

    @Test
    public void imageTestYoutube() throws InterruptedException {

        driver.get("https://www.youtube.com");

        // WebElement cookiesElement= driver.findElement(By.xpath("//yt-formatted-string[text()=\"Tümünü reddet\"]"));
        // cookiesElement.click();

        //○ imageTest     => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logoYoutubeElement = driver.findElement(By.xpath("(//yt-icon[@id=\"logo-icon\"])[1]"));

        Assert.assertTrue(logoYoutubeElement.isDisplayed());


    }

    @Test
    public void aramaKutusuTesti() throws InterruptedException {

        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        driver.get("https://www.youtube.com");

        // WebElement cookiesElement= driver.findElement(By.xpath("//yt-formatted-string[text()=\"Tümünü reddet\"]"));
        // cookiesElement.click();

        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='search']"));

        Assert.assertTrue(aramaKutusu.isEnabled());
    }

    @Test
    public void negatifTitleTest() throws InterruptedException {

        driver.get("https://www.youtube.com");

        // WebElement cookiesElement= driver.findElement(By.xpath("//yt-formatted-string[text()=\"Tümünü reddet\"]"));
        // cookiesElement.click();

        // ○ titleTest    => Sayfa başlığının “youTube” olmadigini test edin
        String expectedYanlisTitle="youTube";
        String actualTitle= driver.getTitle();
        Assert.assertNotEquals(expectedYanlisTitle,actualTitle);
    }

    @AfterClass
    public static void teardown(){
        driver.close();

    }


}
