package review.review002;

import homework.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitsReview extends CommonMethods {
    public static void main(String[] args) {
        String url = "https://the-internet.herokuapp.com/dynamic_controls";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);


//        find the checkbox and click on it
        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();

//        get the button and click on it
        WebElement removeBtn = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeBtn.click();

        /** But i did ctrl x & refresh  part @ that time i didn't see that on DOM ?
         -> and that's why implicit wait (so that implies for implicit concept)
         * */
//       we have to verify that the text it's gone appears up
        WebElement text = driver.findElement(By.xpath("//button[text()='Add']/following-sibling::p"));
        System.out.println(text.getText());


//      get the button enable
        WebElement enableBtn = driver.findElement(By.xpath("//form[@id='input-example']/child::button"));
        enableBtn.click();

        /** For this wait element needs to be finds & meet the excepted condition  */
//      explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

//      wait until
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='input-example']/child::input")));

//      now send some text
        WebElement textBox = driver.findElement(By.xpath("//form[@id='input-example']/child::input"));
        System.out.println(textBox.isEnabled());
    }
}
