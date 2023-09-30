package zpractice;

import homework.utils.CommonMethods;

public class Test extends CommonMethods {
    public static void main(String[] args) {
        String url = "https://www.google.com/";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

        //driver.switchTo().frame();
    }
}

