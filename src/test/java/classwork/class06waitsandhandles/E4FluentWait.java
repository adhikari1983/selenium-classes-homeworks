package classwork.class06waitsandhandles;

import classwork.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;

public class E4FluentWait extends CommonMethods {
    public static void main(String[] args) {
        String url = "https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

        // Create a FluentWait instance with a 30-second timeout and polling every 2 seconds
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);

        // Example: Wait for an element with a specific ID
        fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.id("some-element-id")));

        // Now you can interact with the 'element'

        // Close the browser
        driver.quit();
    }
}
