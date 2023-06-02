/*
HW1:
Open chrome browser
Go to “http://practice.syntaxtechs.net/input-form-demo.php%E2%80%9D
fill in the complete form
 */
package homework.homework003;

import classwork.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HW1FormFillUp extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {
        String url = "http://practice.syntaxtechs.net/input-form-demo.php";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

        WebElement firstName = driver.findElement(By.cssSelector("input[name='first_name']"));
        firstName.sendKeys("Kiran");

        WebElement lastName = driver.findElement(By.xpath("//input[@name='last_name']"));
        lastName.sendKeys("Adhikari");

        WebElement email = driver.findElement(By.cssSelector("input[placeholder='E-Mail Address']"));
        email.sendKeys("abc@gmail.com");

        WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys("(703)444-1313");

        WebElement address = driver.findElement(By.cssSelector("input[name='address']"));
        address.sendKeys("123 Right St");

        WebElement city = driver.findElement(By.xpath("//input[@placeholder='city']"));
        city.sendKeys("Springfield");

        WebElement state = driver.findElement(By.cssSelector("select[name='state']"));
        Select selectState = new Select(state);
        selectState.selectByVisibleText("Virginia");

        WebElement zip = driver.findElement(By.xpath("//input[@name='zip']"));
        zip.sendKeys("22151");

        WebElement websiteDomain = driver.findElement(By.cssSelector("input[placeholder='Website or domain name']"));
        websiteDomain.sendKeys("practiceAllDay.com");

        WebElement radioBtn = driver.findElement(By.xpath("//input[@value='yes']"));
        radioBtn.click();

        WebElement projectDescription = driver.findElement(By.cssSelector("textarea[name='comment']"));
        projectDescription.sendKeys("Selenium homework");

        WebElement sendBtn = driver.findElement(By.xpath("//button[@onclick='resetForm();']"));
        sendBtn.click();

        closeBrowser();
    }
}
