package IndiaFarmerPortal;

import java.io.FileWriter;
import java.io.PrintWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import zmq.socket.pubsub.Dist;

public class farmerGovFinalone {
	public void readdataNeg(int noOfrows,WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		for (int j=2;j<=noOfrows;j++) {
			try {
				
				WebElement Slno=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[1]"));
				System.err.println("Slno:- "+Slno.getText());
				WebElement LicenseId=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[2]"));
				System.out.println("LicenseID:- "+LicenseId.getText());
				WebElement District=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[3]"));
				System.err.println("District:- "+District.getText());
				WebElement Address=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[4]"));
				System.out.println("Address:- "+Address.getText());
			}
			catch(Exception e) {
				try {
					if(j==noOfrows) {
						WebElement prev=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td/table/tbody/tr/td[2]/input"));
						prev.click();
						Thread.sleep(3000);
						int noOfrows1=driver.findElements(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr")).size();
//						System.out.println(noOfrows1);
						if(noOfrows1>0) {
							readdataNeg(noOfrows1,driver);
						}
					}
				}
				catch (Exception e1) {
					if(j==noOfrows) {
//						System.out.println("1");
						WebElement prev=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td/table/tbody/tr/td[2]/input"));
						prev.click();
						Thread.sleep(3000);
//						  System.out.println("2");
						int noOfrows1=driver.findElements(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr")).size();
//						System.out.println(noOfrows1);
						if(noOfrows1>0) {
							readdataNeg(noOfrows1,driver);
						}
					}
				}
			}
			Thread.sleep(1000);
		}
	}
	public void readdata(int noOfrows,WebDriver driver) throws InterruptedException {
		for (int j=2;j<=noOfrows;j++) {
			try {
				
				WebElement Slno=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[1]"));
				System.err.println("Slno:- "+Slno.getText());
				WebElement LicenseId=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[2]"));
				System.out.println("LicenseID:- "+LicenseId.getText());
				WebElement District=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[3]"));
				System.err.println("District:- "+District.getText());
				WebElement Address=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[4]"));
				System.out.println("Address:- "+Address.getText());
			}
			catch(Exception e) {
				try {
					if(j==noOfrows) {
						WebElement next=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td/table/tbody/tr/td[3]/input"));
						next.click();
						int noOfrows1=driver.findElements(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr")).size();
						System.out.println(noOfrows1);
						if(noOfrows1>0) {
							readdata(noOfrows1,driver);
						}
					}
				}
				catch (Exception e1) {
					if(j==noOfrows) {
						WebElement next=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td/table/tbody/tr/td[1]/input"));
						next.click();
						int noOfrows1=driver.findElements(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr")).size();
						System.out.println(noOfrows1);
						if(noOfrows1>0) {
							readdata(noOfrows1,driver);
						}
					}
				}
			}
			Thread.sleep(1000);
		}
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		WebElement last=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr[53]/td/table/tbody/tr/td[4]/input"));
		last.click();
		farmerGovFinalone obj=new farmerGovFinalone();
		obj.readdataNeg(noOfrows, driver);
	}
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions chromebrowser=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(chromebrowser);
		driver.manage().window().maximize();
		driver.get("https://farmer.gov.in/");
		int waitfor=3000;
		Thread.sleep(waitfor);
		WebElement input=driver.findElement(By.xpath("//*[@id=\"accordion-2\"]/li[1]/a"));
		input.click();
		Thread.sleep(waitfor);
		WebElement fertilizer=driver.findElement(By.xpath("//*[@id=\"accordion-2\"]/li[1]/ul/li[2]/a"));
		fertilizer.click();
		Thread.sleep(waitfor);
		WebElement dealers=driver.findElement(By.xpath("//*[@id=\"ctl00_LB_Fertiliser_Dealers\"]"));
		dealers.click();
		Thread.sleep(waitfor);
		Select stateDD=new Select(driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_DropDownListState\"]")));
		stateDD.selectByVisibleText("MAHARASHTRA");
		Thread.sleep(waitfor);
		int listOfBlocks=driver.findElements(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr")).size();
		System.out.println(listOfBlocks);
//						Total number of invalid Dealers.
		for (int i=15;i<listOfBlocks;i++) {
//						WebElement last=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr[53]/td/table/tbody/tr/td[2]"));
			WebElement TotalNumberOfInvalidDealers=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+i+"]/td[4]/a"));
			TotalNumberOfInvalidDealers.click();
			Thread.sleep(waitfor);
			Select LicenseDD=new Select(driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_DropDownListDealerStatus\"]")));
			LicenseDD.selectByVisibleText("All");
			Thread.sleep(waitfor);
			int noOfrows=driver.findElements(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr")).size();
			farmerGovFinalone obj=new farmerGovFinalone();
			obj.readdata(noOfrows,driver);
			driver.navigate().back();
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(3000);
		}

	}

}
