package classwork.class004chekboxdropdown;

import classwork.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RadioButton extends CommonMethods {
    public static void main(String[] args) {
        String url = "http://practice.syntaxtechs.net/basic-radiobutton-demo.php";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);
//      find the radio btn male and click on it
        WebElement r1 = driver.findElement(By.xpath("//input[@value='Male' and @name='optradio']"));
        r1.click();

//      check if the radio button  is selected
        boolean r1isSelected = r1.isSelected();
        System.out.println("The radio button Male is selected : " + r1isSelected);

//      check if the radio button is displayed
        boolean r1isDisplayed = r1.isDisplayed();
        System.out.println("The radio button Male is displayed : " + r1isDisplayed);

//      check if the radio button is enabled
        boolean r1isEnabled = r1.isEnabled();
        System.out.println("The radio button Male is enabled : " + r1isEnabled);

//      deselect the male r1 button
        WebElement r2 = driver.findElement(By.xpath("//input[@value='Female' and @name='optradio']"));
        r2.click();

//      check if the male btn is deselected
        r1isSelected = r1.isSelected();
        System.out.println("The radio button Male is selected : " + r1isSelected);


    }
}
