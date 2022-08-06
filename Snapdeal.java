package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://snapdeal.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		//mouse hover mens fashion
		WebElement drag = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		Actions mouse =new Actions(driver);
		mouse.moveToElement(drag).perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		//count of shoes
		String str = driver.findElement(By.xpath("(//div[@class='child-cat-count '])[1] ")).getText();
		System.out.println("Total items : "+str);
		//Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Popularity')]")).click();
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		Thread.sleep(4000);
		//verify the  prices are sorted
		List<WebElement> l = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		System.out.println('\n'+"Sorted Price");
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i).getText());
		}
		//Set price range(900 to 1200)
		driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
		driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("900");
		driver.findElement(By.xpath("//input[@name='toVal']")).clear();
		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1200");
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		//mouse hover on first result
		WebElement drag2 = driver.findElement(By.xpath("//p[text()='TUFF 5005 SPRINT 01 Red Training Shoes']"));
		Actions builder =new Actions(driver);
		builder.moveToElement(drag2).perform();
		//Print cost and discount
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		Thread.sleep(2000);
		System.out.println('\n'+"Cost : "+driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText());
		System.out.println("Discount : "+driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText());
		//Snapshot of shoes
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File("I:\\Eclipse\\snapshots\\snap03.png"));
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
		Thread.sleep(4000);
	}
}
