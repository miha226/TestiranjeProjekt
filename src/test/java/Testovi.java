//FirstTest.java

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
public class Testovi {
    //-------------------Global Variables-----------------------------------
//Declare a Webdriver variable
    public WebDriver driver;
    public Google google;
    public demoblaze demoblaze;
    //----------------------Test Setup-----------------------------------
    @BeforeTest
    @Parameters("browser")
    public void init(String browser) {

        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
        }
        google = new Google(driver);
        demoblaze = new demoblaze(driver);
    }


    @Test
    public void googleSearchTest() throws InterruptedException {
        google.navigateToGoogle();
        google.GoogleSearch("demoblaze");
        WebElement testLink = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/div/a/h3"));
        Assert.assertEquals(testLink.getText(), "BlazeDemo");
    }



    @Test(priority = 1)
    public void createAccount() throws InterruptedException {
        demoblaze.navigateToDemoblaze();
        demoblaze.clickSignUp();
        demoblaze.SignUpwriteUsername("test");
        demoblaze.SignUpwritePassword("test");
        demoblaze.signUpClickButtonAccept();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"This user already exist.");
        alert.accept();
        demoblaze.signUpClickButtonClose();
        Thread.sleep(1000);
    }
    @Test(priority = 2)
    public  void userLogIn() throws InterruptedException{
        demoblaze.clickLogIn();
        demoblaze.logInWriteUsername("test");
        demoblaze.logInWritePasssword("test");
        demoblaze.logInClickButtonAccept();
        Thread.sleep(5000);
        Assert.assertEquals(demoblaze.getUsername(),"Welcome test");
        Thread.sleep(1000);
    }
    @Test(priority = 3)
    public void addMonitorToCart() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        demoblaze.searchMonitors();
        Thread.sleep(1000);
        demoblaze.clickOnItemNumber(1);
        Thread.sleep(1000);
        demoblaze.addToCart();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Product added.");
        alert.accept();
        Thread.sleep(1000);
    }
    @Test(priority = 4)
    public void addPhoneToCart() throws InterruptedException{
        demoblaze.navigateToDemoblaze();
        demoblaze.searchPhones();
        Thread.sleep(1000);
        demoblaze.clickOnItemNumber(1);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        demoblaze.addToCart();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Product added.");
        alert.accept();
        Thread.sleep(1000);
    }
    @Test(priority = 5)
    public void removeFirstItemFromCarts() throws InterruptedException{
        demoblaze.openCart();
        Thread.sleep(4000);
        int initialPrice= demoblaze.getTotalPrice();
        demoblaze.removeCartItemNumber(1);
        Thread.sleep(6000);
        int priceAfterChange = demoblaze.getTotalPrice();
        Assert.assertEquals(initialPrice, priceAfterChange+360);
        demoblaze.removeCartItemNumber(1);
        Thread.sleep(1000);
    }
    @Test(priority = 6)
    public void sendContactMessage() throws InterruptedException{
        demoblaze.clickOnContact();
        Thread.sleep(5000);
        demoblaze.setContactEmail("test@google.com");
        demoblaze.setContactName("test");
        demoblaze.setContactMessage("This is test");
        Thread.sleep(2000);
        demoblaze.contactSendMessage();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Thanks for the message!!");
        alert.accept();
        Thread.sleep(1000);
    }


    //---------------Test TearDown-----------------------------------
    @AfterTest
    public void teardownTest() {
    //Close browser and end the session
        driver.quit();
    }
}