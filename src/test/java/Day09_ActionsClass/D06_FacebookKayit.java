package Day09_ActionsClass;

import Utility.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class D06_FacebookKayit extends TestBase {


    @Test
    public void facebookTest(){

        /*

         1- https://www.facebook.com adresine gidelim
         2- Varsa Cookies'leri kabul veya reddedin, Yeni hesap olustur butonuna basalim
         3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
         4- Kaydol tusuna basalim

        */

        // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        // 2- Varsa Cookies'leri kabul veya reddedin, Yeni hesap olustur butonuna basalim
        driver.findElement(By.linkText("Create New Account")).click();

        // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@name=‘firstname’]"));

        Actions actions = new Actions(driver);

        actions.click(isimKutusu).sendKeys("Jacob").sendKeys(Keys.TAB)
                .sendKeys("Lejon").sendKeys(Keys.TAB).sendKeys("arrode1234@xmail.com")
                .sendKeys(Keys.TAB).sendKeys("arrode1234@xmail.com").sendKeys(Keys.TAB)
                .sendKeys("12345Arti").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("13")
                .sendKeys(Keys.TAB).sendKeys("Oct").sendKeys(Keys.TAB).sendKeys("2000")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_LEFT)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        // 4- Kaydol tusuna basalim

        threadSleep(4);


    }

}
