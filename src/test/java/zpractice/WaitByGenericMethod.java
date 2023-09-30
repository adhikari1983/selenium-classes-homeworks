package zpractice;

import classwork.utils.CommonMethods;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitByGenericMethod extends CommonMethods {

    public static void main(String[] args) throws InterruptedException {
        String url = "https://www.google.com/";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

        WebElement searchBar = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBar.sendKeys("Selenium");
        WebElement serach = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        serach.sendKeys(Keys.RETURN);

        /**WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchingItem = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='Selenium']")));
        searchingItem.click();*/


        By elementLocator = By.xpath("//h3[normalize-space()='Selenium']");
        waitForElementPresent(elementLocator, 10).click();
    }

    public static WebElement waitForElementPresent( By locator, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }
}
