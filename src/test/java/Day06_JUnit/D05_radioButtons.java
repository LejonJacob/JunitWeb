package Day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class D05_radioButtons {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testFacebook () throws InterruptedException {
        driver.get("https://www.facebook.com");

        WebElement cookiesElement= driver.findElement(By.xpath("(//button[@value=\"1\"])[2]"));
        Thread.sleep(1000);
        cookiesElement.click();

        //“Create an Account” button’una basin
        WebElement yeniHesapButonu= driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        yeniHesapButonu.click();

        //“radio buttons” elementlerini locate edin
        WebElement cinsiyetRadioButtonu= driver.findElement(By.xpath("(//input[@type='radio'])[2]"));

        //Secili degilse cinsiyet butonundan size uygun olani secin
        if (!cinsiyetRadioButtonu.isSelected()){
            cinsiyetRadioButtonu.click();
        }
        Thread.sleep(3000);
    }

    @After
    public void teardown(){
        driver.close();
    }

}