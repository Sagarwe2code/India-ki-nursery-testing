package trailPage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream; 
import java.io.PrintWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import IndiaFarmerPortal.farmerGovFinalone;
import io.github.bonigarcia.wdm.WebDriverManager;
import zmq.socket.reqrep.Dealer;

public class WriteDataToExcel {
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		ChromeOptions chromebrowser=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(chromebrowser);
		driver.manage().window().maximize();
		driver.get("https://farmer.gov.in/");
		int waitfor=3000,number=2;;
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
		for (int i=2;i<listOfBlocks;i++) {
			//			WebElement last=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr[53]/td/table/tbody/tr/td[2]"));
			WebElement TotalNumberOfInvalidDealers=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+i+"]/td[4]/a"));
			TotalNumberOfInvalidDealers.click();
			Thread.sleep(waitfor);
			Select LicenseDD=new Select(driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_DropDownListDealerStatus\"]")));
			LicenseDD.selectByVisibleText("All");
			Thread.sleep(waitfor);

			int noOfrows=driver.findElements(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr")).size();
			FileOutputStream fout=new FileOutputStream("D:\\Farmer Fertilizer list.csv");
			PrintStream pout=new PrintStream(fout);
			pout.println("Serial No,License number,License Date,District Name,Block Name,Dealer Name,Location,Contact Number");
			WriteDataToExcel obj=new WriteDataToExcel();
			obj.readdata(noOfrows,driver,pout,number);
			//			driver.navigate().back();
			//			Thread.sleep(2000);
			//			driver.navigate().refresh();
			//			Thread.sleep(3000);
		}
	}
	public void readdata(int noOfrows,WebDriver driver,PrintStream pout,int number) throws InterruptedException {
		for (int j=2;j<=noOfrows;j++) {
			try {
				if(j<10) {
					WebElement Slno=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[1]"));
					String sl=Slno.getText();
					//				System.err.println("Slno:- "+Slno.getText());
					WebElement LicenseId=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[2]"));
					WebElement License=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl0"+j+"_lbl_Lid\"]"));
					String lNo=License.getText();
					WebElement LicenseDate=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl0"+j+"_LabelValidity_license\"]"));
					String LDate=LicenseDate.getText();
					//				System.out.println("LicenseID:- "+LicenseId.getText());
					WebElement District=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[3]"));
					WebElement Dist=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl02_LabelDistrictName\"]"));
					String Dis=Dist.getText();
					WebElement BlockName=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl0"+j+"_LabelBlockNM\"]"));
					String BN=BlockName.getText();
					//				System.err.println("District:- "+District.getText());
					WebElement Address1=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[4]"));
					WebElement DealerName=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl0"+j+"_LabelDealerName\"]"));
					String DelName=DealerName.getText().replace(',', ' ');
					WebElement location=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl0"+j+"_LabelAddress\"]"));
					String loct=location.getText().replace(',', ' ');
					WebElement phoneno=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl0"+j+"_LabelMobile\"]"));
					String ph_no=phoneno.getText();
					//				System.out.println("Address:- "+Address.getText());
					if(number==j) {
						pout.println(sl+","+lNo+","+LDate+","+Dis+","+BN+","+DelName+","+loct+","+ph_no);
					}
				}
				else if(j<=(noOfrows-2)) {
					WebElement Slno=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[1]"));
					String sl=Slno.getText();
					//				System.err.println("Slno:- "+Slno.getText());
					WebElement LicenseId=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[2]"));
					WebElement License=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl"+j+"_lbl_Lid\"]"));
					String lNo=License.getText();
					WebElement LicenseDate=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl"+j+"_LabelValidity_license\"]"));
					String LDate=LicenseDate.getText();
					//				System.out.println("LicenseID:- "+LicenseId.getText());
					WebElement District=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[3]"));
					WebElement Dist=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl"+j+"_LabelDistrictName\"]"));
					String Dis=Dist.getText();
					WebElement BlockName=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl"+j+"_LabelBlockNM\"]"));
					String BN=BlockName.getText();
					//				System.err.println("District:- "+District.getText());
					WebElement Address=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[4]"));
					WebElement DealerName=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl"+j+"_LabelDealerName\"]"));
					String DelName=DealerName.getText().replace(',', ' ');
					WebElement location=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl"+j+"_LabelAddress\"]"));
					String loct=location.getText().replace(',', ' ');
					WebElement phoneno=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl"+j+"_LabelMobile\"]"));
					String ph_no=phoneno.getText();
					//				System.out.println("Address:- "+Address.getText());
					if(number==j) {
						pout.println(sl+","+lNo+","+LDate+","+Dis+","+BN+","+DelName+","+loct+","+ph_no);
					}
				}
			}
			catch(Exception e) {
				//				try {
				//					System.out.println("jjdlj");
				//					if(j==noOfrows) {
				//						WebElement next=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td/table/tbody/tr/td[3]/input"));
				//						next.click();
				//						int noOfrows1=driver.findElements(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr")).size();
				//						System.out.println(noOfrows1);
				//						if(noOfrows1>0) {
				//							readdata(noOfrows1,driver,pout,number);
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
				//							readdata(noOfrows1,driver,pout,number);
				//						}
				//					}
				//				}
			}
			//			number++;
			try {
				if(j==noOfrows) {
					WebElement next=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td/table/tbody/tr/td[3]/input"));
					next.click();
					int noOfrows1=driver.findElements(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr")).size();
					//					System.out.println(noOfrows1);
					if(noOfrows1>0) {
						readdata(noOfrows1,driver,pout,number);
					}

					if(j<10) {
						WebElement Slno=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[1]"));
						String sl=Slno.getText();
						//				System.err.println("Slno:- "+Slno.getText());
						WebElement LicenseId=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[2]"));
						WebElement License=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl0"+j+"_lbl_Lid\"]"));
						String lNo=License.getText();
						WebElement LicenseDate=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl0"+j+"_LabelValidity_license\"]"));
						String LDate=LicenseDate.getText();
						//				System.out.println("LicenseID:- "+LicenseId.getText());
						WebElement District=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[3]"));
						WebElement Dist=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl02_LabelDistrictName\"]"));
						String Dis=Dist.getText();
						WebElement BlockName=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl0"+j+"_LabelBlockNM\"]"));
						String BN=BlockName.getText();
						//				System.err.println("District:- "+District.getText());
						WebElement Address1=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[4]"));
						WebElement DealerName=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl0"+j+"_LabelDealerName\"]"));
						String DelName=DealerName.getText().replace(',', ' ');
						WebElement location=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl0"+j+"_LabelAddress\"]"));
						String loct=location.getText().replace(',', ' ');
						WebElement phoneno=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl0"+j+"_LabelMobile\"]"));
						String ph_no=phoneno.getText();
						//				System.out.println("Address:- "+Address.getText());
						if(number==j) {
							pout.println(sl+","+lNo+","+LDate+","+Dis+","+BN+","+DelName+","+loct+","+ph_no);
						}
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
						readdata(noOfrows1,driver,pout,number);
					}
				}
			}
			number++;
		}
		//		
		//		driver.navigate().back();
		//		Thread.sleep(2000);
		//		driver.navigate().refresh();
		//		Thread.sleep(3000);
		//		WebElement last=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr[53]/td/table/tbody/tr/td[4]/input"));
		//		last.click();
		//		farmerGovFinalone obj=new farmerGovFinalone();
		//		obj.readdataNeg(noOfrows, driver);
	}
	//	public void readdataNeg(int noOfrows,WebDriver driver,PrintStream pout) throws InterruptedException {
	//		Thread.sleep(3000);
	//		int number=2;
	//		for (int j=2;j<=noOfrows;j++) {
	//			try {
	//				if(j<10) {
	//				WebElement Slno=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[1]"));
	//				String sl=Slno.getText();
	//				//				System.err.println("Slno:- "+Slno.getText());
	//				WebElement LicenseId=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[2]"));
	//				WebElement License=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl02_lbl_Lid\"]"));
	//				String lNo=License.getText();
	//				WebElement LicenseDate=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl02_LabelValidity_license\"]"));
	//				String LDate=LicenseDate.getText();
	//				//				System.out.println("LicenseID:- "+LicenseId.getText());
	//				WebElement District=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[3]"));
	//				WebElement Dist=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl02_LabelDistrictName\"]"));
	//				String Dis=Dist.getText();
	//				WebElement BlockName=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl02_LabelBlockNM\"]"));
	//				String BN=BlockName.getText();
	//				//				System.err.println("District:- "+District.getText());
	//				WebElement Address=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[4]"));
	//				WebElement DealerName=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl02_LabelDealerName\"]"));
	//				String DelName=DealerName.getText();
	//				WebElement location=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl02_LabelAddress\"]"));
	//				String loct=location.getText();
	//				WebElement phoneno=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl02_LabelMobile\"]"));
	//				String ph_no=phoneno.getText();
	//				//				System.out.println("Address:- "+Address.getText());
	//				if(number==j) {
	//				pout.println(sl+","+lNo+","+LDate+","+Dis+","+BN+","+DelName+","+loct+","+ph_no+"\n");
	//				}
	//				}
	//				else if(j<noOfrows) {
	//					WebElement Slno=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[1]"));
	//					String sl=Slno.getText();
	//					//				System.err.println("Slno:- "+Slno.getText());
	//					WebElement LicenseId=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[2]"));
	//					WebElement License=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl02_lbl_Lid\"]"));
	//					String lNo=License.getText();
	//					WebElement LicenseDate=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl02_LabelValidity_license\"]"));
	//					String LDate=LicenseDate.getText();
	//					//				System.out.println("LicenseID:- "+LicenseId.getText());
	//					WebElement District=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[3]"));
	//					WebElement Dist=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl02_LabelDistrictName\"]"));
	//					String Dis=Dist.getText();
	//					WebElement BlockName=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl02_LabelBlockNM\"]"));
	//					String BN=BlockName.getText();
	//					//				System.err.println("District:- "+District.getText());
	//					WebElement Address=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td[4]"));
	//					WebElement DealerName=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl02_LabelDealerName\"]"));
	//					String DelName=DealerName.getText();
	//					WebElement location=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl02_LabelAddress\"]"));
	//					String loct=location.getText();
	//					WebElement phoneno=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved_ctl02_LabelMobile\"]"));
	//					String ph_no=phoneno.getText();
	//					//				System.out.println("Address:- "+Address.getText());
	//					if(number==j) {
	//					pout.println(sl+","+lNo+","+LDate+","+Dis+","+BN+","+DelName+","+loct+","+ph_no+"\n");
	//					}
	//					}
	//			}
	//			catch(Exception e) {
	//				try {
	//					if(j==noOfrows) {
	//						WebElement prev=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr[40]/td/table/tbody/tr/td[2]/input"));
	//						prev.click();
	//						int noOfrows1=driver.findElements(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr")).size();
	//						//						System.out.println(noOfrows1);
	//						if(noOfrows1>0) {
	//							readdataNeg(noOfrows1,driver,pout);
	//						}
	//					}
	//				}
	//				catch (Exception e1) {
	//					if(j==noOfrows) {
	//						WebElement prev=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr["+j+"]/td/table/tbody/tr/td[2]/input"));
	//						prev.click();
	//						int noOfrows1=driver.findElements(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewApproved\"]/tbody/tr")).size();
	//						//						System.out.println(noOfrows1);
	//						if(noOfrows1>0) {
	//							readdataNeg(noOfrows1,driver,pout);
	//						}
	//					}
	//				}
	//			}
	////			pout.println(sl+","+lNo+","+LDate+","+Dis+","+BN+","+DelName+","+loct+","+ph_no);
	//			number++;
	//			if (j==noOfrows) {
	//				break;
	//			}
	//		}
	//	}
}
