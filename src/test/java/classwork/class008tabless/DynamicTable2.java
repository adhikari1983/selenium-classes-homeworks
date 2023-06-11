package classwork.class008tabless;

import classwork.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DynamicTable2 extends CommonMethods {
    public static void main(String[] args) {
        String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);
        //login to website
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement userPassword = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        userPassword.sendKeys("Hum@nhrm123");
        WebElement logInBtn = driver.findElement(By.xpath("//input[contains(@id, 'btn')]"));
        logInBtn.click();

        //click on the PimTab
        WebElement pimTab = driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']"));
        pimTab.click();

        // get all the ids from table into the list
        List<WebElement> allIds = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));

        //iterate through all ids and find the id 53502A and click on associated checkBox
        for (int i = 0; i <allIds.size(); i++) {
            String idText = allIds.get(i).getText();
            //use .contains for lon long strings
            if(idText.equals("53502A")){
                System.out.println("Click on the check box on the row number " + (i+1));
                                                                // we concatenate here coz of on the go/Dynamic in nature
                WebElement checkBox = driver.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[1]"));
                checkBox.click();
            }
        }
    }
}
