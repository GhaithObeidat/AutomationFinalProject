package AutomationFinalProject_April.AutomationFinalProject_April;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

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

		WebElement SettingButton = driver
				.findElement(By.cssSelector(".sc-jTzLTM.cta__button.cta__saudi.btn.btn-primary"));

		SettingButton.click();

	}

	@Test(priority = 1,enabled = false)
	public void CheckWebsiteLanguage(String ExpectedLanguage) {

		String ActualLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");

		assertEquals(ActualLanguage, ExpectedLanguage);
	}

	@Test(priority = 2,enabled = false)
	public void CheckCurrency() {

		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();
		String ExpectedCurrency = "SAR";
		assertEquals(ActualCurrency, ExpectedCurrency);
	}

	@Test(priority = 3,enabled = false)
	public void CheckContactNumber() {

		String ActualNumber = driver.findElement(By.linkText("+966554400000")).getText();
		String ExpectedNumber = "+966554400000";
		assertEquals(ActualNumber, ExpectedNumber);
	}

	@Test(priority = 4,enabled = false)
	public void CheckQitafLogo() {

		WebElement TheFooter = driver.findElement(By.tagName("footer"));
		boolean ActualImageIsDisplayed = TheFooter.findElement(By.cssSelector(".sc-ekulBa.iOOTo"))
				.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-lcpuFF.jipXfR")).isDisplayed();

		System.out.println(ActualImageIsDisplayed);
	}

	@Test(priority = 5,enabled = false)
	public void CheckHotelTabIsNotSelected() {

		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ActualValue = HotelTab.getDomAttribute("aria-selected");
		String ExpectedValue = "false";
		
		assertEquals(ActualValue, ExpectedValue);
	}
	
	@Test(priority = 6,enabled = false)
	public void FlightDepartureDate( ) {
		
		LocalDate date = LocalDate.now();
		
		List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));
		String ActualDepartureDate = dates.get(0).getText();
		int tomorrow = date.plusDays(1).getDayOfMonth();
		String tomorrowAsFormatedValue = String.format("%02d", tomorrow);
		
		System.out.println(ActualDepartureDate);
		System.out.println(tomorrowAsFormatedValue);
		assertEquals(ActualDepartureDate, tomorrowAsFormatedValue);
	}
	
	@Test(priority = 7,enabled = false)
	public void ReturnDate() {
		
		LocalDate date = LocalDate.now();
		
		List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));
		String ActualReturnDate = dates.get(1).getText();
		int dayAfterTomorrow = date.plusDays(2).getDayOfMonth();
		String dayAfterTomorrowAsFormatedValue = String.format("%02d", dayAfterTomorrow);
		
		System.out.println(ActualReturnDate);
		System.out.println(dayAfterTomorrowAsFormatedValue);
		assertEquals(ActualReturnDate, dayAfterTomorrowAsFormatedValue);

	}
	
	@Test(priority = 8,invocationCount = 10)
	public void CheckTheWebsiteLanguage() {
		String [] websites = {"https://www.almosafer.com/en","https://www.almosafer.com/ar"};
		
		Random rand = new Random();
		
		int RandomIndex = rand.nextInt(websites.length);
		
		driver.get(websites[RandomIndex]);
		
		if (driver.getCurrentUrl().contains("en")) {
			CheckWebsiteLanguage("en");
			
		}else {
			CheckWebsiteLanguage("ar");
		}
	}

	@AfterTest
	public void AfterMyTest() {
	}

}
