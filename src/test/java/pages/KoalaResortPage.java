package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utulities.ConfigReader;
import utulities.Driver;

import java.util.List;

public class KoalaResortPage {
    //1 Create driver

            public KoalaResortPage() {

        // initialize driver with PageFactory
            PageFactory.initElements(Driver.getDriver(),this);
            }
        @FindBy (linkText ="Log in")
            public WebElement Login;

        @FindBy (css="#UserName")
            public WebElement usurname;

        @FindBy (css="#Password")
            public WebElement password;

        @FindBy (css="#btnSubmit")
            public WebElement LoginButton;

        @FindBy (css="button#details-button")
            public WebElement gelismis;

        @FindBy (css="#proceed-link")
            public WebElement addressLink;

        @FindBy (xpath = "//span[text()='Try again please']")
            public WebElement wrongLogin;

        @FindBy (xpath = "(//span[@class='title'])[3]")
            public WebElement HotelManagemetTap;

        @FindBy (linkText = "Hotel List")
            public WebElement HotelListTap;

        @FindBy (css = ".hidden-480")
            public WebElement ADDHotel;

        @FindBy (xpath = "//span[@class='title']")
            public WebElement SystemManagement;

        @FindBy (id = "Code")
            public WebElement HotelCode;

        @FindBy (id = "IDGroup")
            public  WebElement IDgroupSections;

        @FindBy (id = "btnSubmit")
            public WebElement HotelSave;

        @FindBy (css =".bootbox-body")
            public WebElement HotelCreateSuccesfull;

        @FindBy(xpath = "//button[@data-bb-handler='ok']")
            public WebElement HotelCreationOKbutton;

        @FindBy(xpath = "//tbody//td")
            public List<WebElement> tbodyallcell;

        @FindBy(xpath = "//tbody")
            public  WebElement tbodyData;

        @FindBy (xpath = "//thead//tr")
            public WebElement header;

        @FindBy(xpath = "//tbody//tr")
            public List<WebElement> tbodyRows;

        @FindBy(xpath = "//tbody/tr[1]//td")
            public List<WebElement> columns;

        @FindBy(xpath = "//tbody/tr//td[5]" )
            public List<WebElement> columnsList;

        public void koalaResortLogin() {
            Driver.getDriver().get(ConfigReader.getProperty("koalaResortUrl"));
                    gelismis.click();
                    addressLink.click();
                    Login.click();
                    usurname.sendKeys(ConfigReader.getProperty("kr_valid_username"));
                    password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
                    LoginButton.click();
        }

        public WebElement  hotelData(int Number) {
            int rowNumber=Number-1;
            String rowXpath="//tbody//tr["+rowNumber+"]";
            return Driver.getDriver().findElement(By.xpath(rowXpath));
        }

        public WebElement columnData(String number) {
            WebElement columnXpath=Driver.getDriver().findElement(By.xpath("//tbody//tr//td["+number+"]"));
            return columnXpath;
        }

        public WebElement cellInfo(String rowNumber, String columnNumber) {
            WebElement cellInfoXpath=Driver.getDriver().findElement(By.xpath("//tbody//tr["+rowNumber+"]//td["+columnNumber+"]"));
            return cellInfoXpath;
        }

    }
