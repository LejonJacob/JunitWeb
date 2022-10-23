package Day10_FileWaits;

import Day08_Iframe_Windows.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Files;
import java.nio.file.Paths;

public class D02_FileDownloadTest extends TestBase {

    @Test
    public void downloadTest(){

        /*

        1. Tests packagenin altina bir class oluşturalim : D02_FileDownload
        2. https://the-internet.herokuapp.com/download adresine gidelim.
        3. code.txt dosyasını indirelim
        4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        */

        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. logo.png dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='logo.png']")).click();

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        threadSleep(5);

        // 4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = System.getProperty("user.home") + "\\Downloads\\logo.png";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}
