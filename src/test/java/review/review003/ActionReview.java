package review.review003;

import classwork.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ActionReview extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {
        String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

        //username through textBox
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("Admin");

        //password through textBox
        WebElement userPassword = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        userPassword.sendKeys("Hum@nhrm123");

        //logIn btn
        WebElement logInBtn = driver.findElement(By.xpath("//input[contains(@id, 'btn')]"));

Thread.sleep(2000);
//        declare the isntance
        Actions action =new Actions(driver);
        action.click(logInBtn).perform();
        WebElement leaveTab = driver.findElement(By.id("menu_leave_viewLeaveModule"));
        action.moveToElement(leaveTab);

    }
}
