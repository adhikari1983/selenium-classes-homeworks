package review.review003;

import classwork.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class KeyReview extends CommonMethods {



    public static void main(String[] args) throws InterruptedException, IOException {
        String url = "https://the-internet.herokuapp.com/key_presses";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

        WebElement element = driver.findElement(By.id("target"));
        String text = "Hello, World!";
        int count = 5;

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value', arguments[1]); arguments[2]++;",
                element, text, count);

        Thread.sleep(5000);
        WebElement textBox = driver.findElement(By.id("target"));
        textBox.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        textBox = driver.findElement(By.id("target"));
        textBox.sendKeys(Keys.TAB);


        Thread.sleep(2000);
        textBox = driver.findElement(By.id("target"));
        textBox.sendKeys(Keys.ARROW_DOWN);

        /*TakesScreenshot ts =(TakesScreenshot) driver;
        File ss = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ss,new File("F:\\selenium\\Files\\screenShot111.png"));*/

        takeScreenshot("MYSS");
    }

}
