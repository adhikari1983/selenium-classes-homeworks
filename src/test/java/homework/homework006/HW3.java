/*
HW3:
develop a function in common methods to select from dropdown(single select)
 */
package homework.homework006;
import homework.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HW3 extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {
        String url = " http://facebook.com";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

        //click create account btn
        WebElement createAccountBtn = driver.findElement(By.xpath("//a[text()='Create new account']"));
        createAccountBtn.click();

        //find the months associate with the dropdown
        WebElement months = driver.findElement(By.xpath("//Select[@name='birthday_month']"));
        //implement a function from commonMethods to select from dropdown byIndex
        selectOptionByIndex(months, 6);

        //find the days associate with the dropdown
        WebElement days = driver.findElement(By.xpath("//select[@id='day']"));
        //implement a function from commonMethods to select from dropdown byVisibleText
        selectOptionByVisibleText(days, "29");

        //find the years associate with the dropdown
        WebElement years = driver.findElement(By.xpath("//Select[@name='birthday_year']"));
        //implement a function from commonMethods to select from dropdown byValue
        selectOptionByValue(years, "1988");

        //close the browser
        closeBrowser();

    }
}

