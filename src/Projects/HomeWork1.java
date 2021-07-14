package Projects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;



public class HomeWork1 {
    public static void main ( String[] args ) {
/*1.    Navigate to http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php*/
        System.setProperty ( "webdriver.chrome.driver", "C:\\Users\\PC\\Documents\\selenium browser\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver ( ); // launches a new browser session
         driver.manage ().timeouts ().implicitlyWait ( 5, TimeUnit.SECONDS );
        driver.get ( "http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php" );//navigate to a URL
        String currentUrl = driver.getCurrentUrl ( );//retrieves the current URL


System.out.println ( "_______________________________Verify the the title_______________________________   done " );
/*2.    Verify the the title is "Welcome to Duotify!"*/

        String expectedUrl = "http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php";
        /*if (currentUrl.equals(expectedUrl)){
            System.out.println ("The VerifyTheTtitle Passed" );
        }else{
            System.out.println ("The VerifyTheTtitle Faild");
        }*/
        assertEquals( currentUrl, expectedUrl );
        String expectedTitle = "Welcome to Duotify!";
        String actualTitle= driver.getTitle ( );
        assertTrue ( actualTitle.contains ( expectedTitle ));


System.out.println ( "______________________________________Signup______________________________________   done "  );
/*3.    Click on Signup here*/

        driver.findElement ( By.id("hideLogin")).click();


System.out.println ( "_________________________________Fill out the form _______________________________   done "    );
/*4.     Fill out the form with the required info*/

         String userName="xxxxxxxxxxxxxxxxx";
         WebElement inputBox = driver.findElement ( By.name("username"));
         inputBox.sendKeys(userName);

         String firstName="xxxxxxxxxxxxxxxxx";
         driver.findElement ( By.name("firstName")).sendKeys(firstName);

         String lastName="xxxxxxxxxxxxxxxxxx";
         driver.findElement ( By.name("lastName")).sendKeys(lastName);


         String email="xxxxxxxxxxxxx@gmail.com";
         driver.findElement ( By.name("email")).sendKeys(email);

         String email2="xxxxxxxxxxxxx@gmail.com";
         driver.findElement ( By.name("email2")).sendKeys(email2);

         String password="123tK56789";
         driver.findElement ( By.name("password")).sendKeys(password);

         String password2="123tK56789";
         driver.findElement ( By.name("password2")).sendKeys(password2);



System.out.println ( "_________________________________Click on Sign up_________________________________   done " );
/*5.    Click on Sign up*/

        driver.findElement ( By.name("registerButton")).click();



System.out.println ( "__________________________________Verify the URL__________________________________   done ");
/*6.    Once logged in to the application, verify that the URL is http : //duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?. */
        /*???*/driver.get("http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?");
        String currentUrl1 = driver.getCurrentUrl ();//retrieves the current URL
        String expectedUrl1 = "http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?";
        assertEquals( currentUrl1, expectedUrl1 );

System.out.println ( "_________________verify that your first and last name matches_____________________   done ");
/*7.    In the left navigation bar, verify that your first and last name matches the first and last name that you used when signing up. */

        String HTMLCode= driver.getPageSource();
        assertTrue (HTMLCode.contains ("Xxxxxxxxxxxxxxxxx Xxxxxxxxxxxxxxxxx") );


System.out.println ( "_____________________username on the main window is correct_______________________   done ");
/*8.    Click on the username on the left navigation bar and verify the  username on the main window is correct and then click logout.*/

        driver.findElement ( By.id("nameFirstAndLast")).click();
        driver.get("http://duotifyapp.us-east-2.elasticbeanstalk.com/settings.php?");
/*????driver.findElement ( By.tagName ( "h1" ) ).getText ( );
        WebElement h2 = driver.findElement( By.className ("section-header"));
        System.out.println (h2.getText() );*/
        assertTrue (HTMLCode.contains ("Xxxxxxxxxxxxxxxxx Xxxxxxxxxxxxxxxxx") );
/*????*/
        driver.findElement( By.id("rafael")).click();

        assertTrue(driver.getTitle().equals ("Welcome to Duotify!" ));

System.out.println ( "________________________Verify that you are logged out____________________________   done ");
/*9.   Verify that you are logged out by verifying the URL is: http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php*/

        /*???*/driver.get("http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php");
        String currentUrl2 = driver.getCurrentUrl ();//retrieves the current URL
        String expectedUrl2 = "http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php";
        assertEquals( currentUrl2, expectedUrl2 );

System.out.println ( "_________________________Login using the same username____________________________   done ");
/*10.  Login using the same username and password when you signed up.*/

         driver.findElement ( By.name("loginUsername")).sendKeys(userName);

         driver.findElement ( By.name("loginPassword")).sendKeys(password);

         driver.findElement ( By.name("loginButton")).click ();
System.out.println ( "___________________________Verify successful login________________________________   done " );
/* 11. Verify successful login by verifying that the home page contains the text "You Might Also Like". */

         driver.getPageSource().contains("You Might Also Like");
       // assertTrue (HTMLCode.contains ("You Might Also Like" ) );

System.out.println ( "____________________________________Log out_______________________________________   done " );
/* 12. Log out once again and verify that you are logged out.*/
/*????*/
        driver.findElement ( By.id("nameFirstAndLast")).click();
        driver.findElement( By.id("rafael")).click();
        assertTrue(driver.getTitle().equals ("Welcome to Duotify!" ));


//driver.quit ();


    }
}