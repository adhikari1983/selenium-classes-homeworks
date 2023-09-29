package classwork.class06waitsandhandles;

import classwork.utils.CommonMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class E3ExplicitWait extends CommonMethods {
    public static void main(String[] args) {
        String url = "https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

                       /** for 4th button */
//       click on 4thbtn -> "Enable button after 10seconds"
//            and then click on the button( -> btn ond side that appears after 10sec)
//        assumption we don't know that what is the time for it to get enabled

//      click on the enable button
        WebElement btn4 = driver.findElement(By.xpath("//button[@id='enable-button']"));
        btn4.click();

//     declare the wait -> for explicit wait -> waits until it finds the element with the condition
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

//      wait for the condition : element is clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Button']")));

//        click on the button
        WebElement btn4SideBtn = driver.findElement(By.xpath("//button[text()='Button']"));
        btn4SideBtn.click();

                            /** for alert button */
//        click on the alert button
        WebElement alertBtn = driver.findElement(By.xpath("//button[@id='alert']"));
        alertBtn.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }
}
