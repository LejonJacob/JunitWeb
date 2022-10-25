package Day10_FileWaits;

import Utility.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class D03_fileUploadTest extends TestBase {

    @Test
    public void uploadTesti(){
        //Tests packagenin altina bir class oluşturun : C05_UploadFile

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.
        WebElement dosyaSecButonu= driver.findElement(By.id("file-upload"));

        /*

          dosya sec butonuna bastiktan sonra
          bilgisayardan selenium ile dosya secmemiz mumkun degil
          onun yerine
          dosyaSecButonu.sendKeys("DosyaYolu") yaparsak
          dosya secme islemi yapilmis olacaktir

         */

        String yuklenecekDosyaYolu= System.getProperty("user.home") + "\\Desktop\\FileTesti\\deneme.txt";
        //"C:\Users\User\Desktop\FileTesti\deneme.txt"

        dosyaSecButonu.sendKeys(yuklenecekDosyaYolu);
        threadSleep(5);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        threadSleep(5);
        WebElement fileUploadYazielementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadYazielementi.isDisplayed());

    }
}