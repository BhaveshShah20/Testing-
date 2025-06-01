/*public class Main {
    public static void main(String[] args) {
        System.out.println("Selenium Setup Test");
    }
}*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "c:\\Windows\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // Open first URL
        driver.get("https://app.ezobooks.in");

        // Wait for 2 minutes (120000 milliseconds)
        try {
            Thread.sleep(2000); // 2 minutes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Navigate to next page
        driver.navigate().to("https://app.ezobooks.in/categories");

        // Print the title of the current page
        System.out.println("Title: " + driver.getTitle());

        // Close the browser
        // driver.quit();
    }
}

