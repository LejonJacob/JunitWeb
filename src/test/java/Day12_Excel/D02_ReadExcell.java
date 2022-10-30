package Day12_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class D02_ReadExcell {

    @Test
    public void excellTest() throws IOException {

        /*

        7. Dosya yolunu bir String degiskene atayalim
        8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        10. WorkbookFactory.create(fileInputStream)
        11. Worksheet objesi olusturun workbook.getSheetAt(index)
        12. Row objesi olusturun sheet.getRow(index)
        13. Cell objesi olusturun row.getCell(index)

         */

        // 7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = System.getProperty("user.home") + "\\Desktop\\FileTesti\\ulkeler.xlsx";


        // 8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis =new FileInputStream(dosyaYolu);


        // 9. Workbook objesi olusturalim, parametre olarak fileInputStream objesini girelim
        // 10. WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        /*

          37. satirda kod alemimizde bir workbook olusturup
          fis objesi ile okunan excell'deki bilgileri workbook'a yukledik
          boylece excell'dfeki datalarin bir kopyasi workbook objesine yuklendi

         */


        // 11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1");


        // 12. Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(2);


        // 13. Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(2);

        System.out.println(cell); // Arnavutluk


        // 14- 14. satirdaki ülkenin Türkcesinin Bahreyn oldugunu test edin
        String  expectedIsim = "Bahreyn";
        String  actualIsim = cell.toString();

        Assert.assertEquals(expectedIsim, actualIsim);


        fis.close();

    }


}
