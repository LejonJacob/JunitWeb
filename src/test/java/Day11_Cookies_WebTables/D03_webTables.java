package Day11_Cookies_WebTables;

import Utility.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class D03_webTables extends TestBase {

    @Test
    public void amazonTest(){

        // 1- Amazon anasayfaya gidin
        // 2- En altdaki web table'dan home service secenegini tiklayin
        // 3- Ilgili sayfaya gittigini test edin

        // 1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // 2- En altdaki web table'dan home service secenegini tiklayin
        WebElement amazonTableElement = driver.findElement(By.xpath("//table//tr[3]//td[5]"));
        amazonTableElement.click();

        // 3- Ilgili sayfaya gittigini test edin
        WebElement baslikYaziElementi = driver.findElement(By.xpath("//img[@alt=\"Home services appointments during COVID-19\"]"));

        Assert.assertTrue(baslikYaziElementi.isDisplayed());

        threadSleep(2);

        // 4- Tüm table body'sinde "care" kelimesinin icermedigini test edin
        WebElement tableBody = driver.findElement(By.xpath("//table//tbody"));
        System.out.println(tableBody.getText());

        Assert.assertFalse(tableBody.getText().contains("care"));


    }

}
