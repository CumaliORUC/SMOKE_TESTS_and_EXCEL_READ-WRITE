package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utulities.ConfigReader;
import utulities.Driver;

public class smokeTests {
    /*
        USER STORY
        No: US001
        Name : Dogru kullanici adi ve sifre ile sayfaya giris yapilabilmeli
        ACCEPTANCE CRITERIA:
        - http://qa-environment.koalaresorthotels.com adresine gidip
        - dogru kullanici adi ve sifre girdigimde sayfaya giris yapabilmeliyi
     */

    @Test
        public void smokeTestHotelLogin() {
            Driver.getDriver().get(ConfigReader.getProperty("koalaResortUrl"));

            KoalaResortPage koalaResortPage=new KoalaResortPage();

                koalaResortPage.gelismis.click();
                koalaResortPage.addressLink.click();
                koalaResortPage.Login.click();
                koalaResortPage.usurname.sendKeys(ConfigReader.getProperty("kr_valid_username"));
                koalaResortPage.password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
                koalaResortPage.LoginButton.click();
            System.out.println(Driver.getDriver().getCurrentUrl());

            Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("kr_login_url")));

            Driver.closeDriver();
    }
}
