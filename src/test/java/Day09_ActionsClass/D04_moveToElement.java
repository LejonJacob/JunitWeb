package Day09_ActionsClass;

import Utility.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class D04_moveToElement extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        // Yeni bir class olusturalim: MouseActions4

        // 1- https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");

        // 2- Sag ust bolumde bulunan “Account & Lists”
        // Menüsünün acilmasi icin mouse’u bu menunun ustune getirelim

        WebElement accountAndListElementi= driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        Actions actions= new Actions(driver);
        actions.moveToElement(accountAndListElementi).perform();

        //3- “Create a list” butonuna basalim
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();


        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        WebElement yourListElementi= driver.findElement(By.id("my-lists-tab"));
        Assert.assertTrue(yourListElementi.isDisplayed());
        threadSleep(5);

    }


}
