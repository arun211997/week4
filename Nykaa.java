package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//mouse hover brands
		  WebElement drag = driver.findElement(By.xpath("//a[text()='brands']"));
		  Actions mouse = new Actions(driver);
		  mouse.moveToElement(drag).perform();
		  driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("LOreal Paris");
		  Thread.sleep(2000);
		  //click on l'oreal 
		  driver.findElement(By.xpath("(//div[@class='css-ov2o3v'])[1]/a")).click();
		  System.out.println(driver.getTitle());
		  driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click(); 
		  driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		  driver.findElement(By.xpath("//span[text()='Category']")).click();
		  //choose haircare shampoo
		  driver.findElement(By.xpath("//span[text()='Hair']")).click();
		  driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		  driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		  driver.findElement(By.xpath("//span[text()='Concern']")).click();
		  String str = driver.findElement(By.xpath("//span[text()='Shampoo']")).getText();
		  System.out.println(str);
		  driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		  driver.findElement(By.xpath("//div[@class='css-xrzmfa']")).click();
		  //switch to second window
		  Set<String> windowhandles = driver.getWindowHandles();
		  List<String> listwindows = new ArrayList<String>(windowhandles);
		  String sw = listwindows.get(1);
		  driver.switchTo().window(sw);
		  Select s = new Select(driver.findElement(By.xpath("//select[@title='SIZE']")));
		  s.selectByIndex(1);
		  //get the price
		  String str2 = driver.findElement(By.xpath("//span[text()='₹189']")).getText();
		  System.out.println("MRP : "+str2);
		  //add to bag
		  driver.findElement(By.xpath("//button[@class=' css-12z4fj0']")).click();
		  Thread.sleep(3000);
		  //switch to frame (cart)
		  driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		  driver.switchTo().frame(0);
		  String str4 =driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText().replaceAll("₹","");
		  int i  = Integer.parseInt(str4);
		  System.out.println("Grand total : "+i);
		  driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']")).click();  
		  driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		  //checking the price
		  String str3 =driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText().replaceAll("₹","");
		  int j = Integer.parseInt(str3);
		  System.out.println("Grand total : "+j);
		  if(i==j) {
			  System.out.println("price is same");
		  Thread.sleep(4000);
		  //close all windows
		  driver.quit();
		  }
		  
	}

}
