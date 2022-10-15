package Day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class D04_checkBoxTest {

        /*

        a. Verilen web sayfasına gidin.
           https://the-internet.herokuapp.com/checkboxes
        b. Checkbox1 ve checkbox2 elementlerini locate edin.
        c. Checkbox1'in secili olmadigini ve
        d. Checkbox2'nin secili oldugunu test edin

         */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void testCheckBox() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[2]"));


        //  c. Checkbox1'in secili olmadigini ve

        if (checkBox1.isSelected()){
            System.out.println("Checkbox1 secili, test FAILED");
        }else{
            System.out.println("Checkbox1 secili degil, test PASSED");
        }

        // d. Checkbox2'nin secili oldugunu test edin
        if (checkBox2.isSelected()){
            System.out.println("Checkbox2 secili, test PASSED");
        }else{
            System.out.println("Checkbox2 secili degil, test FAILED");
        }
    }


    @After
    public void teardown(){
        driver.close();
    }

}