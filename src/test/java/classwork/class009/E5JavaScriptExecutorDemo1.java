package classwork.class009;

import classwork.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class E5JavaScriptExecutorDemo1 extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {
        String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

        // find the text box
        WebElement usernameTextBox = driver.findElement(By.xpath("//input[@id='txtUsername']"));

        //JsExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //script -> should draw a border around the webElement
        /** colors the whole inside text box */
        js.executeScript("arguments[0].style.backgroundColor='green'", usernameTextBox);

        Thread.sleep(2000);

        /** surrounds the text box with red rectangle*/
          js.executeScript("arguments[0].style.border='2px solid red'", usernameTextBox);

        //using multiple script on same line at once
        //js.executeScript("statements1; statements2; statements3;", arguments);
        //js.executeScript("arguments[0].style.backgroundColor='green'; arguments[0].style.border='2px solid red';", usernameTextBox);


    }
}
