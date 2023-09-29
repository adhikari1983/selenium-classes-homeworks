package classwork.class02locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocatorTagName {

    public static void main(String[] args) {
        //navigate to the amazon.com
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        //maximize the screen
        driver.manage().window().fullscreen();

//        //get all the links from amazon.com and print them on the console
//        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
//
//        //traverse
//        for(WebElement link: allLinks){
//          String linkOfWebsite = link.getAttribute("href");p
//            System.out.println( linkOfWebsite);
//        }

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int count = 0;
        for (WebElement link : allLinks) {
            String linkOfWebsite = link.getAttribute("href");
            count++;
            System.out.println(linkOfWebsite);
        }
        System.out.println("Total website links count is  " + count);
    }
}
