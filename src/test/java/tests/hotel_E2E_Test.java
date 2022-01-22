package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utulities.ConfigReader;
import utulities.Driver;

public class hotel_E2E_Test {
    /*
    1. Tests packagenin altına class olusturun: D17_CreateHotel
2. Bir metod olusturun: createHotel
3. http://qa-environment.koalaresorthotels.com adresine git.
4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri
girin.
a. Username : manager
b. Password : Manager1!
5. Login butonuna tıklayın.
6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
8. Save butonuna tıklayın.
9. “Hotel was inserted successfully” textinin göründüğünü test edin.
10. OK butonuna tıklayın
     */

    @Test
        public void Koala_CreateHotel() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("koalaResortUrl"));
            KoalaResortPage koalaResortPage=new KoalaResortPage();
            koalaResortPage.koalaResortLogin();

           // koalaResortPage.SystemManagement.click();
            koalaResortPage.HotelManagemetTap.click();
            koalaResortPage.HotelListTap.click();
            koalaResortPage.ADDHotel.click();
            koalaResortPage.HotelCode.click();

            Faker faker=new Faker();
            Actions actions=new Actions(Driver.getDriver());

            actions.click(koalaResortPage.HotelCode).sendKeys(faker.numerify("126"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.name().fullName())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.address().fullAddress())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.phoneNumber().phoneNumber())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.internet().emailAddress()).perform();

            Select select=new Select(koalaResortPage.IDgroupSections);
                select.selectByVisibleText("Hotel Type2");

            koalaResortPage.HotelSave.click();


            Thread.sleep(5000);
                System.out.println(koalaResortPage.HotelCreateSuccesfull.getText());
            Assert.assertTrue(koalaResortPage.HotelCreateSuccesfull.isDisplayed());
            koalaResortPage.HotelCreationOKbutton.click();

        Driver.closeDriver();
    }
}
