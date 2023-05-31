/*
http://practice.syntaxtechs.net/javascript-alert-box-demo.php
click on the last alert
send keys and accept it
 */
package homework.homework005;

import classwork.utils.CommonMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HW1 extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {
        String url = "http://practice.syntaxtechs.net/javascript-alert-box-demo.php";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

//      find the prompt btn & click it
        WebElement promptBox = driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']"));
        promptBox.click();
        Thread.sleep(2000);

//      switched to the alert & sendKeys to the textBox
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Kiran Adhikari");
        Thread.sleep(2000);
        promptAlert.accept();

    }
}
