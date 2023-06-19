package classwork.class009;

import classwork.utils.CommonMethods;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class ScreenShots extends CommonMethods {
    public static void main(String[] args) throws IOException {
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
        logInBtn.click();

        //logIn btn
       /* WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginBtn);
*/

        //take the screenshots
        //declare the instance
        TakesScreenshot ts = (TakesScreenshot) driver;

        // take screen-shot as output type FILE
        File screenShot = ts.getScreenshotAs(OutputType.FILE);

        // save it in your computer
        FileUtils.copyFile(screenShot, new File("F:\\selenium\\Files\\screenShot.png"));
    }
}
