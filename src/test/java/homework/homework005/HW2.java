/*
HW2:
goto https://chercher.tech/practice/frames
click on check box
then select bay cat from drop down
then enter text in text box (edited)

 */
package homework.homework005;

import classwork.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HW2 extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://chercher.tech/practice/frames";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

        driver.switchTo().frame(0);

//      switch to frame3 & click on checkbox
        WebElement frame3=driver.findElement(By.xpath("//iframe[@id='frame3']"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.id("a")).click();
        Thread.sleep(2000);

//      switch back to default content
        driver.switchTo().defaultContent();

//      switch to frame1 & select baby cat from drop down
        driver.switchTo().frame(1);
        WebElement dropDown= driver.findElement(By.xpath("//select[@id='animals']"));
        Select sel=new Select(dropDown);
        sel.selectByVisibleText("Baby Cat");
        Thread.sleep(2000);

        driver.switchTo().defaultContent();

//      switch to frame0 & enter text in text box
        driver.switchTo().frame(0);
        WebElement textBox=driver.findElement(By.xpath("//input"));
        textBox.sendKeys("Some testing text");


        Thread.sleep(3000);
        driver.quit();

    }
}
