package trailPage;

import java.io.FileWriter;
import java.io.File;  
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;  
import java.io.PrintStream;  

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import IndiaFarmerPortal.farmerGovFinalone;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSheet {
	//	public static void main(String[]args) throws IOException, InterruptedException {
	//		FileOutputStream fout=new FileOutputStream("D:\\testout1.csv ");    
	//		   PrintStream pout=new PrintStream(fout);   
	//		   for (int i=1;i<10;i++) {
	//		   pout.println(i);    
	////		   pout.println("Hello Java");    
	////		   pout.println("Welcome to Java");    
	//		
	//		   }
	//		   pout.close();    
	//		   fout.close(); 
	//		  System.out.println("Success?");    
	//	}
	//        //Data to write on Console using PrintWriter  
	//     PrintWriter writer = new PrintWriter(System.out);    
	//     writer.write("Javatpoint provides tutorials of all technology.");        
	//writer.flush();  
	//     writer.close();  
	////Data to write in File using PrintWriter       
	//     PrintWriter writer1 =null;      
	//        writer1 = new PrintWriter(new File("D:\\testout.csv"));  
	//        writer1.write("Like Java, Spring, Hibernate, Android, PHP etc.");                                                   
	//                        writer1.flush();  
	//        writer1.close(); 
	//		String path;
	//		path ="Farmer gov";
	//		PrintWriter writer = new PrintWriter(new FileWriter(".//" + path + ".csv"));
	////		for (int i=0;i<=10;i++) {
	//		writer.write("Slno,Lisence ID,Address Details");
	//		writer.flush();
	//		writer.close();
	//		writer.write("Slno,Lisence ID,Address Details");
	//		writer.flush();
	//		writer.close();
	//		writer.write("Slno,Lisence ID,Address Details");
	//		writer.flush();
	//		writer.close();
	//		
	//		}
	//		writer.write("Slno,Lisence ID,Address Details");
	//		writer.flush();
	//		writer.close();
	//	}
	//	public void readdata(int noOfrows,WebDriver driver,PrintStream pout,FileOutputStream fout) throws InterruptedException, IOException {
	//		for (int j=2;j<=noOfrows;j++) {
	//			try {
	//				
	//				WebElement Slno=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[1]"));
	//				String s1=Slno.getText();
	////				System.out.println("Slno:- "+Slno.getText());
	////				WebElement LicenseId=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[2]"));
	////				System.out.println("LicenseID:- "+LicenseId.getText());
	////				WebElement District=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[3]"));
	////				System.err.println("District:- "+District.getText());
	////				WebElement Address=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[4]"));
	////				System.out.println("Address:- "+Address.getText());
	//				
	////				pout.close();    
	////				fout.close();
	//			}
	//			catch(Exception e) {
	//				try {
	//					if(j==noOfrows) {
	//						WebElement next=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td/table/tbody/tr/td[3]/input"));
	//						next.click();
	//						int noOfrows1=driver.findElements(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr")).size();
	//						System.out.println(noOfrows1);
	//						if(noOfrows1>0) {
	//							readdata(noOfrows1,driver,pout,fout);
	//						}
	//					}
	//				}
	//				catch (Exception e1) {
	//					if(j==noOfrows) {
	//						WebElement next=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td/table/tbody/tr/td[1]/input"));
	//						next.click();
	//						int noOfrows1=driver.findElements(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr")).size();
	//						System.out.println(noOfrows1);
	//						if(noOfrows1>0) {
	//							readdata(noOfrows1,driver,pout,fout);
	//						}
	//					}
	//				}
	//			}
	////			   
	////			pout.println();    
	////			pout.println("Welcome to Java");    
	//			
	//		}
	//		driver.navigate().back();
	//		Thread.sleep(2000);
	//		driver.navigate().refresh();
	//		Thread.sleep(3000);
	//		WebElement last=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr[53]/td/table/tbody/tr/td[4]/input"));
	//		last.click();
	//		farmerGovFinalone obj=new farmerGovFinalone();
	//		obj.readdataNeg(noOfrows, driver);
	//	}
	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions chromebrowser=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(chromebrowser);
		driver.manage().window().maximize();
		driver.get("https://farmer.gov.in/");
		int waitfor=3000,number=2;
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
		//							Total number of invalid Dealers.
		for (int i=2;i<listOfBlocks;i++) {
			//			WebElement last=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr[53]/td/table/tbody/tr/td[2]"));
			WebElement TotalNumberOfInvalidDealers=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+i+"]/td[4]/a"));
			TotalNumberOfInvalidDealers.click();
			Thread.sleep(waitfor);
			Select LicenseDD=new Select(driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_DropDownListDealerStatus\"]")));
			LicenseDD.selectByVisibleText("All");
			Thread.sleep(waitfor);
			int noOfrows=driver.findElements(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr")).size();
			FileOutputStream fout=new FileOutputStream("D:\\testout.csv ");    
			PrintStream pout=new PrintStream(fout);
			for(int j=2;j<=noOfrows;j++) {
				try {
					if (j<10) {
						WebElement Slno=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[1]"));
						String s1=Slno.getText();
						WebElement LicenseId_date=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[2]"));
						WebElement licenseId=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl0"+j+"_lbl_Lid\"]"));
						String s2=licenseId.getText();
						WebElement Date=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl0"+j+"_LabelValidity_license\"]"));
						String s3=Date.getText();
						if(number==j) {
							pout.println(s1+","+s2+","+s3);
						}
					}

					else if(j<=(noOfrows-2)){
						WebElement Slno=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[1]"));
						String s1=Slno.getText();
						WebElement LicenseId_date=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[2]"));
						WebElement licenseId=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl"+j+"_lbl_Lid\"]"));
						String s2=licenseId.getText();
						WebElement Date=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl"+j+"_LabelValidity_license\"]"));
						String s3=Date.getText();
						if(number==j) {
							pout.println(s1+","+s2+","+s3);
						}
					}
				}

				catch(Exception e) {
				}
				//				System.out.println("LicenseID:- "+LicenseId.getText());
				//				System.out.println("Slno:- "+Slno.getText());
				//				WebElement Address=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[3]"));
				//				String s3=Address.getText();
				number++;
				//				if (j==noOfrows) {
				//					break;
				//				}
			}
			//				farmerGovFinalone obj=new farmerGovFinalone();
			//				obj.readdata(noOfrows,driver);


			//				String path;
			//				path ="Farmer gov";
			//				PrintWriter writer = new PrintWriter(new FileWriter(".//" + path + ".csv"));

			//				driver.navigate().back();
			//				Thread.sleep(2000);
			//				driver.navigate().refresh();
			//				Thread.sleep(3000);
		}
		}
	}