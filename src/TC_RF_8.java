import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TC_RF_8 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/gauravg/Documents/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/opencart/");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//a//span[.='My Account']")));
            element.click();
            
            WebElement register = driver.findElement(By.xpath("//a[.='Register']"));
            register.click();
            
            WebElement subscribeCheckbox = driver.findElement(By.xpath("//input[@name='newsletter' and @type='checkbox']"));
            
            Assert.assertFalse(subscribeCheckbox.isSelected(), "Default 'Subscribe' option is not set to 'No' (checkbox should be unchecked).");
            
        
    }
}
