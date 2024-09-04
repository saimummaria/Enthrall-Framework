package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

// new, you have to manually write it to get access of common actions
// this is possible when they are static in nature, * means all
// This is called static import
import static common.CommonActions.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HomePage {
	WebDriver driver;
	JavascriptExecutor js;

	// parameterized constructor initialized when class in instantiated [object created]
	public HomePage(WebDriver driver) {
		this.driver = driver;
		// PageFactory class help to instantiate WebElements
		// Important interview question
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor)driver;
	}
	
	@FindBy(xpath = "//img//parent::a//parent::nav")
	WebElement logo;
	
	@FindBy(xpath = "//a[text()='Login']")
	WebElement loginFromToolbar;
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement email;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(css = "input.btn.btn-lg.px-5")
	WebElement loginButton;
	
	@FindBy(xpath = "//span[text()='Automation']")
	WebElement automation;
	
	@FindBy(partialLinkText = "Enroll")
	WebElement enrollNow;

	@FindBy(xpath = "//input[@name='f_name']")
	WebElement fName;
	
@FindBy(xpath="//input[@id='id_m_name']")	
WebElement middleName;
	
@FindBy(xpath = "//input[@id='id_l_name']")
WebElement lName;

@FindBy(xpath = "//select[@id='id_i_am']")
	WebElement iAm;
//@FindBy(xpath = "//select[@id='id_course_wish_to_enroll']")
//WebElement  course;
//
//@FindBy(xpath = "//select[@id='id_course_wish_to_enroll']/option")
//WebElement setOfCourse;
@FindBy(xpath = "//select[@id='id_birth_month']")
WebElement birthMonth;

@FindBy(xpath = "//select[@id='id_highest_education']")
WebElement education;

@FindBy(xpath = "//select[@id='id_highest_education']/option")
List<WebElement> setOfEducation;
	public void clickLogo() {
		logo.click();
		pause(4000);
	}
	
	// We used throws to handle exception in this method
	public void enrollNow() {
		elementDisplayed(loginFromToolbar);
		//clickElement(loginFromToolbar);
		js.executeScript("arguments[0].click()", loginFromToolbar);
		pause(4000);
		elementDisplayed(email);
		inputText(email, "7572maria@gmail.com");
		elementDisplayed(password);
		inputText(password, "@#STM2024@#");
		elementEnabled(loginButton);
		//verifyTextOfTheWebElement(loginButton, "Log In");
		clickElement(loginButton);
		pause(4000);
		elementDisplayed(automation);
		clickElement(automation);	
		pause(4000);
		elementEnabled(enrollNow);
		verifyTextOfTheWebElement(enrollNow, "Enroll Now");
		clickElement(enrollNow);
		pause(4000);
		Set<String> allWindowHandles =  driver.getWindowHandles();
		// Extract Parent and child window from all window handles
		String parent = (String)allWindowHandles.toArray()[0];
		String child = (String)allWindowHandles.toArray()[1];
		driver.switchTo().window(child);
		pause(4000);
		fName.sendKeys("Maria");
		pause(4000);
		middleName.sendKeys("Akter");
		pause(3000);
		lName.sendKeys("Saimum");
	}
	public void clickLName() {
		pause(4000);
		elementDisplayed(loginFromToolbar);
		clickElement(loginFromToolbar);
		pause(4000);
		elementDisplayed(email);
		inputText(email, "7572maria@gmail.com");
		pause(2000);
		inputText(password, "@#STM2024@#");
		pause(2000);
		elementEnabled(loginButton);
		clickElement(loginButton);
		pause(4000);
		elementDisplayed(automation);
		clickElement(automation);
		pause(3000);
		elementEnabled(enrollNow);
		clickElement(enrollNow);
		Set<String> allWindowHandles=driver.getWindowHandles();
		String parent= (String)allWindowHandles.toArray()[0];
		String child= (String)allWindowHandles.toArray()[1];
		driver.switchTo().window(child);
		pause(4000);
		fName.sendKeys("Maria");
		pause(4000);
		middleName.sendKeys("Akter");
		pause(3000);
		lName.sendKeys("Saimum");
		Select select =new Select(iAm);
		select.selectByVisibleText("Unemployed");
			pause(4000);
			
	WebElement co=	driver.findElement(By.xpath("//select[@id='id_course_wish_to_enroll']"));
List<WebElement> cos = driver.findElements(By.xpath("//select[@id='id_course_wish_to_enroll']/option"));
		Select  select1=new Select(co);
		for (int i=1;i<cos.size();i++) {
			System.out.println(cos.get(i));
			}
		Select select2=new Select(birthMonth)	;
		select2.selectByVisibleText("January");
		pause(4000);
		
		selectElelementFromDropdownOnebyOne(education, setOfEducation);
		selectDropdown(education, "Graduate");
		pause(4000);
	}
	
	
	

	
	

}
