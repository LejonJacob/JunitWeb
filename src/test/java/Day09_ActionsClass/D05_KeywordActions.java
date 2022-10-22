package Day09_ActionsClass;

import Day08_Iframe_Windows.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class D05_KeywordActions extends TestBase {

        @Test
    public void test01(){
            /*
              Klavye'de cok fazla tus olsa da her bir tusla ilgili temel iki islem var
              1- tek seferlik basmak
                sendKeys(keys.ENTER)
              2- uzun sureli basmak ve isim bitince tustan elimizi kaldirmak
                 - basmak icin keyDown()
                 - basili tusu birakmak icin keyUp()
            */

            // https://www.amazon.com anasayfasina gidin
            driver.get("https://www.amazon.com");

            // Arama kutusuna "nutella" yazin
            WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
            aramaKutusu.sendKeys("nutella");

            // Aramayi yapmak icin ENTER tusuna basin
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);

            // Arama kutusunu temizleyelim
            aramaKutusu.clear();


            // Arama kutusuna actions class'ini kullanarak "SamsungA71" yazdirin
            aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

            Actions actions= new Actions(driver);
            threadSleep(1);

            actions.click(aramaKutusu).keyDown(Keys.SHIFT).sendKeys("s")
                                      .keyUp(Keys.SHIFT).sendKeys("amsung")
                                      .keyDown(Keys.SHIFT).sendKeys("a")
                                      .keyUp(Keys.SHIFT).sendKeys("71").sendKeys(Keys.ENTER).perform();

            threadSleep(4);


        }

}
