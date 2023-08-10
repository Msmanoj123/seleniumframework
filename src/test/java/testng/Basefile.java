package testng;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basefile {
	public WebDriver driver;
	public WebDriver setup(String browsername)
	{
		if(browsername.equals("chrome"))
		{
			ChromeOptions chrome = new ChromeOptions();
			chrome.addArguments("--remote-allow-origins=*");
			chrome.addArguments("--disabled-notifications");
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver(chrome);
			return driver;
		}
		else if(browsername.equals("edge"))
		{
			EdgeOptions chrome = new EdgeOptions();
			chrome.addArguments("--remote-allow-orgins=*");
			chrome.addArguments("--disabled-notifications");
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver(chrome);
			return driver;
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
			return driver;
		}
	}
	public WebDriverWait expilcitly()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(2));
		return wait;
	}
	public Actions mouseactions()
	{
		Actions a = new Actions(driver);
		return a;
	}
	public void teardown()
	{
		driver.quit();
	}
	public String screenshot(String ssname) throws IOException
	{
		TakesScreenshot tg = (TakesScreenshot) driver;
		File src = tg.getScreenshotAs(OutputType.FILE);
		File trg = new File("C:\\Users\\manoj.ms\\eclipse-workspace\\completeselenium\\src\\test\\java\\Screenshots\\"+ssname+".png");
		String path = trg.getAbsolutePath();
		FileUtils.copyFile(src, trg);
		return path;
	}
	public JavascriptExecutor scroll()
	{
		JavascriptExecutor js =(JavascriptExecutor) driver;
		return js;
	}
	public Select staticdropdown(WebElement ele)
	{
		Select sel = new Select(ele);
		return sel;
	}
}
