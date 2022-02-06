import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class GooglePOM {
    static WebDriver driver;
    public static String testURL = "https://www.google.com/";
    static By AcceptButton = By.id("L2AGLb");
    static By SearchBar = By.name("q");
    By Search = By.name("btnK");

    public GooglePOM(WebDriver driver){
        this.driver=driver;
    }


    public static void navigateToGoogle(){
        driver.navigate().to(testURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement agree = driver.findElement(AcceptButton);
        agree.click();
    }

    public static void GoogleSearch(String text){
        WebElement searchBar = driver.findElement(SearchBar);
        searchBar.sendKeys(text);
        searchBar.submit();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }


}
