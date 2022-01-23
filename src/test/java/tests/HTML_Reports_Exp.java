package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utulities.ConfigReader;
import utulities.Driver;
import utulities.TestBaseReport;

public class HTML_Reports_Exp extends TestBaseReport {

    @Test
        public void smokeTestHotelLogin() {
            Driver.getDriver().get(ConfigReader.getProperty("koalaResortUrl"));
            //1-  extends to TestBaseReport
            //2-  extentTest=extentReports.createTest(“test ismi”,”tanım”) rapor oluşturalım.
                    extentTest=extentReports.createTest("smoke Test","Pozitif Login Test");

        	//3-    Gerekli/istedigimiz satirlara extentTest.info(“Aciklama”) ekleyelim.

                KoalaResortPage koalaResortPage=new KoalaResortPage();

                    koalaResortPage.gelismis.click();
                        extentTest.info("gelismis tab was clicked");

                    koalaResortPage.addressLink.click();
                        extentTest.info("Address tab was clicked");

                    koalaResortPage.Login.click();
                        extentTest.info("Login icon was clicked");

                    koalaResortPage.usurname.sendKeys(ConfigReader.getProperty("kr_valid_username"));
                        extentTest.info("Username was wroten");

                    koalaResortPage.password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
                        extentTest.info("Password was wroten");

                    koalaResortPage.LoginButton.click();
                        extentTest.info("Login Button was clicked");
                        System.out.println(Driver.getDriver().getCurrentUrl());

                    Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("kr_login_url")));
                        extentTest.pass("Assert passed");
            Driver.closeDriver();
    }
}
