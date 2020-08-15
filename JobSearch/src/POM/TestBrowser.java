package POM;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import JobTarget.AmazonProductVerification;
import JobTarget.FlipkartProductVerification;

	public class TestBrowser {
	
		WebDriver driver;
	
		AmazonProductVerification objAmazon;
	
		FlipkartProductVerification objFlipkart;
	
	@BeforeTest
	
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mfcwl\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/");
		
	}
	
	@Test(priority = 0)
	
	public void priceMethodScenario() {
		
		objAmazon = new AmazonProductVerification(driver);
		
		String AmazonPrice = objAmazon.fetchPriceAmazon();
		
		objFlipkart = new FlipkartProductVerification(driver);
		
		String FlipkartPrice = objFlipkart.fetchPriceFlipkart();
		
		if(FlipkartPrice.equals(AmazonPrice)) {
			
			System.out.println("The lesser price is on flipkart" + FlipkartPrice);
		}
		
		else
		{
			System.out.println("The lesser price is on amazon" + AmazonPrice);
		}
		
		}
	}



