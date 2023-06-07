package homework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class CommonMethods {

    public static WebDriver driver;

    /**
     * WHY, static variable & static methods ?
     * So, then we can use it anywhere in this class -> only inside the class
     * e.g. we are accessing "driver" everywhere associated with static modifier
     */
    public static void openBrowserAndLaunchApplication(String URL, String browser) {

        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;
        }

        // maximize the window
        driver.manage().window().maximize();

        //navigate to the url
        driver.get(URL);

//      implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    //close the browser
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    // sendKeys
    public static void sentText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    //option selectByVisibleText
    public static void selectOptionByVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    //option selectByValue
    public static void selectOptionByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    //option selectByIndex
    public static void selectOptionByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }
}