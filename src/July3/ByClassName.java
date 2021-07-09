package July3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByClassName {
    public static void main ( String[] args ) {

        System.setProperty ( "webdriver.chrome.driver", "C:\\Users\\PC\\Documents\\selenium browser\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver ( ); // launches a new browser session
        driver.get ( "http://www.duotech.io/" );//navigate to a URL

        driver.manage().window().maximize();//maximizes the window

        driver.findElement(By.className("scroll-down-link")).click();//className can only accept one class attribute value
        //it will not work for multiple classes.
        String currentUrl = driver.getCurrentUrl ( );//retrieves the current URL


System.out.println ( "_______________________________________________________________________________________") ;

}
}