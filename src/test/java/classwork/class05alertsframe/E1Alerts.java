package classwork.class05alertsframe;

import classwork.utils.CommonMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class E1Alerts extends CommonMethods {

    public static void main(String[] args) throws InterruptedException {
        String url = "http://practice.syntaxtechs.net/javascript-alert-box-demo.php";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

        /** for 1st click button */
        WebElement alertBtn1 = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        alertBtn1.click();

        Thread.sleep(2000);

        // switch the focus of the driver to the alert\
        // & then find 1st alert button and click on it
        Alert confirmationOfAlert1 = driver.switchTo().alert();
        confirmationOfAlert1.accept();//so .accept() means -> clicking the ok button of the alert pop-up

        /** for 2nd click button */
        //find the other alert button and click on it
        WebElement alertBtn2 = driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
        alertBtn2.click();

        // switch the focus of the driver to the alert\
        //find 2nd alert button and click on it
        Thread.sleep(2000);
        Alert confirmationOfAlert2 = driver.switchTo().alert();
        confirmationOfAlert2.dismiss();

        Thread.sleep(2000);

        /** for 3rd click button */
        WebElement alertBtn3 = driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']"));
        alertBtn3.click();

        Thread.sleep(2000);

        /** Note: don't worry if the text u send doesn't appears up in the textbox */
        Alert confirmationOfAlert3 = driver.switchTo().alert();
        confirmationOfAlert3.sendKeys("Kiran Adhikari");
        Thread.sleep(2000);
        confirmationOfAlert3.accept();

        /*
               **** WE CAN ALSO DO IT BY SIMULATING KEYBOARD EVENT ****
                Simulate keyboard events to send keys to the prompt box
        Actions actions = new Actions(driver);
        actions.sendKeys((CharSequence) confirmationOfAlert3, "Kiran Adhikari").perform();
        */

    }
}
