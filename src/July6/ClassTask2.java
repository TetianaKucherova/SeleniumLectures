package July6;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ClassTask2 {
    //Go to dice.com
    //Enter SDET for position, and your location for location input box
    // On the results page, verify that the each result header contains the search term


    public static void main ( String[] args ) {


        System.setProperty ( "webdriver.chrome.driver", "C:\\Users\\PC\\Documents\\selenium browser\\chromedriver.exe" );

        WebDriver driver = new ChromeDriver ( ); // launches a new browser session

        driver.manage ( ).timeouts ( ).implicitlyWait ( 20, TimeUnit.SECONDS );


        driver.get ( "https://www.dice.com/" );


        String searchTerm = "SDET";
        String location ="New Jersey";

        String expectedPlaceholder = "Job title, skills or company";

       driver.findElement( By.id("typeaheadInput")).sendKeys(searchTerm + Keys.ENTER);
        driver.findElement( By.id("google-location-search")).sendKeys(location + Keys.ENTER);

       // List<WebElement> resultHeader = driver.findElements ( By.className ( "card-title-link" ) );
        List<WebElement> resultHeader = driver.findElements ( By.xpath ( "//a[@class='card-title-link bold']" ) );
        for ( WebElement link : resultHeader ) {
            System.out.println ( link.getText ());
        }

        System.out.println (resultHeader.size() );
        driver.close ();
    }
}