package classwork.class009;

import classwork.utils.CommonMethods;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;


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
        // 1.TakesScreenshot comes from => org.openqa.selenium..........................
        TakesScreenshot ts = (TakesScreenshot) driver;

        // take screen-shot as output type FILE                        // 1. & 2. comes from two library
        // screenShotInTheFromOfFile for e.g .png, .jpeg etc...
        File screenShotAsSourceFile = ts.getScreenshotAs(OutputType.FILE);

        // save it in your computer
        //2. FileUtils comes from => org.apache.commons.io.............................
        // FileUtils.copyFile(sourceFile, DestinationFile);
        FileUtils.copyFile(screenShotAsSourceFile, new File("F:\\selenium\\Files\\screenShot.png"));

    }
}
