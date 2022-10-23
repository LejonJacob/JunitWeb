package Day10_FileWaits;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class D01_FileExist {

        @Test
    public void test10(){

            System.out.println(System.getProperty("user.dir")); // C:\Users\User\IdeaProjects\JUnitWeb

            System.out.println(System.getProperty("user.home")); // C:\Users\User

            // masa üstünde olusturdugumuz txt file'in path'i
            // "C:\Users\User\Desktop\FileTesti\deneme.txt"
            // "C:\Users\User\Downloads"

            /*

              System.getProperty("user.home") tum bilgisayarlarda kullaniciya kadar olan path'i verir;
              ve bu kisim her bilgisayar ve her kullanici icin farklidir.
              user.home'dan sonrasi tum kullanicilar ortak olabilir.
              ornegin tum kullanicilarin masaustu:
              user.home / Desktop
              downloads %90 kullanici icin
              user.home / Downloads

              Eger birden fazla bilgisayarda file ile ilgili bir test yapacaksaniz
              dosya yolunu dinamik olarak olusturmaniz gerekir

            */

            // dinamik dosya yolu olusturma
            // masa ustunde FileTesti diye bir klasor ve onun altinda deneme diye bir text dosyasi icin

            String dosyaYolu = System.getProperty("user.home") + "\\Desktop\\FileTesti\\deneme.txt";
            System.out.println(Files.exists(Paths.get(dosyaYolu))); // true veya false

        }
}
