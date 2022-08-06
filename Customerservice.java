package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Customerservice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Login
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//button[@title='Learn More']")).click();
		//switch to second window
		Set<String> window =  driver.getWindowHandles();
		List<String> windowhandles = new ArrayList<String>(window);
		String sw = windowhandles.get(1);
		driver.switchTo().window(sw);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		//Customer services
		Shadow sha1=new Shadow(driver);
		WebElement ele1=sha1.findElementByXPath("//span[text()='Products']");
		ele1.click();
		Shadow sha2=new Shadow(driver);
		//mouse hover
		WebElement ele2=sha2.findElementByXPath("//span[text()='Service']");
		Actions drag = new Actions(driver);
		Thread.sleep(4000);
		drag.moveToElement(ele2).perform();
		Shadow sha3=new Shadow(driver);
		WebElement ele3=sha3.findElementByXPath("//a[text()='Customer Service']");
		ele3.click();
		//get services 
		List<WebElement> l = driver.findElements(By.className("header-text"));
		System.out.println('\n'+"CUSTOMER SERVICES");
		 for(int i=3;i<12;i++)
		 {
			 System.out.println(i-2+"."+l.get(i).getText());
		 }
		 
		 boolean str =driver.getTitle().contains("Customer Service Tools from Service Cloud - Salesforce.com");
		 
		 if(str) {
		
           System.out.println('\n'+"Title Verified:");
		 }
	}

}
