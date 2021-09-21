package LearnMaven.Sample;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Waits {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abinp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.guru99.com/selenium-tutorial.html");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("hi");
		System.out.println(cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Waited for 10 sec.");

		System.out.println(driver.getTitle());
		String acttitle=driver.getTitle();
		String title = "Selenium Tutorial for Beginners: Learn WebDriver in 7 Days";
		boolean verify=driver.getTitle().equalsIgnoreCase(title);
		assertTrue(acttitle, verify);
		System.out.println();
		WebElement ele=driver.findElement(By.xpath("//*[contains(text(),'Home')]"));
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
		System.out.println(String.valueOf(ele));
	}

}
