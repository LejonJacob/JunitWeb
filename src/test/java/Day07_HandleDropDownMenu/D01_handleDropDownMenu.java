package Day07_HandleDropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

        /*
          Dropdown menuler ozel web elementleridir ve select tag'i ile olusturulurlar
          1- dropdown menuyu locate edelim
          2- dropdown menulerden option secebilmek icin Select class'indan obje olusturmaliyiz
             obje'ye handle etmek istedigimiz dropdown'i parametre olarak girmeliyiz
          3- locate ettigimiz ve select objesi olusturdugumuz menuden option secmek icin
             - index
             - value
             - visibletext
             ile istedigimiz option'i secebiliriz.
         */



        @Test
    public void dropDownTest(){

            // amazona gidin
            // Arama kutusunun solundaki search-in menusunden Electronics'i secin
            // arama cubuguna Java yazip aratin
            // bulunan sonuc sayisinin 1000'den fazla oldugunu test edin

            driver.get("https://www.amazon.com");

            WebElement dropDownElement = driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]"));
            Select selekt= new Select(dropDownElement);
            selekt.selectByVisibleText("Electronics");

            // arama cubuguna Java yazip aratin
            WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
            aramaKutusu.sendKeys("Java" + Keys.ENTER);

            // bulunan sonuc sayisinin 1000'den fazla oldugunu test edin
            WebElement aramaSonucElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
            String aramaSonucStr=aramaSonucElementi.getText();

            // System.out.println(aramaSonucStr); // 1-24 of 127 results for "Java"
            int indexOfOf=aramaSonucStr.indexOf("of");
            int indexOfResults=aramaSonucStr.indexOf("results");
            int aramaSonucSayisiInt= Integer
                    .parseInt(aramaSonucStr
                            .substring(indexOfOf+3,indexOfResults-1));

            Assert.assertTrue(aramaSonucSayisiInt>1000);

        }

        @After
    public void teardown(){
            driver.close();

        }


}
