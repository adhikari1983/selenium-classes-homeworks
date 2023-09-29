package classwork.class009;

import classwork.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class E1ActionClassDemo1
        extends CommonMethods {

    public static void main(String[] args) {
        String url = "https:amazon.com/";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);
//      find the Web element that you want to hover our cursor to
        WebElement signIn = driver.findElement(By.xpath("//span[text()='Account & Lists']"));

//      Actions class
        Actions action = new Actions(driver);
        action.moveToElement(signIn);


    }

}
