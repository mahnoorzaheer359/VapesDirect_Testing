package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchTesting {
    WebDriver driver;
    @BeforeTest(enabled=false)
    public void InitializeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(groups = {"Group2"})
    public void Searchbar() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://vapesdirect.pk/");

        Thread.sleep(3500);
        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);

        driver.findElement(By.xpath("/Html/Body/Div[2]/Header/Div/Div[1]/Div/Div[3]/Ul/Li[3]/A/I")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Pod", Keys.RETURN);
        Thread.sleep(5000);
    }

    @Test
    public void TopNavHover() throws InterruptedException {
        driver.get("https://vapesdirect.pk/");
        Thread.sleep(3500);
        driver.findElement(By.className("yes")).click();
        Thread.sleep(3000);
        Actions a = new Actions(driver);

        WebElement e = driver.findElement(By.xpath("/Html/Body/Div[2]/Header/Div/Div[2]/Div[1]/Div[4]/Ul/Li[3]/A"));

        a.moveToElement(e).perform();
        driver.findElement(By.xpath("/Html/Body/Div[2]/Header/Div/Div[2]/Div[1]/Div[4]/Ul/Li[3]/Div/Div/Div[1]/Div/Div[2]/Div[2]/Div/Div[2]/Div[1]/Div/Div/Div[1]/A/Span")).click();
        Thread.sleep(5000);
    }

    @Test
    public void TopNavClick() throws InterruptedException {
        driver.get("https://vapesdirect.pk/");
        Thread.sleep(3500);
        driver.findElement(By.className("yes")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/Html/Body/Div[2]/Header/Div/Div[2]/Div[1]/Div[4]/Ul/Li[3]/A")).click();
        Thread.sleep(5000);

    }
    @Test
    public void SortBy() throws InterruptedException {
        driver.get("https://vapesdirect.pk");

        Thread.sleep(3500);
        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);

        driver.findElement(By.xpath("/Html/Body/Div[2]/Header/Div/Div[2]/Div[1]/Div[4]/Ul/Li[1]/A")).click();

        WebElement e = driver.findElement(By.xpath("/Html/Body/Div[2]/Div/Div[2]/Div[3]/Form/Select"));

        Select select = new Select(e);

        select.selectByValue("popularity");
        Thread.sleep(5000);
    }
    @AfterTest()
    public void Teardown(){
        driver.quit();
    }
}
