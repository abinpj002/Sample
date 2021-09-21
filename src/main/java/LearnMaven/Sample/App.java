package LearnMaven.Sample;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;  

/**
 * This program is edited by Abin @07.02 PM on 21-09-2021
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\abinp\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com");
		System.out.println(driver.getTitle());

		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"facebook\"]/body")).click();
		Thread.sleep(10000);
		driver.switchTo().alert().dismiss();
		Set <String>wh=driver.getWindowHandles();
		Iterator<String> it = wh.iterator();
		while(it.hasNext())
		{
			String childwindow=it.next();
			
			driver.switchTo().window(childwindow);
			System.out.println(driver.switchTo().window(childwindow).getCurrentUrl());
		}
    }
}
