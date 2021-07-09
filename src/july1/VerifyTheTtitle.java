package july1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.Assert;
import java.lang.Thread;
public class VerifyTheTtitle {
    public static void main ( String[] args ) throws InterruptedException {


  System.setProperty ( "webdriver.chrome.driver", "C:\\Users\\PC\\Documents\\selenium browser\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver (); // launches a new browser session
        driver.get ( "https://www.duotech.io/" );//navigate to a URL
       String currentUrl = driver.getCurrentUrl ();//retrieves the current URL
        System.out.println ("_________________________________________________________" );
        String expectedUrl = "https://www.duotech.io/";
        /*if (currentUrl.equals(expectedUrl)){
            System.out.println ("The VerifyTheTtitle Passed" );
        }else{
            System.out.println ("The VerifyTheTtitle Faild");
        }*/
        Assert.assertEquals( currentUrl, expectedUrl );

      String expectedTitle = "Duotech Academy";
      String actualTitle= driver.getTitle ( );
      assertTrue ( actualTitle.contains ( expectedTitle ));
       // System.out.println ( driver.getPageSource ());
        String HTMLCode= driver.getPageSource();
        System.out.println ("_________________________________________________________" );
      assertTrue (HTMLCode.contains ("Start New IT&nbsp;Career") );
      //driver.quit ();// Quit this driver, closing every associated window.
      //  driver.close(); // Closes the current window, quitting the browser if it's the last window currently open.
driver.get("https://www.toyota.com/");
driver.findElement ( By.xpath("https://www.toyota.com/owners") );
Thread.sleep(5000);
//driver.quit();
 // driver.close();
    }
}