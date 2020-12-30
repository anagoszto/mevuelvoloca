package Prueba_java_testng.mevuelvoloca;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Pagina {
	
	WebDriver driver;
	
	@FindBy(id="DocumentNumber")
	WebElement inputDni;
	
	@FindBy(id="UserName")
	WebElement inputUserName;
	
	@FindBy(id="Password")
	WebElement inputPwd;
	
	@FindBy(id="submitButton")
	WebElement btnLogin;
	
	@FindBy(xpath="//label[contains(.,'Recordar DNI y Usuario')]")
	WebElement ckRmb;
	
	@FindBy(linkText="OLVIDÉ O BLOQUEÉ MIS CLAVES")
	WebElement chgUsr;
	
	@FindBy(linkText="CREÁ TUS CLAVES")
	WebElement chkss;
			
	public Pagina(WebDriver driver) {
		 this.driver = driver;
		 
		 //Inicializa los elementos con una espera implicita
		 PageFactory.initElements(new AjaxElementLocatorFactory (driver, 20), this);
	}	
	
	public void setDocumentNumber(String doc) {
		inputDni.sendKeys(doc);
	}
	
	public void setUserName(String userName) {
		inputUserName.sendKeys(userName);
	}
	
	public void setPassword(String pwd) {
		inputPwd.sendKeys(pwd);
	}
	
	public void checkRememberMe() {
		ckRmb.click();
	}
	
	public void clickBtnLogin() {
		btnLogin.click();
	}
	
	public void clickChngUsr() {
		chgUsr.click();
	}
	
	public void clickCrtKees() {
	chkss.click();
	}
}
