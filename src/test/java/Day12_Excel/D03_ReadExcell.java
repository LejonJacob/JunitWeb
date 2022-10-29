package Day12_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class D03_ReadExcell {

    @Test
    public void readExcellTest() throws IOException {

        // Ülkeler exceline gidin
        // 32. satirdaki ülke isminin Ingilizce "Canada" oldugunu test edin

        String dosyaYolu = System.getProperty("user.home") + "\\Desktop\\FileTesti\\ulkeler.xlsx";

        FileInputStream fis1 =new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis1);

        String actualIsim = workbook.getSheet("Sayfa1").getRow(31)
                                    .getCell(0).toString();

        System.out.println(actualIsim);

        String expectedIsim = "Canada";

        Assert.assertEquals(expectedIsim, actualIsim);


    }
}
