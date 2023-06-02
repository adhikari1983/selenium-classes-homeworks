package classwork.class005;

import homework.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Frames extends CommonMethods {
    public static void main(String[] args) {
        String url = "https://chercher.tech/practice/frames";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

        //task1: print animal on screen
        //and select Baby Cat from drop down

        // step: 1
        //  as the webElement is inside an iframe
        // first we need to switch to iframe
        driver.switchTo().frame(1);

        // find the WebElement animal
        WebElement animal = driver.findElement(By.xpath("//b[text()='Animals :']"));
        System.out.println(animal.getText());

        //select baby cat
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='animals']"));
        Select selectDD = new Select(dropDown);
        selectDD.selectByVisibleText("Baby Cat");

        //switch the focus to the main page
        driver.switchTo().defaultContent();

        //switch the focus to the containing text box
        driver.switchTo().frame("frame1");

        //switch to frame containing text box
        WebElement textBox = driver.findElement(By.xpath("//input"));
        textBox.sendKeys("abcdefgh");

        //click on the checkbox
        //switch to frame using webElement method
        WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='frame3']"));
        driver.switchTo().frame(frame3);

        driver.findElement(By.id("a")).click();

    }
}
