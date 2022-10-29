package Day12_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class D06_ExcelliMapYampa {

    @Test
    public void excellMapTesti() throws IOException {

        // Bazen Excell'deki tüm datayi kod alanimiza almak isteriz

        String dosyaYolu = System.getProperty("user.home") + "\\Desktop\\FileTesti\\ulkeler.xlsx";

        FileInputStream fis =new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        // Excell'de birden fazla sütün oldugu icin List gibi bir yapiya bu bilgileri depolamak mümkün olmaz
        // Reel database'e en yakin java yapisi olan Map kullanabiliriz


        // Ingilizce ülke ismi Key olsun
        // Diger 3 bilgiyi birlestirdigimiz String ise value olsun

        Map<String, String> ulkelerMapi= new TreeMap<>();

        int sonSatirIndexi = workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <sonSatirIndexi ; i++) {

            String keyUlke= workbook.getSheet("Sayfa1").getRow(i)
                                    .getCell(0).toString();

            String valueUlke = workbook.getSheet("Sayfa1").getRow(i)
                                       .getCell(1).toString() + ", "
                              + workbook.getSheet("Sayfa1").getRow(i)
                                        .getCell(2).toString() + ", "
                              + workbook.getSheet("Sayfa1").getRow(i)
                                        .getCell(3).toString() + ", ";

            ulkelerMapi.put(keyUlke,valueUlke);

        }

        System.out.println(ulkelerMapi);


        // ingilizce ismi Barbados olan ulkenin baskent isminin
        // ingilizce olarak Bridgetown oldugunu test edin
        String barbadosValue = ulkelerMapi.get("Barbados");

        System.out.println(barbadosValue); // Bridgetown, Barbados, Bridgetown,

        String[] barbadosValueArrayi = barbadosValue.split(", ");

        String actualBaskentIsmi= barbadosValueArrayi[0];
        String expectedBaskentIsmi="Bridgetown";

        Assert.assertEquals(expectedBaskentIsmi,actualBaskentIsmi);


    }
}
