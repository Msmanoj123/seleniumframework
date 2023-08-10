package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM {
public WebDriver driver;
	public POM(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	By signin = By.cssSelector("ul>li>a[href='https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/']");
	By un = By.cssSelector("#email");
	@FindBy(id="pass")
	public WebElement password;
	@FindBy(id="send2")
	public WebElement submit;
	@FindBy(css="nav>ul>li:nth-child(3)")
	public WebElement men;
	@FindBy(css="nav>ul>li:nth-child(3)>ul>li:nth-child(1)>a")
	public WebElement tops;
	@FindBy(css="nav>ul>li:nth-child(3)>ul>li:nth-child(1)>ul>li:nth-child(2)>a")
	public WebElement hoodie;
	By hoodiename=By.cssSelector("strong>a[href='https://magento.softwaretestingboard.com/bruno-compete-hoodie.html']");
	By size=By.cssSelector("#option-label-size-143-item-170");
	@FindBy(css="#option-label-color-93-item-53")
	public WebElement color;
	@FindBy(css="#qty")
	public WebElement quantity;
	@FindBy(css="#product-addtocart-button")
	public WebElement addtocart;
	By msg = By.xpath("(//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)'])[2]");
	@FindBy(css=".action.showcart")
	public WebElement cart;
	By checkout = By.cssSelector(".action.viewcart");
	By pname = By.cssSelector(".cart.item>.item-info>.col.item>div>.product-item-name");
	
//	@FindBy(css="nav>ul>li:nth-child(3)")
//	public WebElement men;
}
