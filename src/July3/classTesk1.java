package July3;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;
public class classTesk1 {
    public static void main ( String[] args ) {


        /*
 * 1 Go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx */
        System.setProperty ( "webdriver.chrome.driver", "C:\\Users\\PC\\Documents\\selenium browser\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver ( ); // launches a new browser session
        driver.get ( "http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx" );//navigate to a URL
        String currentUrl = driver.getCurrentUrl ( );//retrieves the current URL


        /*

 * 2 Login using Tester and test  */
       /*  String Username="Tester";
         driver.findElement ( By.name("ctl00$MainContent$username")).sendKeys(Username);

         String Password="test";
         driver.findElement ( By.name("ctl00$MainContent$password")).sendKeys(Password);
         driver.findElement ( By.name("ctl00$MainContent$login_button")).click ();*/
                                   //or
        driver.findElement (By.id ("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB,"test", Keys.ENTER);
       /*
*  3 Verify the title is Web Orders

       */
        String expectedTitle = "Web Orders";
        String actualTitle= driver.getTitle ( );
        assertTrue ( actualTitle.contains ( expectedTitle ));

        /*
*  4 Verify Welcom, Tester! is on the page

        */
        driver.get ( "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders" );
        String HTMLCode= driver.getPageSource();
        assertTrue (HTMLCode.contains (" Welcome, Tester! " ) );

        /*
*  4a Verify that List of All Orders is on the page.*/



        /*
*  5 Verify that the page contains 6 links.*/
        List<WebElement> links = driver.findElements ( By.tagName ( "a" ) );
        List <String>expectedLinkText = Arrays.asList( "View all orders,View all products,Order,Logout,Check All,Uncheck All" );
        List<String> actualList = new ArrayList<> ();
        for (WebElement link: links) {
            actualList.add ( link.getText ( ) );
        }
        assertEquals (links.size (),6  );

        /*
*  6 Print out each link's text*/

      for ( WebElement link : links ){
        System.out.println ( link.getText ( ) );
    }
        /*
*  7 Log out and verify that you are logged out */
        driver.findElement( By.id("ctl00_logout")).click();
        assertTrue(driver.getTitle().equals ("Web Orders Login" ));


    }
}