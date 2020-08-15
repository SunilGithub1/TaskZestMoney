package JobTarget;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import POM.TestBrowser;

public class FlipkartProductVerification extends TestBrowser{

	WebDriver driver;
	
	By FlipkartWebsite = By.xpath("https://www.flipkart.com/");
	
	By ProductSearchBar = By.xpath("//input[@placeholder='Search for products, brands and more']");
	
	By ClickSearch = By.xpath("//div[@id='container']//div//div//div//div//div//form//div//button");
	
	By ProductPriceOnFlipkart = By.xpath("//div[@class='_1vC4OE _2rQ-NK']");
	
	public FlipkartProductVerification(WebDriver driver) {
		
		this.driver = driver;
	}
	
	//opening the website, entering the product, clicking on search bar and fetching the price
	
	public void openWebsite() throws InterruptedException {
		
		driver.findElement(FlipkartWebsite);
		
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
		
		driver.findElement(ProductPriceOnFlipkart);
	}
	
	public String fetchPriceFlipkart() {
		
		return driver.findElement(ProductPriceOnFlipkart).getText();
	}
	
	// to call all the methods
	
	public void fullDetails() throws InterruptedException {
		
		this.openWebsite();
		
		this.searchBar();
		
		this.searchIcon();
		
		this.amazonPrice();
		
		this.fetchPriceFlipkart();
	}
}

