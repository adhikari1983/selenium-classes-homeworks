package classwork.class009;

import classwork.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class E8FileUpload extends CommonMethods {
    public static void main(String[] args) {
        /** one of the best website to practice the selenium task -> viiiip*/
        String url = "https://the-internet.herokuapp.com/upload";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url,browser);

//        find the element which u can click to upload the file
        WebElement fileUploadBtn = driver.findElement(By.xpath("//input[@id='file-upload']"));

//      in order to send/upload the file
//      u can send the path of that file in sendKeys
//      the file path will be different for everyone depending on their own system
        fileUploadBtn.sendKeys("C:\\Users\\adhik\\OneDrive\\Desktop\\testUpload.txt");


    }
}
