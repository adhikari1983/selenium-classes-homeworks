package homework.homework004;

import homework.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HW2Facebook extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {
        String url = " http://facebook.com";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

        driver.findElement(By.xpath("//a[text()='Create new account']")).click();
        Thread.sleep(2000);


        WebElement months = driver.findElement(By.xpath("//Select[@name='birthday_month']"));
        Select month = new Select(months);
        month.selectByIndex(6);

        Thread.sleep(2000);
        WebElement days = driver.findElement(By.xpath("//select[@id='day']"));
        Select selectDay = new Select(days);
        selectDay.selectByVisibleText("29");

        Thread.sleep(2000);
        WebElement years = driver.findElement(By.xpath("//Select[@name='birthday_year']"));
        Select year = new Select(years);
        year.selectByValue("1988");


        Thread.sleep(2000);
        closeBrowser();

    }
}
