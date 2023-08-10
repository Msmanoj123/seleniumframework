package stepdefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import POMfiles.POM_cart;
import io.cucumber.java.en.*;

public class beyoungtestcase extends testng.Basefile{
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test1;
	public POM_cart pom;
	@Given("User is open browser and launch the URL {string}")
	public void user_is_open_browser_and_launch_the_url(String URL) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\manoj.ms\\eclipse-workspace\\completeselenium\\src\\test\\java\\stepdefinitions\\config.properties");
		extent = new ExtentReports("C:\\\\Users\\\\manoj.ms\\\\eclipse-workspace\\\\completeselenium\\\\src\\\\test\\\\java\\\\stepdefinitions\\\\report.html");
		Properties prop = new Properties();
		prop.load(fis);
		driver=setup(prop.getProperty("browser"));
		driver.get(URL);
		driver.manage().window().maximize();
		ExtentReports test = extent.assignProject("beyoung");
		test1 = extent.startTest("beyoung report");
		//		//create cookie 
		//		Cookie cookie = new Cookie("cookiename", "cookievalue");
		//		driver.manage().deleteCookie(cookie);
		//		driver.manage().addCookie(cookie);
		driver.manage().deleteAllCookies();
		pom = new POM_cart(driver);
		//		//get and set window size
		//		driver.manage().window().getSize().getHeight()
		//		driver.manage().window().getSize().getWidth()
		//		driver.manage().window().setSize(new Dimension(200,500));
	}

	@Then("validate user is on home page")
	public void validate_user_is_on_home_page() throws IOException {
		if(driver.getTitle().contains("Beyoung"))
		{
			test1.log(LogStatus.PASS,"land correct page");
		}
		else
		{
			test1.log(LogStatus.FAIL,screenshot("homepage"),"land on wrong page");
		}
	}

	@When("mouse over on men and click on printed t shirts")
	public void mouse_over_on_men_and_click_on_printed_t_shirts() {
		expilcitly().until(ExpectedConditions.visibilityOfElementLocated(pom.men));
		mouseactions().moveToElement(driver.findElement(pom.men)).build().perform();
		mouseactions().moveToElement(pom.printedshirt).click().build().perform();

	}

	@Then("validate user land on correct page")
	public void validate_user_land_on_correct_page() throws IOException {
		expilcitly().until(ExpectedConditions.visibilityOfElementLocated(pom.heading));
		if(driver.findElement(pom.heading).getText().equalsIgnoreCase("T SHIRTS FOR MEN"))
		{
			test1.log(LogStatus.PASS,"land correct page");
		}
		else
		{
			test1.log(LogStatus.FAIL,screenshot("tshirts"),"land on wrong page");
		}
	}

	@When("select camo balidan badge half sleeve and select size and color and add to cart")
	public void select_camo_balidan_badge_half_sleeve_and_select_size_and_color_and_add_to_cart() throws InterruptedException, IOException {
		scroll().executeScript("window.scrollBy(0,document.body.scrollHeight)");
		scroll().executeScript("arguments[0].click();", expilcitly().until(ExpectedConditions.visibilityOfElementLocated(pom.balidan)));
		for(WebElement e:driver.findElements(By.cssSelector(".size-box>.size")))
		{
			if(e.getText().equalsIgnoreCase("m"))
			{
				e.click();
				break;
			}
		}
		staticdropdown(pom.stdrop).selectByVisibleText("2");
		pom.addtocart.click();
	}



	@Then("validate the item present in the cart")
	public void validate_the_item_present_in_the_cart() {
		pom.cart.click();
		expilcitly().until(ExpectedConditions.textToBe(pom.pname,"Camo Balidaan Badge Half Sleeve T-shirt for Men"));
		extent.flush();
		driver.quit();
	}

}
