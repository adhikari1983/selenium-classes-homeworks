package zpractice1.class02;

import classwork.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class E2 extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {

        // driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        // String url = "http://practice.syntaxtechs.net/javascript-alert-box-demo.php";
        String url = "http://accounts.google.com/signup";
        //String url = "https://www.facebook.com/";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);
        driver.manage().window().maximize();
       // click on the help button privacy button
        WebElement helpBtn = driver.findElement(By.linkText("Help"));
        helpBtn.click();

        WebElement privacyBtn = driver.findElement(By.xpath("//a[text()='Privacy']"));
        privacyBtn.click();

        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("mainWindow = " + mainWindowHandle);

        //String mainWindowTitle = driver.switchTo().window(mainWindowHandle).getTitle();
        //System.out.println("window = " + mainWindowTitle);

        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle: windowHandles) {
          driver.switchTo().window(handle);
            String title = driver.getTitle();
            System.out.println("this " + handle + " title " + " is " + title);
        }
        System.out.println("Current fcous of the driver " + driver.getTitle());
    }
}
