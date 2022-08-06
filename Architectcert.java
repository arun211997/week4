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

public class Architectcert {

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
		//shadow elements
		Shadow sha1=new Shadow(driver);
		WebElement ele1=sha1.findElementByXPath("//span[text()='Learning']");
		ele1.click();
		Shadow sha2=new Shadow(driver);
		WebElement ele2=sha2.findElementByXPath("//span[text()='Learning on Trailhead']");
		Actions mouse = new Actions(driver);
		mouse.moveToElement(ele2).perform();
		Thread.sleep(2000);
		Shadow sha3 =new Shadow(driver);
	    WebElement ele3= sha3.findElementByXPath("//a[text()='Salesforce Certification']");
		Actions context =new Actions(driver);
	    context.doubleClick(ele3).perform();
		Thread.sleep(2000); 
		//Architect summary
		driver.findElement(By.xpath("(//img[@class='roleMenu-item_img'])[2]")).click();
		WebElement p = driver.findElement(By.xpath("//div[@class='cert-site_text slds-text-align--center Lh(1.5) Fz(16px) slds-container--center slds-p-bottom--large']"));
		System.out.println('\n'+"SUMMARY");
		System.out.println(p.getText());
		//Architect certification
		List<WebElement> list = driver.findElements(By.className("credentials-card_title"));
		System.out.println('\n'+"ARCHITECT CERTIFICATIONS");
		Thread.sleep(2000);
		for(int i=0;i<list.size();i++) {
			System.out.println(i+1+"."+list.get(i).getText());
		}
		driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
		List<WebElement> list2 = driver.findElements(By.className("credentials-card_title"));
		System.out.println('\n'+"APPLICATION CERTIFICATIONS");
		Thread.sleep(2000);
		for(int i=0;i<4;i++) {
			System.out.println(i+1+"."+list2.get(i).getText());
		}
		
		
	}

}
