package vaisala;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vaisalaa 
{
	public By company =By.name("companyName");
	public By userName =By.name("username");
	public By password =By.name("password");
	public By login = By.xpath("//span[contains(text(),'Log in')]");
	public By validation = By.className("input-error");

	public WebDriver driver;
	
	public String url = "http://vlncc-frontend-sandbox-website.s3-website-us-west-2.amazonaws.com/login?returnUrl=%2F";
	public String username="test@gmail.com",pwd = "test";
	
	@BeforeClass
	public void prerequisites()
	{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
	}
	
	@AfterClass
	public void postActions()
	{
        driver.quit();
	}
	
	@DataProvider (name = "data-provider")
	public Object[][] dataProviderMethod()
	{
		return new Object[][] {{"1111111111111111111111222222222"},{"ttttttttttttttttttttttttttttttttttttttttttt"},{"######################$$$$$$$$$$$$%%%%%%%%&&&&&&&&&*********!@"},{"tttttttttttt&***56565767676767667676767676767676767676"}};
	}
		

	@Test(description = "company name length more than 30 charcters with different types of inputs(Task 1)", dataProvider = "data-provider" )
	public void validateCompany(String companyName) throws InterruptedException
	{
		driver.findElement(By.name("companyName")).clear();
		driver.findElement(company).sendKeys(companyName+Keys.TAB);
		String validation = driver.findElement(By.className("input-error")).getText();
		System.out.println("validation is : "+validation);
		if(validation.equals("Company name cannot exceed 30 characters"))
		{
			System.out.println("proper validation message displayed as : "+validation+"test case passed");
		}
		else
		{
			System.out.println("test case failed");
		}
	}
	
	@Test(description = "company name length less than 30 charcters(Task 1)")
	public void validateCompany1() throws InterruptedException
	{
		
			driver.findElement(By.name("companyName")).clear();
			driver.findElement(company).sendKeys("gsgha231@ef");
			String validation = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]")).getText();
			System.out.println("validation is : "+validation);
			if(!validation.equals("Company name cannot exceed 30 characters"))
			{
				System.out.println("validateCompany1 test case passed");
			}
			else
			{
				System.out.println("validateCompany1 test case failed");
			}
		
		
	}

	@Test(description="invalid credentials(Task 2)")
	public void case2() throws InterruptedException
	{
		driver.findElement(By.name("companyName")).clear();
		driver.findElement(company).sendKeys("ghgghf");
		driver.findElement(userName).clear();
		driver.findElement(userName).sendKeys(username);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(login).click();
		Thread.sleep(2000);
		String validation = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]")).getText();
		System.out.println("validation is : "+validation);
		
		if(validation.contains("Invalid user credentials"))
		{
			System.out.println("proper validation message displayed as : "+validation+"test case passed");
		}
		else
		{
			System.out.println("proper validation message is not displaying: "+validation+"test case failed");
		}
	}
	
	
}
