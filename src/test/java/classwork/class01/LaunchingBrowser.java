package classwork.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchingBrowser {
    public static void main(String[] args) throws InterruptedException {
 /**
  * task:
  * navigate to google.com
  */
       // declare the instance
        WebDriver driver = new ChromeDriver();

        //use get(url) to navigate the desired url
        driver.get("https://www.google.com");

        //maximize the window
        driver.manage().window().maximize();

        // gets  the current url & print on the console
        String currentUrl = driver.getCurrentUrl();
        System.out.println("The current url of the website is : " + currentUrl);

        //gets the title of the page & print on the console
        String title = driver.getTitle();
        System.out.println("The title of the page that landed on, is " + title);

        //slowing down the program -> execution
        Thread.sleep(3000);
        //close the web-browser
        driver.quit();


    }
}
