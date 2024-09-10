import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TC_RF_10 {

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
            
            driver.findElement(By.id("input-firstname")).sendKeys("Gauri");
            driver.findElement(By.id("input-lastname")).sendKeys("Gidye");
            driver.findElement(By.id("input-email")).sendKeys("gaurav262001@gmail.com");
            driver.findElement(By.id("input-password")).sendKeys("Pass123!");

            WebElement privacyPolicy = driver.findElement(By.xpath("//input[@name='agree']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", privacyPolicy);
            
            WebElement Button = driver.findElement(By.cssSelector("button[type='submit']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Button);
            
            WebElement warningMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Warning: E-Mail Address is already registered!')]")));
            Assert.assertTrue(warningMessage.isDisplayed(), "Error: Warning message for already registered email is not displayed.");
            
        
    }
}
