package Day12_Excel;

import Utility.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class D01_WebTableOdev extends TestBase {

    @Test
    public void webTableOdev(){

        /*

         1. “https://demoqa.com/webtables” sayfasina gidin
         2. Headers da bulunan basliklari yazdirin
         3. 3. sütunun basligini yazdirin
         4. Tablodaki tum datalari yazdirin
         5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
         6. Tablodaki satir sayisini yazdirin
         7. Tablodaki sutun sayisini yazdirin
         8. Tablodaki 3.kolonu yazdirin
         9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
         10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin

         */

        // 1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        // 2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslikElementListi= driver.findElements(By.xpath("div[@class=\"rt-th rt-resizable-header -cursor-pointer\"]"));

        for(WebElement eachElement : baslikElementListi){
            System.out.println(eachElement.getText() + " ---- ");

        }

        // 3. 3. sütunun basligini yazdirin
        System.out.println("");
        System.out.println(baslikElementListi.get(2).getText());

        // 4. Tablodaki tum datalari yazdirin
        List<WebElement> dataElementListi= driver.findElements(By.xpath("//div[@class=\"rt-td\"]"));

        for(WebElement eachData : dataElementListi){
            System.out.println(eachData.getText());

        }

        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        int sayac = 0;

        for (WebElement eachCell : dataElementListi){

            if (!eachCell.getText().isBlank()){
                sayac++;

            }
        }
        System.out.println("Tabloda Bos olmayan data sayisi: " + sayac);

        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementListi= driver.findElements(By.xpath("//div[@class=\"rt-tr-group\"]"));

        System.out.println("Tablodaki satir sayisi: " + satirElementListi.size());

        // 7. Tablodaki sutun sayisini yazdirin
        System.out.println("Tablodaki sütun sayisi: " + baslikElementListi.size());

        // 8. Tablodaki 3.kolonu yazdirin
        // Tablo, table tag'lari ile olusturulmadigindan data bilgisine dinamik olarak ulasamadik
        for (int i = 2; i < dataElementListi.size(); i+=7) {

            System.out.println(dataElementListi.get(i).getText());

        }

        // 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
        for (int i = 0; i < dataElementListi.size(); i++) {

            if (dataElementListi.get(i).getText().equalsIgnoreCase("Kierra")){

                System.out.println("Kierra'nin maasi : "+ dataElementListi.get(i+4).getText());
            }

        }

        // 10. class icerisinde bir method olusturun,
        // Test sayfasindan satir ve sütun sayisini girdigimde bana datayi yazdirsin


    }

}
