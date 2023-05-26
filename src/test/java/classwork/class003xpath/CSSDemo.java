package classwork.class003xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSDemo {
    public static void main(String[] args) throws InterruptedException {
//creating the instance
        WebDriver driver = new ChromeDriver();

// loading the fb.com
        driver.get("https://www.facebook.com/");

// click on create new account
        WebElement createAccount = driver.findElement(By.cssSelector("a[data-testid ='open-registration-form-button']"));
        createAccount.click();
// Because the DOM doesn't have firstName by default, it only shows up after clicking on create new account
// and the code takes some time to appear/load in DOM structure for the firstName textBox
// So, we must add a sleep here
        Thread.sleep(2000);

// enter the first name
        WebElement fname = driver.findElement(By.cssSelector("input[name='firstname']"));
        fname.sendKeys("Kiran");
    }
}
