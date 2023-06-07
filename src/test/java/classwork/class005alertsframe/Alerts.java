package classwork.class005alertsframe;

import homework.utils.CommonMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Alerts extends CommonMethods {

    public static void main(String[] args) throws InterruptedException {
        String url = "http://practice.syntaxtechs.net/javascript-alert-box-demo.php";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

        WebElement alert1Btn = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        alert1Btn.click();

        Thread.sleep(2000);

        // switch the focus of the driver to the alert\
        // & then find ist alert button and click on it
        Alert confirmationAlert1 = driver.switchTo().alert();
        confirmationAlert1.accept();//so .accept() means -> clicking the ok button of the alert pop-up

        //find the other alert button and click on it
        WebElement alert2Btn = driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
        alert2Btn.click();

        // switch the focus of the driver to the alert\
        //find 2nd alert button and click on it
        Thread.sleep(2000);
        Alert confirmationAlert2 = driver.switchTo().alert();
        confirmationAlert2.dismiss();

    }
}
