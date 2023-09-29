package classwork.class009;

import classwork.utils.CommonMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class E3RightAndDoubleClickActions
        extends CommonMethods {

    public static void main(String[] args) throws InterruptedException {
        String url = "http://demo.guru99.com/test/simple_context_menu.html";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

//      find the element to be right click
        WebElement rightClickBtn = driver.findElement(By.xpath("//span[text()='right click me']"));

//      Actions class  but Action is interface and Action has only one method => void perform();
        Actions actions = new Actions(driver);
    
//     perform the right click action
//     right click is also called context click
       actions.contextClick(rightClickBtn).perform();

//      find the element which is edit option
        WebElement editOpt = driver.findElement(By.xpath("//span[text()='Edit']"));
        actions.click(editOpt).perform();

//        on clicking edit alert appears
//        in order to handle the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

//      to observe
        Thread.sleep(2000);

//      find the webElement to double-click on
        WebElement doubleClick = driver.findElement(By.xpath("//button[contains(text(),'Double-Click')]"));
        actions.doubleClick(doubleClick).perform();
    }

}
