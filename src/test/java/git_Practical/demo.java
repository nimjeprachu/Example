package git_Practical;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class demo {
	
	@Test
	public void test01() {
		System.setProperty("webdriver.chrome.drive", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		Actions action =new Actions(driver);
		WebElement signinbutton=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		
		action.moveToElement(signinbutton).click(driver.findElement(By.className("nav-action-inner"))).build().perform();
		driver.findElement(By.id("ap_email")).sendKeys("8149167659");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("Prachi");
		driver.findElement(By.id("signInSubmit")).click();
		String actual=driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
		String expected="Hello Prachi";
		Assert.assertEquals(actual, expected);
		driver.close();
		
	}

}
