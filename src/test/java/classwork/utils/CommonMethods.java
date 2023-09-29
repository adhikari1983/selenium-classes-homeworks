package classwork.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CommonMethods {

    public static WebDriver driver;

    /**
     * WHY, static variable & static methods ?
     * So, then we can use it anywhere in this class -> only inside the class
     * e.g. we are accessing "driver" everywhere associated with static modifier
     */
    public static void openBrowserAndLaunchApplication(String URL, String browser) {
        // pass the browser value either as chrome or firefox from argument
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;
        }

//      navigate to the url
        driver.get(URL);

//       maximize the window
        driver.manage().window().maximize();
//      implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    //      close the browser
    // i was confused with close VS quit in the beginning point to notice
    public static void closeBrowser() {
     // if there isn't any browser window open and trying to close it out , then there will be an exception
     // so this if condition will by pass, if there is no window opened
        if (driver != null) {
            driver.quit();
        }
    }

    public static void sendText(String text, WebElement element) {
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

    public static void takeScreenshot(String fileName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        // take screen-shot as output type FILE                        // 1. & 2. comes from two library
        // screenShotInTheFromOfFile for e.g .png, .jpeg etc...
        File screenShotAsSourceFile = ts.getScreenshotAs(OutputType.FILE);
        // save it in your computer
        //2. FileUtils comes from => org.apache.commons.io.............................
        // FileUtils.copyFile(sourceFile, DestinationFile);
        FileUtils.copyFile(screenShotAsSourceFile, new File(System.getProperty("user.dir") +
                                            "\\Files\\Screenshots\\" + fileName + ".png"));
    }
}