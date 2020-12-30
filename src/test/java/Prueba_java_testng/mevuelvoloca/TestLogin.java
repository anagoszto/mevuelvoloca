package Prueba_java_testng.mevuelvoloca;


import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin {
	//private static final boolean True = false;
	String url = "https://onlinebanking.bancogalicia.com.ar/login";
	WebDriver driver;
	String driverPath = "C:\\Users\\Luisa\\eclipse-workspace\\mevuelvoloca\\Drivers\\chromedriver.exe";
	
	String pgCrtAcc = "https://onlinebanking.bancogalicia.com.ar/gestion/ingresar-du";
	String suDni = "23432432";
	String userName = "hasdgf";
	String suPwd = "12345678";
	
	
	@BeforeSuite
	public void beforeSuite() {		
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	public void antes() {
		System.out.println("Inicio Prueba");
	}
	
	@BeforeMethod
	public void setup() {		
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void verifyChangeUser() {		
		Pagina login = new Pagina(driver);
		login.clickChngUsr();
		Assert.assertEquals(driver.getCurrentUrl(),pgCrtAcc);
    }
	
	@Test
	public void creaTusClaves() {		
		Pagina login = new Pagina(driver);
		login.clickCrtKees();		
		Assert.assertEquals(driver.getCurrentUrl(),pgCrtAcc);
}
	@Test
	public void loginInvalido() {		
		Pagina login = new Pagina(driver);
		login.setDocumentNumber(suDni);
		login.setUserName(userName);
		login.setPassword(suPwd);
		login.checkRememberMe();
		login.clickBtnLogin();
		Assert.assertEquals(driver.getCurrentUrl(),"https://onlinebanking.bancogalicia.com.ar/error/errorout");
}
	
	@Test(priority=0)
	public void loginValido() {		
		Pagina login = new Pagina(driver);
		login.setDocumentNumber("21882289");
		login.setUserName("anagoszto10");
		login.setPassword("2003");
		login.checkRememberMe();
		login.clickBtnLogin();
		Assert.assertEquals(driver.getCurrentUrl(),"https://onlinebanking.bancogalicia.com.ar/inicio");
}
	
	@AfterMethod
	public void cerrarBrowser() {		
		driver.close();
	}
	
	@AfterTest()
	public void testPrint() {
		System.out.println("Fin Test");
	}
	
	
	@AfterClass
	public void finPrueba() {
		System.out.println("Fin Prueba");
	}
	
		
	public void finSuite() {
		System.out.println("Fin Suite");
	}
}
