package classwork.class02locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        //declare the instance
        WebDriver driver = new ChromeDriver();

        //navigate to the HRMS
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/dashboard");

        //maximize the screen
        driver.manage().window().fullscreen();

        //they both are same  L21 = L24 + L25
        //driver.findElement(By.id("txtUsername")).sendKeys("Admin");

        //find the element username TextBox
        WebElement userName = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin"); //storing the webElement to re-use it , that's all

        //[just to observe] -> slow down the execution
        Thread.sleep(2000);
        //after sending the username to the textBox, clear the text box -> deleting it, just for practice
        userName.clear();                     // see, we just re-use it . L25 => implemented

        //sending the username again
        userName.sendKeys("Admin");
        System.out.println("checking one of the Username textInput attribute's text \n" +
                            userName.getAttribute("type"));;

        //sending the password
        WebElement password = driver.findElement(By.name("txtPassword"));
        password.sendKeys("Hum@nhrm123");

        //find the login button
        WebElement loginBtn = driver.findElement(By.className("button"));
        loginBtn.click();

        //get welcome message
        WebElement message = driver.findElement(By.linkText("Welcome Admin"));
        //reason getting back the text:
        // Req: -> Login in the application & verify that you see the text message "Welcome Admin"
        String text = message.getText();
        System.out.println("get welcome message text = " + text);

        driver.findElement(By.partialLinkText("Recru")).click();

        List<WebElement> aTags = driver.findElements(By.tagName("a"));

        for (WebElement aTag : aTags) {
            String webLink = aTag.getAttribute("href");
            System.out.println(webLink);
        }

    }
}
