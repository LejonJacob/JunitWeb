package Day09_ActionsClass;

import Day08_Iframe_Windows.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class D07_FakerClassKullanimi extends TestBase {

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
        driver.findElement(By.xpath("//*[@title='Sadece temel çerezlere izin ver']")).click();
        driver.findElement(By.linkText("Yeni Hesap Oluştur")).click();

        // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));

        Faker faker = new Faker();

        Actions actions = new Actions(driver);
        String eMail= faker.internet().emailAddress();

        actions.click(isimKutusu).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).sendKeys(eMail)
                .sendKeys(Keys.TAB).sendKeys(eMail).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("13")
                .sendKeys(Keys.TAB).sendKeys("Oct").sendKeys(Keys.TAB).sendKeys("2000")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_LEFT)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        // 4- Kaydol tusuna basalim

        threadSleep(4);


    }
}
