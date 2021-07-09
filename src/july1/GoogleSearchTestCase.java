package july1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GoogleSearchTestCase {
    public static void main ( String[] args ) {
//1) Navigate to google

        System.setProperty ( "webdriver.chrome.driver",
        "C:\\Users\\PC\\Documents\\selenium browser\\chromedriver.exe" );

        WebDriver driver = new ChromeDriver ( );
        // launches a new browser session

        driver.get ( "https://www.google.com" );
        //navigate to a URL
        String searchTerm = "Audi R8";

//2) Find the search field

       WebElement inputBox = driver.findElement ( By.name("q"));
       inputBox.sendKeys(searchTerm);
       //webElement interface represents an HTML element

//3) Enter the search term
//(4) Click search
      // driver.findElement ( By.id ("btnK")).click();

        //or
//(4) Hit enter

        inputBox.sendKeys(searchTerm + Keys.ENTER);

        //<input class="gNO89b" value="Google Search"
        // aria-label="Google Search" name="btnK" type="submit"
        // data-ved="0ahUKEwig1MHtq9LxAhVsdt8KHR2JADoQ4dUDCA0">

        //<input class="gNO89b" value="Google Search"
        // aria-label="Google Search" name="btnK" type="submit"
        // data-ved="0ahUKEwig1MHtq9LxAhVsdt8KHR2JADoQ4dUDCAk">


//5) Verify that the title contains the exact search terms

        String actualTitle = driver.getTitle ();
        Assert.assertTrue(actualTitle.contains(searchTerm));

        driver.quit ();
    }


}
