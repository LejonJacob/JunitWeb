package Day07_HandleDropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class D04_handleAlerts {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

        /*

        ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        ● Bir metod olusturun: acceptAlert
         ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
              “You successfully clicked an alert” oldugunu test edin.
        ● Bir metod olusturun: dismissAlert
         ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
              “successfuly” icermedigini test edin.
        ● Bir metod olusturun: sendKeysAlert
         ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
              tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

         */

    @Test
    public  void alertTest() throws InterruptedException {

        // ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve

        WebElement jsAlertsElement = driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));
        jsAlertsElement.click();

        driver.switchTo().alert().accept();

        // result mesajının “You successfully clicked an alert” oldugunu test edin.

        String expectedSonucYazi = "You successfully clicked an alert";
        String actualSonucYazisi = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();

        Assert.assertEquals(expectedSonucYazi, actualSonucYazisi);
        Thread.sleep(2000);


    }

    @Test
    public void dismissAlertTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("//button[text()=\"Click for JS Confirm\"]")).click();
        Thread.sleep(2000);

        // uyarıdaki Cancel butonuna tıklayın ve
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);

        // result mesajının “successfuly” icermedigini test edin.
        String actualSonucYazisi= driver.findElement(By.xpath("//p[@id='result']")).getText();
        String unexpectedSonuc="successfuly";
        Assert.assertFalse(actualSonucYazisi.contains(unexpectedSonuc));
    }

    @Test
    public void sendKeysTesti() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //○ 3. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);

        // Uyarıdaki metin kutusuna isminizi yazin
        driver.switchTo().alert().sendKeys("Jacob Lejon");
        Thread.sleep(3000);

        // OK butonuna tıklayın
        driver.switchTo().alert().accept();

        // ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actualSonucYazisi= driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedIsim="Jacob Lejon";
        Thread.sleep(3000);
        Assert.assertTrue(actualSonucYazisi.contains(expectedIsim));
    }

    @After
    public void teardown(){
        driver.close();
    }


}
