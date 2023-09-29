package classwork.class008tabless;

import classwork.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class E2DynamicTable3 extends CommonMethods {
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
        //List<WebElement> allIds = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));

        boolean found = false;
        //boolean found = true;
        // while(!found){ -> will lead to infinite loop
        while (!found) {
            // get all the ids from table into the list
            List<WebElement> allIds = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
            //iterate through all ids and find the id 53481A and click on associated checkBox
            /** When the "List<WebElement> allIds" is positioned outside of the loop, it loses its connection
             to the loop. This causes a problem when we click the 'next' button because it triggers a  DOM
             refresh. During this refresh, the  list(allIds) element disappears and reappears, leading to
             a disruption in its connection within the DOM. Consequently, when the driver disconnects due to
             the DOM refresh, it triggers a Stale Exception. To resolve this issue, it's essential to keep the
             list element inside the loop. So, the solution is => to find the element again( for e.g. allIds ) */
            for (int i = 0; i < allIds.size(); i++) {
                String idText = allIds.get(i).getText();
                //use .contains for the long strings
                if (idText.equals("53481A")) {
                    System.out.println("Click on the check box on the row number " + (i + 1));
                    WebElement checkBox = driver.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[1]"));
                    checkBox.click();
                    found = true;
                    break;
                }
            }
            if (!found) {
                //click on the next page before exiting the while loop
                WebElement nextBtn = driver.findElement(By.xpath("//a[text()='Next']"));
                nextBtn.click();
            }

        }
    }
}
