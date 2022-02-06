import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class demoblaze {
    static WebDriver driver;

    //paths and id for elements that are needed for tests
    public static String testURL = "https://www.demoblaze.com/";
    static By categories = By.id("itemc");
    private WebElement phonesCategory = null;
    private WebElement laptopsCategory = null;
    private WebElement monitorsCategory = null;
    static  By addToCartButton = By.className("btn-success");
    static By signUp = By.id("signin2");
    static By logIn = By.id("login2");
    private WebElement signup = null;
    private WebElement login = null;
    static By signUpUsername = By.id("sign-username");
    static By signUpPassword = By.id("sign-password");
    static By signUpButtonAccept = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");
    static By signUpButtonClose = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[1]");
    static By logInUsername = By.id("loginusername");
    static By logInPassword = By.id("loginpassword");
    static By logInButtonAccept = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
    static By logInButtonClose = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[1]");
    static By username = By.id("nameofuser");
    static By cart = By.id("cartur");
    static By totalPrice = By.id("totalp");
    static By contactEmail = By.id("recipient-email");
    static By contactName = By.id("recipient-name");
    static By contactMessage = By.id("message-text");
    static By contactSendMessage = By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]");
    static By contactButton = By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a");




    public demoblaze(WebDriver driver){
        this.driver=driver;
    }
    public void setWebElements(){
        if(phonesCategory == null || laptopsCategory==null || monitorsCategory==null || signup==null || login == null){
            phonesCategory = driver.findElements(categories).get(0);
            laptopsCategory = driver.findElements(categories).get(1);
            monitorsCategory = driver.findElements(categories).get(2);

        }
    }

    public void navigateToDemoblaze(){
        driver.navigate().to(testURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        signup = driver.findElement(signUp);
        login = driver.findElement(logIn);
    }



    public void searchPhones(){
        phonesCategory = driver.findElements(categories).get(0);
        phonesCategory.click();
    }
    public void searchLaptops(){
        laptopsCategory = driver.findElements(categories).get(1);
        laptopsCategory.click();
    }
    public void searchMonitors(){
        monitorsCategory = driver.findElements(categories).get(2);
        monitorsCategory.click();

    }

    public void clickOnItemNumber(int x){
        WebElement item =driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div["+x+"]/div/a"));
        item.click();
    }
    public void addToCart(){
        WebElement button = driver.findElement(addToCartButton);
        button.click();
    }

    public void clickSignUp(){signup.click();}
    public void clickLogIn(){login.click();}
    public void SignUpwriteUsername(String username){
        driver.findElement(signUpUsername).sendKeys(username);
    }
    public void SignUpwritePassword(String password){
        driver.findElement(signUpPassword).sendKeys(password);
    }
    public void signUpClickButtonAccept(){
        driver.findElement(signUpButtonAccept).click();
    }
    public void signUpClickButtonClose(){
        driver.findElement(signUpButtonClose).click();
    }
    public void logInWriteUsername(String username){
        driver.findElement(logInUsername).sendKeys(username);
    }
    public void logInWritePasssword(String password){
        driver.findElement(logInPassword).sendKeys(password);
    }
    public void logInClickButtonAccept(){
        driver.findElement(logInButtonAccept).click();
    }
    public void logInClickButtonClose(){
        driver.findElement(logInButtonClose).click();
    }
    public String getUsername(){
        String text = driver.findElement(username).getText();
        return text;
    }
    public void openCart(){
        driver.findElement(cart).click();
    }
    public void removeCartItemNumber(int x){
        driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr["+x+"]/td[4]/a")).click();
    }
    public int getTotalPrice(){
        return Integer.parseInt(driver.findElement(totalPrice).getText());
    }
    public void clickOnContact(){
        driver.findElement(contactButton).click();
    }
    public void setContactName(String name){
        driver.findElement(contactName).sendKeys(name);
    }
    public void setContactEmail(String email){
        driver.findElement(contactEmail).sendKeys(email);
    }
    public void setContactMessage(String message){
        driver.findElement(contactMessage).sendKeys(message);
    }
    public void contactSendMessage(){
        driver.findElement(contactSendMessage).click();
    }

}
