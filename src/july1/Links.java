package july1;
//import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Links {

    public static void main ( String[] args ) {


        System.setProperty ( "webdriver.chrome.driver", "C:\\Users\\PC\\Documents\\selenium browser\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver ( ); // launches a new browser session
        driver.get ( "https://www.duotech.io/" );//navigate to a URL
        String currentUrl = driver.getCurrentUrl ( );//retrieves the current URL
        System.out.println ( "_________________________________________________________" );
        driver.findElement( By.linkText("About")).click();
        driver.findElement(By.partialLinkText("Con")).click ();
    }
}
