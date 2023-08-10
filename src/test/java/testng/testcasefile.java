package testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testcasefile extends Basefile{
	public Properties prop;
	public WebDriver driver;
	public POM pom;
	@BeforeClass
	public void beforeclass() throws IOException
	{
		FileInputStream fis = new FileInputStream("src/test/java/testng/config.properties");
		prop = new Properties();
		prop.load(fis);
	}
	@BeforeMethod
	public void launch()
	{
		driver = setup(prop.getProperty("browser"));
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		pom = new POM(driver);
		expilcitly().until(ExpectedConditions.elementToBeClickable(pom.signin)).click();
		expilcitly().until(ExpectedConditions.visibilityOfElementLocated(pom.un)).sendKeys(prop.getProperty("un"));
		pom.password.sendKeys(prop.getProperty("pwd"));
		pom.submit.click();
	}
	@Test
	public void order_men_browncompetehoodie() throws InterruptedException
	{
		mouseactions().moveToElement(pom.men).build().perform();
		mouseactions().moveToElement(pom.tops).build().perform();
		mouseactions().click(pom.hoodie).perform();
		expilcitly().until(ExpectedConditions.elementToBeClickable(pom.hoodiename)).click();
		expilcitly().until(ExpectedConditions.elementToBeClickable(pom.size)).click();
		pom.color.click();
		System.out.println(pom.color.getCssValue("background"));
		System.out.println(pom.color.getCssValue("color"));
		System.out.println(pom.color.getCssValue("font-style"));
		pom.quantity.clear();
		pom.quantity.sendKeys("2");
		pom.addtocart.click();
		Thread.sleep(2000);
		pom.cart.click();
		expilcitly().until(ExpectedConditions.visibilityOfElementLocated(pom.checkout)).click();
		if(expilcitly().until(ExpectedConditions.visibilityOfElementLocated(pom.pname)).getText().equals("Bruno Compete Hoodie"))
		{
			System.out.println("testcase pass");
		}
		else
		{
			System.out.println("testcase fail");
		}
	}
	@AfterMethod
	public void quit()
	{
		teardown();
	}
}
