package Day07_HandleDropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class D01_handleDropDownMenu {

        WebDriver driver;

        @Before
    public void stup(){

            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        }

        @Test
    public void dropDownTest(){
            driver.get("https://www.amazon.com");

            WebElement dropDownElement = driver.findElement(By.id("searchDropDownBox"));
            Select selekt= new Select(dropDownElement);
            selekt.selectByVisibleText("Electronics");

        }

        @After
    public void teardown(){
            driver.close();

        }


}
