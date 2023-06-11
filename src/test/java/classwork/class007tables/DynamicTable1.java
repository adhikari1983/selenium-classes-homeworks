package classwork.class007tables;

import homework.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DynamicTable1 extends CommonMethods {
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

        //        print the row number of the row that has the id 55804A
        List<WebElement> allIDs = driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[2]"));

        for (int i = 0; i < allIDs.size(); i++) {
            String idText = allIDs.get(i).getText();
            if(idText.contains("55804A")){
                System.out.println("Id no " + idText + " is on row number " + (i+1));
                WebElement completeRowText =
                        driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr["+(i+1)+"]"));
                System.out.println(completeRowText.getText());
            }
        }

    }
}
