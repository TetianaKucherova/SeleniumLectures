package july1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {




    public static void main ( String[] args ) throws InterruptedException {


        System.setProperty ( "webdriver.chrome.driver", "C:\\Users\\PC\\Documents\\selenium browser\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver ( ); // launches a new browser session
        driver.get ( "https://www.duotech.io/" );//navigate to a URL
        String currentUrl = driver.getCurrentUrl ( );//retrieves the current URL
        System.out.println ( "_________________________________________________________" );
        String expectedUrl = "https://www.duotech.io/";

        driver.navigate().to ( "https://www.amazon.com/" );
        driver.navigate().back();
        driver.navigate().forward ();
        driver.navigate ().refresh ();


    }
}
