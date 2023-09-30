package review.review003;

import classwork.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class Calender extends CommonMethods {
    public static void main(String[] args) throws IOException {
        String url = "https://www.delta.com/";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);
//locate the calander
        WebElement calander = driver.findElement(By.xpath("//div[@role='button']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        click on calander
        js.executeScript("arguments[0].click();", calander);
//        get the month
        WebElement month = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']"));

        boolean found = false;
        while (!found) {
            String currentMonth = month.getText();
            if (currentMonth.equals("September")) {
                js.executeScript("arguments[0].style.border='5px solid pink'", month);
                found = true;

            } else {
//            next button
                WebElement nxtBtn = driver.findElement(By.xpath("//span[text()='Next']"));
                nxtBtn.click();
            }
        }

//        --------
        List<WebElement> Dates = driver.findElements(By.xpath("//table/tbody/tr/td"));
        for (WebElement date : Dates) {
            String dd = date.getText();
            if (dd.equals("17")) {
                date.click();
                break;
            }
        }
        takeScreenshot("selectedDate");
    }
}
