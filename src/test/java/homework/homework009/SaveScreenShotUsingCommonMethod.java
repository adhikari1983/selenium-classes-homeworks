/*
    HW:
    create a method in Common methods for screen-shot
    it should take file name as a parameter.
 */
package homework.homework009;

import homework.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class SaveScreenShotUsingCommonMethod extends CommonMethods {

    public static void main(String[] args) {
        String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

        // click login btn with
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginBtn);

        //take screen shot and save it using commonMethods method
        try {
            takeScreenShotAndSaveIt("F:\\selenium\\Files\\screenShot3.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
