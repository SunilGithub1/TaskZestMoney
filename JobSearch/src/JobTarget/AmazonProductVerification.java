package JobTarget;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import POM.TestBrowser;

public class AmazonProductVerification extends TestBrowser {
		
		WebDriver driver;
		
		By AmazonWebsite = By.xpath("https://www.amazon.in/");
		
		By ProductSearchBar = By.xpath("twotabsearchtextbox");
		
		By ClickSearch = By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']");
		
		By ProductPriceOnAmazon = By.xpath("//span[@class='a-price-whole']");
		
		public  AmazonProductVerification(WebDriver driver) {
			
			this.driver = driver;
		}
		
		//opening the website, entering the product, clicking on search bar and fetching the price
		
		public void openWebsite() throws InterruptedException {
			
			driver.findElement(AmazonWebsite);
			
			Thread.sleep(5000);
			
			driver.manage().window().maximize();
		}
		
		public void searchBar() throws InterruptedException {
			
			driver.findElement(ProductSearchBar).sendKeys("iPhone XR (64GB) - Yellow");
			
			Thread.sleep(3000);
		}
		
		public void searchIcon() throws InterruptedException {
			
			driver.findElement(ClickSearch).click();
			
			Thread.sleep(3000);
		}
		
		public void amazonPrice() {
			
			driver.findElement(ProductPriceOnAmazon);
		}
		
		public String fetchPriceAmazon() {
			
			return driver.findElement(ProductPriceOnAmazon).getText();
		}
		
		// to call all the methods
		
		public void fullDetails() throws InterruptedException {
			
			this.openWebsite();
			
			this.searchBar();
			
			this.searchIcon();
			
			this.amazonPrice();
			
			this.fetchPriceAmazon();
		}
	}
