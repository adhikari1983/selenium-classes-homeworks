package classwork.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingElements {
    public static void main(String[] args) throws InterruptedException {
        //instance
        WebDriver driver = new ChromeDriver();

        //facebook.com
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();

        //send some text to the text field
        // find the TAGNAME & ATTRIBUTE
        //<-find the webElement by id->     . <- send some text->
        driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
        Thread.sleep(1000);

        //send some text to the password field
        //<-find the element by name ->   . <- send some text->
        driver.findElement(By.name("pass")).sendKeys("1234");
        Thread.sleep(3000);

        //print url on console
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //print the title on the console
        String title = driver.getTitle();
        System.out.println("title = " + title);

        if (title.equalsIgnoreCase("Facebook - log in or sign up")) {
            System.out.println("Title is correct");
        } else {
            System.out.println("Title is not correct");
        }

        //close the window
        driver.close();
        //driver.quit();
    }
}
