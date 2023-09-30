package classwork.timestampscrnsht;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class MethodsWithTimeStamp {
    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication(String URL, String browser) {

        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;
        }
//       maximize the window
        driver.manage().window().maximize();
        //navigate to the url
        driver.get(URL);
//        implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void sendText(String text, WebElement element) {
        element.clear();
        element.sendKeys(text);
    }

    public static String takeScreenshot() {
        String timeStamp = new SimpleDateFormat("hhMMss_yyyyMMdd").format(new Date());
        String fileName = "screenshot_" + timeStamp;

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenShot = screenshot.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "\\Files\\Screenshots\\" + fileName + ".png";
        try {
            FileUtils.copyFile(screenShot, new File(path));
            System.out.println("Screenshot saved : " + path);
        } catch (IOException e) {
            return "FAILED to save Screenshot";
        }
        return timeStamp;
    }
}
