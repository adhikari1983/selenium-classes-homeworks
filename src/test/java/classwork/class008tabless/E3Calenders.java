package classwork.class008tabless;

import classwork.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class E3Calenders extends CommonMethods {
    public static void main(String[] args) {
        String url = "https://www.aa.com/homePage.do?locale=en_US";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);
//        click on the calander
        WebElement calander = driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[1]"));
        calander.click();

//         Select the date   August, 4 2023
        // get the month and check if it is the desired one
        //WebElement month = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
        //String currentMonth = month.getText();

        boolean monthFound=false;
        while(!monthFound) {
            // get the month and check if it is the desired one
            WebElement month = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
            String currentMonth = month.getText();

            if (currentMonth.equals("August")) {
                System.out.println("you are on the right month");
                List<WebElement> allDates = driver.findElements(By.xpath("//table/tbody/tr/td"));
               // List<WebElement> allDates = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr/td"));
                for(WebElement date:allDates){
                    String currentDate = date.getText();
                    if(currentDate.equals("4")){
                        date.click();
                    }
                }
                monthFound=true;
            }
            else {
//                click next
                WebElement nxtBtn = driver.findElement(By.xpath("(//a[@class='ui-datepicker-next ui-corner-all'])"));
                nxtBtn.click();
            }
        }

    }
}
