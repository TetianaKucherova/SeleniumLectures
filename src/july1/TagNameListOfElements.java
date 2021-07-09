package july1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TagNameListOfElements {
    public static void main ( String[] args ) {
        System.setProperty ( "webdriver.chrome.driver", "C:\\Users\\PC\\Documents\\selenium browser\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver ( ); // launches a new browser session
        driver.get ( "https://www.duotech.io/" );//navigate to a URL
        String currentUrl = driver.getCurrentUrl ( );//retrieves the current URL
        System.out.println ( "_________________________________________________________" );
        System.out.println ( driver.findElement ( By.tagName ( "h1" ) ).getText ( ) );

        List<WebElement> links = driver.findElements ( By.tagName ( "a" ) );
        for ( WebElement link : links ) {
            System.out.println ( link.getText ());
        }
        System.out.println ( "_________________________________________________________" );
        System.out.println ( "_________________________________________________________" );
        List <WebElement> elems = driver.findElements ( By.tagName("w") );
        //System.out.println (elems.size());
        //findElement() -> throws exception if an element id not found
        //findElements() -> if no matching elements are not found, returns an empty list.
    }
}
