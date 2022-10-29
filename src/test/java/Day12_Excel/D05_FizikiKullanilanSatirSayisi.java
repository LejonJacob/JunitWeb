package Day12_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class D05_FizikiKullanilanSatirSayisi {

    @Test
    public void test01() throws IOException {

        String dosyaYolu = System.getProperty("user.home") + "\\Desktop\\FileTesti\\ulkeler.xlsx";

        FileInputStream fis5 =new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis5);

        int toplamSatirSayisi = workbook.getSheet("Sayfa2").getLastRowNum();
        // index kullandigi icin satir sayisini bulmak icin 1 ekleyelim
        System.out.println("Toplam satir sayisi: " + toplamSatirSayisi);

        int fizikiKullanilanSatirSayisi = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();

        System.out.println("Fiziki Kullanilan Satir Sayisi: " + fizikiKullanilanSatirSayisi);
        

    }
}
