package tests;

import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utulities.ConfigReader;
import utulities.Driver;

public class webTables2 {
    /*
     //1. Bir metod oluşturun : printData(int row, int column);
    //	a. Satır(row) ve sütun(column) numarasını girdiğinizde,
    //	printData metodu bu 	hücredeki(cell) veriyi yazdırmalıdır.
    //2. Baska bir Test metodu oluşturun: printDataTest();
    //	a. Ve bu metodu printData() methodunu cagirmak icin kullanin.
    //	b. Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
    //	c. yazdirilan datanin olmasi gereken dataya esit oldugunu test edin
     */
    @Test
        public void printData() {
            KoalaResortPage koalaResortPage=new KoalaResortPage();
            koalaResortPage.koalaResortLogin();
                System.out.println(koalaResortPage.cellInfo(ConfigReader.getProperty("rowNumber"),ConfigReader.getProperty("columnNumber")).getText());
            Driver.closeDriver();
        }
}
