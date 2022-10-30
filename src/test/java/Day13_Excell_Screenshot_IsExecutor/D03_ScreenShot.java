package Day13_Excell_Screenshot_IsExecutor;

import Utility.TestBase;
import org.junit.Test;

import java.io.IOException;

public class D03_ScreenShot extends TestBase {

    @Test
    public void test01() throws IOException {

        driver.get("https://www.amazon.com");

        fullPageScreenShot();
        threadSleep(1);


        driver.get("https://www.youtube.com");
        fullPageScreenShot();


    }
}
