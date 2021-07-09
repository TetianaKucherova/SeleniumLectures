package july1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocationMechanism {


    public static void main ( String[] args ) throws InterruptedException {


        System.setProperty ( "webdriver.chrome.driver", "C:\\Users\\PC\\Documents\\selenium browser\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver ( ); // launches a new browser session
        driver.get ( "https://www.duotech.io/" );//navigate to a URL
        String currentUrl = driver.getCurrentUrl ( );//retrieves the current URL
        System.out.println ( "_________________________________________________________" );

        WebElement h2 = driver.findElement( By.className ("section-header"));
        System.out.println (h2.getText() );

        List<WebElement> elements = driver.findElements(By.className("section-header"));
        System.out.println (elements.size() );


        for ( WebElement element: elements) {
            System.out.println (element.getText());
        }
        System.out.println ( "_________________________________________________________" );
       // driver.findElement ( By.id("name") ).sendKeys("Hello");
    }
}