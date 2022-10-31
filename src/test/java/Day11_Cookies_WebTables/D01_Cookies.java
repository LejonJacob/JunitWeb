package Day11_Cookies_WebTables;

import Utility.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class D01_Cookies extends TestBase {


    @Test
    public void test01(){

        driver.get("https://www.youtube.com");

        TestBase.threadSleep(4);
        driver.findElement(By.xpath("//span[text()=\"Tümünü reddet\"]")).click();

        Set<Cookie> cookiesSeti =  driver.manage().getCookies();

        for ( Cookie eachCookie : cookiesSeti){

            System.out.println(eachCookie);

        }

        System.out.println("==========");

        Cookie cookies=new Cookie("en guzel cookie", "bizim cookie");
        driver.manage().addCookie(cookies);
        cookiesSeti= driver.manage().getCookies();

        for (Cookie eachCookie: cookiesSeti) {

            System.out.println(eachCookie);
        }

        threadSleep(3);

    }


}
