package zpractice;

import homework.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class C extends CommonMethods {
    public static void main(String[] args) {
        /*goto https://chercher.tech/practice/frames
click on check box
then select bay cat from drop down
then enter text in text box (edited)
 */
        String url = "https://chercher.tech/practice/frames";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

        driver.switchTo().frame("frame1");

        WebElement inputBox = driver.findElement(By.tagName("input"));
        inputBox.sendKeys("Testing text box");

        driver.switchTo().frame("frame3");

        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame2");

        WebElement animals = driver.findElement(By.xpath("//*[@id=\"animals\"]"));
        Select selectOption = new Select(animals);
        selectOption.selectByValue("babycat");

    }
}
