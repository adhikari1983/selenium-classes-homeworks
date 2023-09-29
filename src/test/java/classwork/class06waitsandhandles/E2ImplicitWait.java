package classwork.class06waitsandhandles;

import classwork.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class E2ImplicitWait extends CommonMethods {
    public static void main(String[] args) {
        String url = "http://facebook.com";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

//       declaring the implicit wait in the start as it is a global wait,
//       and we want it to be implemented on all the webElements that takes time to appear on the DOM
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//       clicks the creates new accounts
        WebElement createNewAccountBtn = driver.findElement(By.xpath("//a[text()='Create new account']"));
        createNewAccountBtn.click();


//      fills up all the textBoxes
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
       sendText("Kiran", firstName);

    }
}
