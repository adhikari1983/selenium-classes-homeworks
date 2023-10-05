package classwork.class01intro;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchingBrowser {
    public static void main(String[] args) throws InterruptedException {
 /**
  * task:
  * navigate to google.com        *********** FRONT END TESTING IS TESTING THE USER INTERFACE ***********
  */
 /** Regression testing -> testing the whole application again after updating/adding a new feature to the application
  Basically that means testing the application continuously coz -> updating/adding a new feature to the application
                                                                   happens all the time.
  */
        // declare the instance
        WebDriver driver = new ChromeDriver();

        //use get(url) to navigate the desired url
        driver.get("https://www.google.com");


        //can you manipulate the cookies with the help of selenium webDriver ?
        Cookie cookie = new Cookie("cookieName", "cookieValue");
        driver.manage().addCookie(cookie);
        driver.manage().deleteCookieNamed("cookieName");


        //maximize the window
        driver.manage().window().maximize();

        // gets  the current url & prints on the console
        String currentUrl = driver.getCurrentUrl();
        System.out.println("The current url of the website is : " + currentUrl);

        //gets the title of the page & prints on the console
        String title = driver.getTitle();
        System.out.println("The title of the page that landed on, is " + title);

        //slowing down the program -> execution => wait here for 5sec before u execute the next line of the code
        Thread.sleep(3000);
        //close the web-browser
        driver.quit();


    }
}
