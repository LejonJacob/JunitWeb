package Day12_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class D04_ReadExcel3 {

      @Test
    public void readExcellTest3() throws IOException {

          // Ülkeler excell'inde Türkce ülke isimleri "Senegal" iceriyor mu test edin
          // Toplam 190 ülke oldugunu test edin
          // En zun ülke isminin Mikronezya Federal Devletleri oldugunu test edin

          String dosyaYolu = System.getProperty("user.home") + "\\Desktop\\FileTesti\\ulkeler.xlsx";

          FileInputStream fis3 =new FileInputStream(dosyaYolu);

          Workbook workbook = WorkbookFactory.create(fis3);

          List<String > ulkelerListi = new ArrayList<>();

          int sonSatirIndexi = workbook.getSheet("Sayfa1").getLastRowNum();

          for (int i = 0; i <sonSatirIndexi ; i++) {

              ulkelerListi.add(workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString());

          }

          ulkelerListi.remove(0);
          System.out.println(ulkelerListi);

          // 1- Ülkeler excell'inde Türkce ülke isimleri "Senegal" iceriyor mu test edin
          Assert.assertTrue(ulkelerListi.contains("Senegal"));

          // 2- Toplam 190 ülke oldugunu test edin
          Assert.assertEquals(ulkelerListi.size(), 190);

          // 3- En zun ülke isminin Mikronezya Federal Devletleri oldugunu test edin
          String enUzunIsim="Macaristan";

          for (String eachIsim : ulkelerListi){

              if (eachIsim.length()>enUzunIsim.length()){
                  enUzunIsim=eachIsim;

              }

          }

          System.out.println(enUzunIsim);

          System.out.println("En uzun isimli ulke : " + enUzunIsim);
          Assert.assertEquals("Mikronezya Federal Devletleri",enUzunIsim);

      }
}
