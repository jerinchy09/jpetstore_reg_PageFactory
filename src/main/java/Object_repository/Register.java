package Object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Register {
	WebDriver driver;
	
	//User information
	@FindBy(name= "username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(name ="repeatedPassword")
	WebElement repeat_password;
	
	//Account Information
	@FindBy(name ="account.firstName")
	WebElement firstname;
	@FindBy(name ="account.lastName")
	WebElement lastname;
	@FindBy(name ="account.email")
	WebElement email;
	@FindBy(name ="account.phone")
	WebElement phone;
	
	@FindBy(name ="account.address1")
	WebElement address1;
	@FindBy(name ="account.address2")
	WebElement address2;
	@FindBy(name ="account.city")
	WebElement city;
	@FindBy(name ="account.state")
	WebElement state;
	@FindBy(name ="account.zip")
	WebElement zip;
	@FindBy(name ="account.country")
	WebElement country;
	
	//Profile Information
	@FindBy(name ="account.languagePreference")
	WebElement lang;
	@FindBy(name ="account.favouriteCategoryId")
	WebElement category;
	@FindBy(name ="account.listOption")
	WebElement enable_myList;
	@FindBy(name ="account.bannerOption")
	WebElement enable_myBanner;
	
	//Save info Button
	@FindBy(name ="newAccount")
	WebElement save_button;
	
	public Register(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    //Passing from ExcelData
	public void valid_reg_userInfo(String user, String pass,String rep_pass) {
		username.sendKeys(user);
		password.clear();
		password.sendKeys(pass);
		repeat_password.clear();
		repeat_password.sendKeys(rep_pass);
	}
	//Passing from @DataProvider in App.test
	public void valid_reg_accountInfo(String fn,String ln,String em,String phn, String add1,String add2,String ct,String st,String zp,String cntr) {
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		email.sendKeys(em);
		phone.sendKeys(phn);
		address1.sendKeys(add1);
		address2.sendKeys(add2);
		city.sendKeys(ct);
		state.sendKeys(st);
		zip.sendKeys(zp);
		country.sendKeys(cntr);	
	}
	
	public void valid_reg_profileInfo() throws InterruptedException {
		
		Select se_lan = new Select(lang);			
		se_lan.selectByVisibleText("japanese");	
		
		Select se_cat = new Select(category);			
		se_cat.selectByVisibleText("BIRDS");	
		
		enable_myList.click();
		Thread.sleep(1000);
		enable_myList.click();

		enable_myBanner.click();
		
	}
	public void reg_button() {
		save_button.click();
	}
}
