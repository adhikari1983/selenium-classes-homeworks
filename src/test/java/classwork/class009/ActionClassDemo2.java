package classwork.class009;

import classwork.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionClassDemo2 extends CommonMethods {

    public static void main(String[] args) {
        String url = "https://jqueryui.com/droppable/";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

//      As the element inside an iframe , so first we need ti switch focus
        driver.switchTo().frame(0);

//      find the draggable Web element
        WebElement draggable = driver.findElement(By.id("draggable"));
//      find the droppable Web element
        WebElement droppable = driver.findElement(By.id("droppable"));

//      Action class
        Actions action = new Actions(driver);

//      drag and drop action
        action.dragAndDrop(draggable, droppable).perform();


        /** In Action class scroll works by methods,  but in     JavascriptExecutor works by script */
        // e.g. action.scrollToElement(draggable);
    }

}
