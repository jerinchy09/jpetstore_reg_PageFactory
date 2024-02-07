package Object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;
	@FindBy(xpath ="//*[@id=\"Catalog\"]/a")
	WebElement register;
	//By register = By.xpath("//*[@id=\"Catalog\"]/a");	
	
	By username = By.name("username");
	By password = By.name("password");
	By login_button = By.name("signon");
	
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void login_credentials(String user, String pass) {
//		driver.findElement(username).clear();
//		driver.findElement(username).sendKeys(user);
//		driver.findElement(password).clear();
//		driver.findElement(password).sendKeys(pass);
//		driver.findElement(login_button).click();
	}

	public void register() {
		register.click();
	}
}
