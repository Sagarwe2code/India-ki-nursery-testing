package justdial;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JD1 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions chromeOptions=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get("https://www.justdial.com/Hyderabad/Seed-Retailers/nct-10427237");
		Thread.sleep(1000);
		int i=1,Serialno=1;
		for(;;) {
			System.out.println("count:- "+Serialno);
			if (Serialno==11) {
				WebElement element2=driver.findElement(By.xpath("//*[@id=\"like_dislike_rstlpge\"]/div/div/div[2]/button[1]"));
				System.out.println(element2.getText());
			}
			else {
				Thread.sleep(2000);
			System.out.println("--------------------------------------------------------------------------");
			//						Lets Print the Company name.
			System.out.println("Company Name:- "+driver.findElement(By.xpath("/html/body/div/section/section/div/div[5]/div[1]/div/div[1]/div["+i+"]/div/div/div[2]/h2")).getAttribute("title"));
			//						Lets print the company address.
			WebElement company_Address=driver.findElement(By.xpath("/html/body/div/section/section/div/div[5]/div[1]/div/div[1]/div["+i+"]/div/div/div[2]/div[2]"));
			if (company_Address.getAttribute("class").equals("resultbox_address mt-6")) {
				System.out.println("Company Address:- "+driver.findElement(By.xpath("/html/body/div/section/section/div/div[5]/div[1]/div/div[1]/div["+i+"]/div/div/div[2]/div[2]/div")).getText());
			}
			else {
				System.out.println("Company Address:- "+driver.findElement(By.xpath("/html/body/div/section/section/div/div[5]/div[1]/div/div[1]/div["+i+"]/div/div/div[2]/div[3]/div")).getText());
			}
			//						Lets print the Phone Number.
			try {
				try {
					WebElement ph=driver.findElement(By.xpath("/html/body/div/section/section/div/div[5]/div[1]/div/div[1]/div["+i+"]/div/div/div[2]/div[6]/div[1]/a/div"));
					if (ph.getAttribute("class").equals(" greenfill_animate callbutton font15 fw500 colorFFF callNowAnchor mr-15 ")) {
						{
							System.out.println("Phone number:- "+ph.getText());
						}
					}
				}
				catch (Exception e) {
					WebElement ph=driver.findElement(By.xpath("/html/body/div/section/section/div/div[5]/div[1]/div/div[1]/div["+i+"]/div/div/div[2]/div[7]/div[1]/a/div"));
					if (ph.getAttribute("class").equals(" greenfill_animate callbutton font15 fw500 colorFFF callNowAnchor mr-15 ")) {
						{
							System.out.println("Phone number:- "+ph.getText());
						}
					}
				}
			}
			catch (Exception e) {
				try {
					WebElement ph=driver.findElement(By.xpath("/html/body/div/section/section/div/div[5]/div[1]/div/div[1]/div["+i+"]/div/div/div[2]/div[6]/div[1]/div"));
					if (ph.getAttribute("class").equals(" greenfill_animate callbutton font15 fw500 colorFFF mr-15 ")) {
						System.out.println("Phone number:- "+ph.getText());
					}
				}
				catch(Exception e1){
					try {
						WebElement ph=driver.findElement(By.xpath("/html/body/div/section/section/div/div[5]/div[1]/div/div[1]/div["+i+"]/div/div/div[2]/div[7]/div[1]/a/div"));
						if (ph.getAttribute("class").equals(" greenfill_animate callbutton font15 fw500 colorFFF mr-15 ")) {
							System.out.println("Phone number:- "+ph.getText());
						}
					}
					catch (Exception e2) {
						try {
							WebElement ph=driver.findElement(By.xpath("/html/body/div/section/section/div/div[5]/div[1]/div/div[1]/div["+i+"]/div/div/div[2]/div[7]/div[1]/div"));
							if (ph.getAttribute("class").equals(" greenfill_animate callbutton font15 fw500 colorFFF mr-15 ")) {
								System.out.println("Phone number:- "+ph.getText());
							}
						}
						catch (Exception e3) {
							WebElement ph=driver.findElement(By.xpath("/html/body/div/section/section/div/div[5]/div[1]/div/div[1]/div["+i+"]/div/div/div[2]/div[5]/div/div"));
							if (ph.getAttribute("class").equals(" greenfill_animate callbutton font15 fw500 colorFFF mr-15 ")) {
								System.out.println("Phone number:- "+ph.getText());
							}
						}
					}
				}
			}
			System.out.println("--------------------------------------------------------------------------");
			Thread.sleep(1000);
			}
			Serialno++;
			WebElement scroll=driver.findElement(By.xpath("//*[@id=\"jdresult_box\"]/div[1]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400);", scroll);
//			JavascriptExecutor js=(JavascriptExecutor) driver;
//			WebElement element=driver.findElement(By.xpath("/html/body/div/section/section/div/div[5]/div[1]/div/div[1]/div["+i+"]/div/div"));
//			js.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(3000);
			i++;
		}
	}

}