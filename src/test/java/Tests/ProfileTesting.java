package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert.*;
import org.testng.asserts.SoftAssert;

public class ProfileTesting {
	
	WebDriver driver;


//	@Parameters("browserName")
//	@BeforeTest
//	public void InitialiseBrowser(String browserName) {
//		switch (browserName.toLowerCase()) {
//			case "chrome":
//				WebDriverManager.chromedriver().setup();
//				driver = new ChromeDriver();
//				break;
//			case "edge":
//				WebDriverManager.edgedriver().setup();
//				driver = new EdgeDriver();
//				break;
//			case "firefox":
//				WebDriverManager.firefoxdriver().setup();
//				driver = new FirefoxDriver();
//				break;
//			default:
//				System.out.println("Browser name is invalid");
//				break;
//		}
//		driver.manage().window().maximize();
//	}
	@BeforeTest
	public void InitializeBrowser(){
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Parameters("url")
	@Test
	public void LaunchApp(String url) throws InterruptedException {
		driver.get(url);
		Thread.sleep(3500);
		driver.findElement(By.className("yes")).click();
		Thread.sleep(5000);
	}

	@Parameters({"username","password"})
	@Test
	public void Login(String username, String password ) throws InterruptedException {
		driver.get("https://vapesdirect.pk/my-account-1/customer-logout/?_wpnonce=812039d21e/");
		
//		Thread.sleep(3500);
//		driver.findElement(By.className("yes")).click();
		Thread.sleep(1500);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(500);
		driver.findElement(By.name("rememberme")).click();
		Thread.sleep(1500);
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
	}

	@Test
	public void  Register() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		driver.get("https://vapesdirect.pk/my-account-1/customer-logout/?_wpnonce=812039d21e/");
		
		Thread.sleep(3500);
		driver.findElement(By.className("yes")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("reg_username")).sendKeys("Clash.replays.best");
		driver.findElement(By.id("reg_email")).sendKeys("clash.replays.best@gmail.com");
		driver.findElement(By.id("reg_password")).sendKeys("Abdullah.123");
		jse.executeScript("window.scrollBy(0,100)");
		driver.findElement(By.id("mailchimp_woocommerce_newsletter")).click();
		
		jse.executeScript("window.scrollBy(0,125)");
		Thread.sleep(1500);
		driver.findElement(By.name("register")).click();
		Thread.sleep(5000);
	}

	@Test
	public void LoginAfterRegister() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		driver.get("https://vapesdirect.pk/my-account-1/customer-logout/?_wpnonce=812039d21e/");

		Thread.sleep(3500);
		driver.findElement(By.className("yes")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("reg_username")).sendKeys("Clash.replays.best");
		driver.findElement(By.id("reg_email")).sendKeys("clash.replays.best@gmail.com");
		driver.findElement(By.id("reg_password")).sendKeys("Abdullah.123");
		jse.executeScript("window.scrollBy(0,100)");
		driver.findElement(By.id("mailchimp_woocommerce_newsletter")).click();

		jse.executeScript("window.scrollBy(0,125)");
		Thread.sleep(1500);
		driver.findElement(By.name("register")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("/Html/Body/Div[1]/Ul/Li/Div/A")).click();
		Thread.sleep(5000);
	}
	

	@AfterTest()
	public void Teardown(){
		driver.quit();
	}

}
