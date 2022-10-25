package Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

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

}