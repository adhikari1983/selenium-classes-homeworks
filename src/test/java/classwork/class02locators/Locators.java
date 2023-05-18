package classwork.class02locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//"http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/dashboard"
public class Locators {
    public static void main(String[] args) throws InterruptedException {
        //declare tge instance
        WebDriver driver = new ChromeDriver();

        //navigate to the HRMS
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/dashboard");

        //maximize the screen
        driver.manage().window().fullscreen();

        //they both are same  L21 = L24 + L25
        //driver.findElement(By.id("txtUsername")).sendKeys("Admin");

        //find the element username TextBox
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin"); //storing the webElement to re-use it , that's all

        //[just to observe] -> slow down the execution
        Thread.sleep(2000);
        //after sending the username to the textBox, clear the text box -> deleting it, just for practice
        username.clear();                     // see, we just re-use it . L25 => implemented

        //sending the username again
        username.sendKeys("Admin");

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

    }
}
