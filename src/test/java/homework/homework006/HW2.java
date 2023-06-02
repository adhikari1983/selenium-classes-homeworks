/*
goto http://practice.syntaxtechs.net/dynamic-data-loading-demo.php
click on get new user
print the firstname of user
 */
package homework.homework006;

import classwork.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class HW2 extends CommonMethods {
    public static void main(String[] args) {
        String url = "http://practice.syntaxtechs.net/dynamic-data-loading-demo.php";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

        //declare the implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // click the Get New User
        WebElement getUserBtn = driver.findElement(By.xpath("(//button[text()='Get New User'])"));
        getUserBtn.click();

        //find firstName and retrieve the first name
        WebElement firstName = driver.findElement(By.xpath("//p[contains(text(),'First Name')]"));
        String text = firstName.getText();
        System.out.println(text);

        //close the browser
        closeBrowser();
    }

}
