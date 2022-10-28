package Day09_ActionsClass;

import Utility.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;



public class D09_Odev extends TestBase {

        /*

        1- Bir Class olusturalim KeyboardActions2
        2- https://html.com/tags/iframe/ sayfasina gidelim
        3- video’yu gorecek kadar asagi inin
        4- videoyu izlemek icin Play tusuna basin
        5- videoyu calistirdiginizi test edin

         */

    @Test
    public void keyboardActions2(){

        driver.get("https://html.com/tags/iframe/");

        WebElement iframeWindow = driver.findElement(By.xpath("//html[@lang=\"en-US\"]"));

        driver.switchTo().frame(iframeWindow);

        WebElement iframeVideoElementi = driver.findElement(By.xpath("//div[@class=\"render\"]"));

        // https://www.guru99.com/scroll-up-down-selenium-webdriver.html
        JavascriptExecutor javaScript = (JavascriptExecutor) driver;
        javaScript.executeScript("arguments[0].scrollIntoView();", iframeVideoElementi);

        driver.switchTo().defaultContent();

        WebElement playVideo = driver.findElement(By.xpath("//iframe[@width=\"560\"]"));
        playVideo.click();

        WebElement videoOynatmaElementi= driver.findElement(By.xpath("//iframe[@width=\"560\"]"));
        Assert.assertTrue(videoOynatmaElementi.isEnabled());


        threadSleep(3);



    }

//TODO***********************       Nevzat'in Cözümüne Uygulanan Scroll Sayfa Kaydirma      *********************************


    @Test
    public void test01(){
        driver.get("https://html.com/tags/iframe/");

        // https://www.guru99.com/scroll-up-down-selenium-webdriver.html
        WebElement iframeVideoElementi = driver.findElement(By.xpath("//div[@class=\"render\"]"));

        JavascriptExecutor javaScript = (JavascriptExecutor) driver;
        javaScript.executeScript("arguments[0].scrollIntoView();", iframeVideoElementi);

        WebElement ilkIframe= driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(ilkIframe);
        threadSleep(2);

        WebElement playButton= driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        playButton.click();

        WebElement isvideoPlayed=driver.findElement(By.xpath("//video[@class='video-stream html5-main-video']"));
        Assert.assertTrue(isvideoPlayed.isDisplayed());

    }

}
