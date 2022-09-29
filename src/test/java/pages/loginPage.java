package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {
	WebDriver driver;
	By userName=By.id("txtUsername");
	By pswd= By.id("txtPassword");
	By loginBtn=By.xpath("//div//button");
	public loginPage(WebDriver driver) {
		this.driver= driver;
		System.out.println(driver.getTitle());	
	}
	
	public dashboardPage login(String user, String pass) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(userName)));
		driver.findElement(userName).sendKeys(user);
		driver.findElement(pswd).sendKeys(pass);
		driver.findElement(loginBtn).click();
		Thread.sleep(3000);
		return new dashboardPage(driver);
	}
}
