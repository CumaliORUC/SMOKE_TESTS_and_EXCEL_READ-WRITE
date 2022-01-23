package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utulities.ConfigReader;
import utulities.Driver;

public class webTables {
    /*
    ● http://qa-environment.koalaresorthotels.com /admin/HotelRoomAdmin adresine
    gidin
        ○ Username : manager
        ○ Password : Manager1!
● table() metodu oluşturun
○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
● printRows() metodu oluşturun //tr
○ table body’sinde bulunan toplam satir(row) sayısını bulun.
○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
○ 4.satirdaki(row) elementleri konsolda yazdırın.
● printCells() metodu oluşturun //td
○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
● printColumns() metodu oluşturun
○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
○ 5.column daki elementleri konsolda yazdırın.
     */

    @Test (groups = "decline")
        public void table() {
            KoalaResortPage koalaResortPage=new KoalaResortPage();
            koalaResortPage.koalaResortLogin();
            //Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
                System.out.println("TBODY Dimention=="+koalaResortPage.tbodyallcell.size());
                System.out.println("===================ALL TBODY==================================================");
                System.out.println(koalaResortPage.tbodyData.getText());
                System.out.println("===================HEADERS==================================================");
                System.out.println(koalaResortPage.header.getText());
                Driver.closeDriver();

        }
    @Test (groups = "accept")
        public void printRow() {
            KoalaResortPage koalaResortPage=new KoalaResortPage();
            koalaResortPage.koalaResortLogin();
                System.out.println("Total Rows==> "+koalaResortPage.tbodyRows.size());
                for (WebElement each:koalaResortPage.tbodyRows) {
                    System.out.println(each.getText());
                    }

            //4.satirdaki(row) elementleri konsolda yazdırın.
                System.out.println("=====================ROW 4 INFOSSS   =================");
                System.out.println(koalaResortPage.hotelData(4).getText());
                Driver.closeDriver();
        }
        /*
        ● printCells() metodu oluşturun //td
            ○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
            ○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
         */
    @Test (groups = {"decline"," accept"})
        public void printCell() {
                KoalaResortPage koalaResortPage=new KoalaResortPage();
                koalaResortPage.koalaResortLogin();
                System.out.println("Total Call Numbers=="+koalaResortPage.tbodyallcell.size());

                System.out.println("=========================================CELLS======================================");
                for (WebElement each: koalaResortPage.tbodyallcell) {
                    System.out.println(each.getText());
                }
                Driver.closeDriver();
        }
    /*
    ● printColumns() metodu oluşturun
        ○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
        ○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        ○ 5.column daki elementleri konsolda yazdırın.
     */
    @Test (groups = "decline")
        public void printColumns() {
            KoalaResortPage koalaResortPage=new KoalaResortPage();
            koalaResortPage.koalaResortLogin();
                System.out.println("Toplam Sutun Sayısı="+koalaResortPage.columns.size());

            System.out.println(koalaResortPage.columnData(ConfigReader.getProperty("sutunNo")).getText());

            for (WebElement each: koalaResortPage.columnsList) {
                    System.out.println(each.getText());
            }
            Driver.closeDriver();
        }
}
