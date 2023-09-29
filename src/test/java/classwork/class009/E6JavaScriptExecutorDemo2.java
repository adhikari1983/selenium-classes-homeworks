package classwork.class009;

import classwork.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.security.Key;

public class E6JavaScriptExecutorDemo2 extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {
        String url = "http://amazon.com";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);
/** JavaScript click is mostly used option over regular selenium click */

//       perform a scroll operation

//       using java script
        JavascriptExecutor js = (JavascriptExecutor) driver;

//      scroll down
        js.executeScript("window.scrollBy(0, 500)");

//      to observe
        Thread.sleep(2000);
        /** JavascriptExecutor works by script, but in Action class scroll works by methods  */
//      scroll up
        js.executeScript("window.scrollBy(0, -500)");

//      click on the dropdown "ALL"
//      use the from jsExecutor

        Thread.sleep(2000);

        /** sometime this click(); might not work on website like amazon -> due to live production environment */
        WebElement allDropdown=driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
        js.executeScript("arguments[0].click();",allDropdown);

//      click on the hamburger  "ALL" button
        WebElement allHamBurgerBtn = driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']"));
        js.executeScript("arguments[0].click();", allHamBurgerBtn);




    }
}
