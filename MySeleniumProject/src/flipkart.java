// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;


// public class flipkart {
//     public static void main (String[] args){
//         WebDriver driver = new ChromeDriver();
//         driver.get("https://www.flipkart.com/");
//         WebElement searchBox=driver.findElement(By.name("q"));
//         searchBox.sendKeys("isphone 15 pro max");
//         searchBox.submit();

//     }
    
// }


import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class flipkart {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver if it's not set in the system PATH
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

          ChromeOptions options = new ChromeOptions();

        // ✅ Use your actual User Data directory (update your username)
         options.addArguments("user-data-dir=C:\\Users\\bhave\\AppData\\Local\\Google\\Chrome\\User Data\\Default");

        // ✅ Use the actual profile directory name (like "Profile 1", "Default", etc.)
        options.addArguments("profile-directory=Default");


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");

        // // Close login popup if it appears
        // try {
        //     WebElement closeLoginPopup = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
        //     closeLoginPopup.click();
        // } catch (Exception e) {
        //     // Popup did not appear
        // }

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("moto g85");
        searchBox.submit();
         
        //Below 2 line is for to handle tab means click on particular item it open in new tab but it remain on previous tab only
        String mainPage = driver.getWindowHandle();
        System.out.println("Main Page="+mainPage);

        driver.findElement(By.xpath("//div[normalize-space()='Motorola G85 5G (Cobalt Blue, 128 GB)']")).click();;
        Set<String> allPages=driver.getWindowHandles();
        for(String page : allPages){
          if(!page.equals(mainPage)){
            driver.switchTo().window(page);
            break;
          }
        }
        System.out.println(driver.getCurrentUrl());
        List<WebElement> products=driver.findElements(By.className("gf"));
        System.out.println(products.size());
        for(WebElement product:products){
          System.out.println(product.getText());
        }

      }
}
