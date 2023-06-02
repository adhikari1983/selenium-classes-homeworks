package classwork.class006;

import classwork.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class WindowHandles extends CommonMethods {

    public static void main(String[] args) {
        String url = "http://accounts.google.com/signup";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

//      click on the help button privacy button
        WebElement helpBtn = driver.findElement(By.linkText("Help"));
        helpBtn.click();

        WebElement privacyBtn = driver.findElement(By.xpath("//a[text()='Privacy']"));
        privacyBtn.click();
        /** Till now focus is on the main window page even we clicked on two tabs*/

//      get the window handle of the main page and print on console
//      also save it for later use
        String mainPageHandle = driver.getWindowHandle();
        System.out.println("Main page window handle is " + mainPageHandle);

//        get all the window handles and print the tittle associated with each window handle
//        on the console

//      get all handles
        //switch the focus of the driver to google help page
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            String title = driver.getTitle();

            if(title.equalsIgnoreCase("Google Account Help")){
                break;
            }
            //System.out.println("The tittle associated with "+handle+ " is " + title);//

        }
//      when the focus is shifted to the correct page
        System.out.println("The current page under the focus is : " + driver.getTitle());

//     after switching to page google account help, we can deal with any element we want
//     to do in regular manner

//        switch my focus back to main page
        driver.switchTo().window(mainPageHandle);

//      check the current focus page
        System.out.println("The current focus is on : " + driver.getTitle());
    }
}
