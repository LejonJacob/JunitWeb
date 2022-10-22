package Day09_ActionsClass;

import Day08_Iframe_Windows.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class D02_mouseAction2 extends TestBase {

    @Test
    public void test2() throws InterruptedException {

        /*
            1- Yeni bir class olusturalim: MouseActions2
            2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
            3- Cizili alan uzerinde sag click yapalim
            4- Alert’te cikan yazinin “You selected a context menu” oldugunu
               test edelim.
            5- Tamam diyerek alert’i kapatalim
            6- Elemental Selenium linkine tiklayalim
            7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        */

        // 2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // 3- Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);

        WebElement alticiziliAlan = driver.findElement(By.id("hot-spot"));
        actions.contextClick(alticiziliAlan).perform();

        // 4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.

        String expectedAlertYazi ="You selected a context menu";
        String actualAlertYazisi = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazi, actualAlertYazisi);

        // 5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaHandleDegeri= driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()=\"Elemental Selenium\"]")).click();

        // 7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        // Önce driver'i 2. sayfaya gecirmeliyiz, bunun icinde 2. sayfanin handle degerini bulmaliyiz
        Set<String> handleDegerlerSeti = driver.getWindowHandles();
        String ikincisayfaHandleDegeri = "";

        for (String eachHandleDegeri : handleDegerlerSeti){

            if (!eachHandleDegeri.equals(ilkSayfaHandleDegeri)){
                ikincisayfaHandleDegeri=eachHandleDegeri;
            }

        }

        WebElement h1TagElementi= driver.findElement(By.tagName("h1"));

        String expectedTagYazisi="Elemental Selenium";
        String actualTagYazisi= h1TagElementi.getText();
        Assert.assertEquals(expectedTagYazisi,actualTagYazisi);

        Thread.sleep(3500);



    }

}
