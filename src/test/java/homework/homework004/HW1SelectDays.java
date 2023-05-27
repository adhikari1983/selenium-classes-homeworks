package homework.homework004;

import classwork.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HW1SelectDays extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {
        String url = " http://practice.syntaxtechs.net/basic-select-dropdown-demo.php";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

        WebElement days = driver.findElement(By.xpath("//select[@id='select-demo']"));
        Select selectDay = new Select(days);

        Thread.sleep(2000);
        selectDay.selectByVisibleText("Tuesday");
        Thread.sleep(2000);
        selectDay.selectByIndex(5);
        Thread.sleep(2000);
        selectDay.selectByValue("Friday");

        closeBrowser();

    }
}
