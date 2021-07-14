package Projects;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;


public class HomeWork2 {
                                         /*CREATE A WEB ORDER*/


    public static void main ( String[] args ) {
        /*1.    Launch Chrome browser.*/
        System.setProperty ( "webdriver.chrome.driver", "C:\\Users\\PC\\Documents\\selenium browser\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver ( ); // launches a new browser session

        /*2.    Navigate to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx*/
        driver.manage ( ).timeouts ( ).implicitlyWait ( 20, TimeUnit.SECONDS );
        driver.get ( "http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx" );


        /*3.    Login using username Tester and password test*/
        driver.findElement ( By.id ( "ctl00_MainContent_username" ) ).sendKeys ( "Tester",
                Keys.TAB, "test", Keys.ENTER );


        /*4.    Click on Order link*/
        driver.findElement ( By.xpath ( "//a[@href='Process.aspx']" ) ).click ( );


        /*5.    Enter a random product quantity between 1 and 100*/
        int rQuantity = ( (int) ( Math.random ( ) * 100 ) );
        driver.findElement ( By.name ( "ctl00$MainContent$fmwOrder$txtQuantity" ) ).sendKeys ( String.valueOf
                ( rQuantity ), Keys.ENTER );

        /*6.    Click on Calculate and verify that the Total value is correct.*/
        driver.findElement ( By.className ( "btn_dark" ) ).click ( );


           /* Price per unit is 100.  The discount of 8 % is applied to quantities of 10+.
            So for example, if the quantity is 8, the Total should be 800.
            If the quantity is 20, the Total should be 1840.
            If the quantity is 77, the Total should be 7084. And so on.*/

        long total;
         if( rQuantity>=10){
        total= (long)(rQuantity*100)-(long)(rQuantity*100*0.08);
        System.out.println (total );
         }else{
        total= (rQuantity*100);
        System.out.println (total );}


        String actualTotal= driver.findElement (By.name ( "ctl00$MainContent$fmwOrder$txtTotal" ) )
                 .getAttribute ( "value" );
        String expectedTotal = String.valueOf (total);
        assertEquals ( actualTotal,expectedTotal );


        /*6.    Generate and enter random first name and last name.*/
        Faker fakeData = new Faker ( );
        String name = String.valueOf ( fakeData.name ( ).lastName ( ) );
        String lastName = String.valueOf ( fakeData.address ( ).lastName ( ) );


        /*7.    Generate and Enter random street address*/
        String street = String.valueOf ( fakeData.address ( ).streetAddress ( ) );


        /*8.    Generate and Enter random city*/
        String city = String.valueOf ( fakeData.address ( ).city ( ) );


        /*9.    Generate and Enter random state*/
        String state = String.valueOf ( fakeData.address ( ).state ( ) );


        /*10.   Generate and Enter a random 5 digit zip code*/
        String zip = String.valueOf (10000+ (long) ( Math.random ( ) * 99999l ) );


        driver.findElement ( By.id ( "ctl00_MainContent_fmwOrder_txtName" ) ).sendKeys
                     ( name," ", lastName,

                     Keys.TAB, street,

                     Keys.TAB, city,

                     Keys.TAB, state,

                     Keys.TAB, zip,

                     Keys.ENTER );


 /*EXTRA: As an extra challenge, for steps 6-10 download 1000 row of corresponding realistic data from
 mockaroo.com in a csv format and load it to your program and use the random set of data from there each time.*/


        /*11.   Select the card type randomly. On each run your script should select a random type.*/
        driver.findElement ( By.id ( "ctl00_MainContent_fmwOrder_cardList_0" ) ).click ( );

        List<WebElement> elements = driver.findElements ( By.id ( "ctl00_MainContent_fmwOrder_cardList_0" ) );

        for ( WebElement element : elements ) { element.click ( ); }

        /*12.   Generate and enter the random card number:
                If Visa is selected, the card number should start with 4.
                If MasterCard is selected, card number should start with 5.
                If American Express is selected, card number should start with 3.
                Card numbers should be 16 digits for Visa and MasterCard, 15 for American Express.*/
        long creditCardNumber = (10000000000000000l+ (long) ( Math.random ( ) * 9999999999999999l ) );
        driver.findElement ( By.name ( "ctl00$MainContent$fmwOrder$TextBox6" ) ).sendKeys ( String.valueOf
                ( creditCardNumber ), Keys.ENTER );


        /*13.   Enter a valid expiration date (newer than the current date)*/

    //


           String ExpirationData=  String.valueOf ( "0" +(int) ( Math.random ( ) * 9) )+"/"+(21+ (int) ( Math.random ( ) * 99 ) );

        driver.findElement ( By.id ( "ctl00_MainContent_fmwOrder_TextBox1" ) ).sendKeys ( ExpirationData,
               Keys.ENTER );

         /*14.   Click on Process*/
        driver.findElement ( By.id ( "ctl00_MainContent_fmwOrder_InsertButton" ) ).click ( );

         /*15.   Verify that “New order has been successfully added” message appeared on the page.*/

         String expectedText ="                    New order has been successfully added. ";
         String message = driver.findElement(By.xpath("//*[normalize-space()='New order has been successfully added.']")).getText();
         Assert.assertEquals("                    New order has been successfully added. ", expectedText);

         /*16.   Click on View All Orders link.*/

         driver.findElement ( By.xpath ( "//a" ) ).click ( );

         /*17.   The placed order details appears on the first row of the orders table. Verify that the entire information
                contained on the row (Name, Product, Quantity, etc) matches the previously entered information in previous
                steps.*/
        System.out.println(driver.findElement(By.tagName("h2")).getText());

        List<WebElement> trs = driver.findElements(By.tagName("tr"));
        System.out.println(trs.get(2).getText());
        System.out.println(trs.get(3).getText());
        System.out.println(trs.get(5).getText());
        System.out.println(trs.get(6).getText());
        System.out.println(trs.get(7).getText());
        System.out.println(trs.get(8).getText());

        List<WebElement> tds = driver.findElements(By.tagName("td"));
        System.out.println('\n' +"Last order was made by: "+tds.get(3).getText());
        String actualdCastomer =tds.get(3).getText ();
        String expectedCustomer= name+" "+lastName;
        Assert.assertEquals(actualdCastomer, expectedCustomer);
         /*18.   Log out of the application.Push your code to GitHub, and share the repo link in the given repo.txt file*/
        driver.findElement ( By.id( "ctl00_logout" ) ).click ( );

            }
        }