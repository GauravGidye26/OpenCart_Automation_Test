import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TC_RF_5 {
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
		
		driver.findElement(By.id("input-email")).sendKeys("dsbjhd@jhd");
	
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type*='submit']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        
        WebElement emailError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")));
        
        Assert.assertTrue(emailError.isDisplayed(), "Error message for E-Mail is not displayed.");

	}

}