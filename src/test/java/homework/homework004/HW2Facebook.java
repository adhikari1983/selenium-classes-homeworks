/*
hw2:
goto facebook.com
 click on create account
and select the your  date of birth using select class
 */
package homework.homework004;

import homework.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HW2Facebook extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {
        String url = " http://facebook.com";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

        driver.findElement(By.xpath("//a[text()='Create new account']")).click();


        WebElement months = driver.findElement(By.xpath("//Select[@name='birthday_month']"));
        selectOptionByIndex(months, 6);

        WebElement days = driver.findElement(By.xpath("//select[@id='day']"));
        selectOptionByVisibleText(days, "29");

        WebElement years = driver.findElement(By.xpath("//Select[@name='birthday_year']"));
        selectOptionByValue(years, "1988");

        Thread.sleep(2000);
        closeBrowser();

    }
}
