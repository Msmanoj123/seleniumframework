package POMfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_cart {
public WebDriver driver;
	public POM_cart(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	public By men = By.cssSelector(".menu>li:nth-child(1)>a");
	@FindBy(css=".menu>li:nth-child(1)>ul>li>article:nth-child(1)>a[href='/t-shirts-for-men']")
	public WebElement printedshirt;
	public By heading = By.cssSelector(".container>.right-side>h1");
	public By color =By.cssSelector("#Camo");
	@FindBy(css=".quantity-box>select")
	public WebElement stdrop;
	@FindBy(xpath="//a[.='ADD TO CART']")
	public WebElement addtocart;
	@FindBy(css=".add-cart-icon")
	public WebElement cart;
	public By pname = By.cssSelector(".productdetail>.cartpname");
	public By balidan = By.xpath("//a[@href='/camo-balidaan-badge-half-sleeve-t-shirt-for-men']");
	
}
