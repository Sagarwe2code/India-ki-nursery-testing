package trailPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class canjobs {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions chromebrowser=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(chromebrowser);
		driver.manage().window().maximize();
		driver.get("http://192.168.29.24:3000/");
		Thread.sleep(3000);
		WebElement admin=driver.findElement(By.xpath("//*[@id=\"mobile-menu\"]/div/ul/li[4]/a"));
		admin.click();
		Thread.sleep(3000);
		WebElement email=driver.findElement(By.xpath("//*[@id=\"email\"]"));
		email.sendKeys("raj@gmail.com");
		WebElement password=driver.findElement(By.xpath("//*[@id=\"password\"]"));
		password.sendKeys("raj@1234");
		WebElement submit=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/form/div[3]/button"));
		submit.click();
		Thread.sleep(3000);
		WebElement managefollowups=driver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[6]/a"));
		managefollowups.click();
		Thread.sleep(3000);
		WebElement response=driver.findElement(By.xpath("//*[@id=\"dashboard-body\"]/div/div/div[2]/div[1]/table/tbody/tr[1]/td[10]/div/button"));
		response.click();
		for (int i=0;i<=100;i++) {
			//			Thread.sleep(4000);

			Thread.sleep(3000);
			WebElement addfollowups=driver.findElement(By.xpath("//*[@id=\"dashboard-body\"]/div/div/div[2]/div[1]/table/tbody/tr[2]/td/div/div/div/div[2]/div/div[1]/table/tbody/tr[1]/th[8]/div/button[1]"));
			addfollowups.click();
			WebElement desc=driver.findElement(By.xpath("//*[@id=\"remark\"]"));
			desc.sendKeys("hell"+i);
			WebElement date=driver.findElement(By.xpath("//*[@id=\"next_followup_date\"]"));
			date.sendKeys("11/02/2012");
			WebElement sub=driver.findElement(By.xpath("/html/body/div[3]/div/div/div/form/div[4]/button"));
			sub.click();

		}
	}

}
