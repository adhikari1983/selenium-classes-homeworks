/*
HW2:
Go to “http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login%E2%80%9D
Enter valid username
Leave password field empty
Click on login button
Verify error message with text “Password cannot be empty” is displayed.
 */
package homework.homework003;

import classwork.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HW2VerifyErrorMessage extends CommonMethods {

    public static void main(String[] args) {
        String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login%E2%80%9D";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

        WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("kiran123");

        WebElement logInBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        logInBtn.click();

        WebElement errorMessage = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String errorMessageText = errorMessage.getText();

        if (errorMessageText.equalsIgnoreCase("Password cannot be empty")) {
            System.out.println("Right error message is displayed");
        } else {
            System.out.println("Error message is not displayed");
        }

        closeBrowser();

    }
}
