package July3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {
    public static void main ( String[] args ) {

        System.setProperty ( "webdriver.chrome.driver", "C:\\Users\\PC\\Documents\\selenium browser\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver ( ); // launches a new browser session
        driver.manage ().timeouts ().implicitlyWait ( 20, TimeUnit.SECONDS );
        driver.get ( "http://www.duotech.io" );//navigate to a URL
        String currentUrl = driver.getCurrentUrl ( );//retrieves the current URL

        driver.manage ().window().maximize();

        driver.findElement( By.xpath("//a[@href='/about-us']")).click ();
        driver.findElement(By.xpath("//input[@value='Submit Message']")).click ();

    }
}
