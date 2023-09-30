package zpractice;

import homework.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HW extends CommonMethods {
    public static void main(String[] args) {
        String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

        // Login to Syntax HRMS
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement userPassword = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        userPassword.sendKeys("Hum@nhrm123");
        WebElement logInBtn = driver.findElement(By.xpath("//input[contains(@id, 'btn')]"));
        logInBtn.click();

        // Click on the Recruitment button
        WebElement recruitmentBtn = driver.findElement(By.xpath("//a[@id='menu_recruitment_viewRecruitmentModule']"));
        recruitmentBtn.click();

        // Click on the from calendar
        WebElement fromCalendarBtn = driver.findElement(By.xpath("(//img[@class='ui-datepicker-trigger'])[1]"));
        fromCalendarBtn.click();

        // Select the date - August, 8
        boolean monthFound = false;
        while (!monthFound) {
            // Get the month and check if it is the desired one
            WebElement monthElement = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
            String currentMonth = monthElement.getText();
            if (currentMonth.equals("August")) {
                System.out.println("You are on the right month");
                List<WebElement> allDates = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td"));
                for (WebElement date : allDates) {
                    String currentDate = date.getText();
                    if (currentDate.equals("8")) {
                        date.click();
                        monthFound = true;
                        break;
                    }
                }
            } else {
                // Click on the next button
                WebElement nextBtn = driver.findElement(By.xpath("(//a[@class='ui-datepicker-next ui-corner-all'])"));
                nextBtn.click();
            }
        }

        // Close the browser
        driver.quit();
    }
}
