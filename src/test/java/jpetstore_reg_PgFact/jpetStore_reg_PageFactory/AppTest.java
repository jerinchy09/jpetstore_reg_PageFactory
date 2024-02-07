package jpetstore_reg_PgFact.jpetStore_reg_PageFactory;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Object_repository.Homepage;
import Object_repository.Login;
import Object_repository.Register;
import utilities.ExcelData;
import utilities.cross_browser;
import utilities.dataProvider;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    WebDriver driver;
    String[] data = new String[5];
    
    ExtentReports report = new ExtentReports();
    ExtentSparkReporter sparkreport = new ExtentSparkReporter("E:\\Nexvalli\\Eclipse Wrokspace\\jpetStore_reg_PageFactory\\target\\report.html");
    ExtentTest test = report.createTest("Login APp");
    
    @Test(dataProvider = "Invalid_accountInfo", dataProviderClass = dataProvider.class)
	public void application(String fn,String ln,String email,String phn, String add1,String add2,String city,String state,String zip,String country, Method method) throws IOException, InterruptedException{
		report.attachReporter(sparkreport);
		cross_browser br = new cross_browser();
		driver=br.browser_inititate();
		Homepage h = new Homepage(driver);
		h.sign_in();
		test.log(Status.PASS,"user clicked on Signed in");

		//Excel data
		ExcelData d = new ExcelData();
		data=d.readExcel();
		String user = data[0];
		String pass = data[1];

		Login l = new Login(driver);
		//l.login_credentials(user,pass);
		l.register();
		test.log(Status.PASS,"user clicked on register");
		
		
		Register reg = new Register(driver);
		//l.login_credentials(user,pass);
		reg.valid_reg_userInfo(user, pass, pass);
		test.log(Status.PASS,"User Info passed from Excel");

		//from data provider		
		reg.valid_reg_accountInfo(fn,ln,email,phn,add1,add2,city,state,zip,country);		

		//reg.valid_reg_accountInfo(fsn,lsn,em,pn,addr1,addr2,ct,st,zp,cntr);		
		test.log(Status.PASS,"Account Info passed from Data provider");

		reg.valid_reg_profileInfo();
		test.log(Status.PASS,"Profile Info passed from page");
		
		reg.reg_button();
		test.log(Status.PASS,"User clicked on register Button");

		report.flush();

	}
}
