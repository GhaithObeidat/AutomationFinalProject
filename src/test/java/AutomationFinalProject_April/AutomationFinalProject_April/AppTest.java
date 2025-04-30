package AutomationFinalProject_April.AutomationFinalProject_April;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {
	String TheWebsiteURl = "https://www.almosafer.com/en";
	WebDriver driver = new ChromeDriver();

   @BeforeTest
   public void mySetup() {
	   
	   driver.get(TheWebsiteURl);
	   
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	   
	   driver.manage().window().maximize();
	   
	   WebElement SettingButton = driver.findElement(By.cssSelector(".sc-jTzLTM.cta__button.cta__saudi.btn.btn-primary"));
	   
	   SettingButton.click();
	  
   }
   
   @Test(priority = 1)
   public void CheckWebsiteLanguage() {
	   
	   String ActualLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
	   String ExpectedLanguage = "en";
	   
	   assertEquals(ActualLanguage, ExpectedLanguage);
   }
   
   @Test(priority = 2)
   public void CheckCurrency() {
	   
	   String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']")).getText();
	   String ExpectedCurrency = "SAR";
	   assertEquals(ActualCurrency, ExpectedCurrency);
   }
   
   @Test(priority = 3)
   public void CheckContactNumber() {
	   
	   String ActualNumber = driver.findElement(By.linkText("+966554400000")).getText();
	   String ExpectedNumber = "+966554400000";
	   assertEquals(ActualNumber, ExpectedNumber);
   }
   
   @Test(priority = 4)
   public void CheckQitafLogo() {
	   
	   WebElement TheFooter = driver.findElement(By.tagName("footer"));
	   boolean ActualImageIsDisplayed = TheFooter.findElement(By.cssSelector(".sc-ekulBa.iOOTo")).findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-lcpuFF.jipXfR")).isDisplayed();
	   
	   System.out.println(ActualImageIsDisplayed);
   }
   
   @AfterTest
   public void AfterMyTest() {}
	
}
