import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TC_RF_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/gauravg/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/opencart/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//a//span[.='My Account']")));
		element.click();
		
		driver.findElement(By.xpath("//a[.='Register']")).click();
		
		driver.findElement(By.id("input-password")).sendKeys("P12");
	
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type*='submit']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        
        WebElement passwordError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")));
        
        Assert.assertTrue(passwordError.isDisplayed(), "Error message for Password is not displayed.");

	}

}
