package India_ki_nursery;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Customer_application {

	public static void main(String[] args) throws InterruptedException {
		int waiting_time=2000;
		Customer_application obj=new Customer_application();
		obj.login(waiting_time);

	}
	public void login(int waiting_time) throws InterruptedException {
		ChromeOptions chromebrowser=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(chromebrowser);
		driver.manage().window().maximize();
		driver.get("http://indiakinursery.com:3000/login");
		WebElement email=driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/div/div/div/div[2]/div[2]/form/div[1]/input"));
		email.sendKeys("sagar.we2code@gmail.com");
		Thread.sleep(waiting_time);
		WebElement password=driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/div/div/div/div[2]/div[2]/form/div[2]/div/input"));
		password.sendKeys("1234567890");
		Thread.sleep(waiting_time);
		WebElement remember_me=driver.findElement(By.xpath("//*[@id=\"check\"]"));
		remember_me.click();
		Thread.sleep(waiting_time);
		WebElement login=driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/div/div/div/div[2]/div[2]/form/div[4]/button"));
		login.click();
		Thread.sleep(waiting_time);
		Customer_application obj=new Customer_application();
		obj.my_account(driver,waiting_time);
	}
	public void my_account(WebDriver driver,int waiting_time) throws InterruptedException {
		WebElement profile=driver.findElement(By.xpath("//*[@id=\"dropdown-button-drop-down-left\"]"));
		profile.click();
		WebElement my_account=driver.findElement(By.linkText("My Account"));
		my_account.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(waiting_time+3000);
		WebElement edit_profile=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/section/div/div/div/div/div[1]/button"));
		edit_profile.click();
		Thread.sleep(waiting_time);
		WebElement Firstname=driver.findElement(By.xpath("//*[@id=\"main_body\"]/div[3]/div/div/div/form/div[3]/input"));
		Firstname.clear();
		Firstname.sendKeys("Raja");
		Thread.sleep(waiting_time);
		WebElement lastname=driver.findElement(By.xpath("//*[@id=\"main_body\"]/div[3]/div/div/div/form/div[4]/input"));
		lastname.clear();
		lastname.sendKeys("Singh");
		Thread.sleep(waiting_time);
		WebElement Contact=driver.findElement(By.xpath("//*[@id=\"main_body\"]/div[3]/div/div/div/form/div[5]/input"));
		Contact.clear();
		Contact.sendKeys("9945474244");
		Thread.sleep(waiting_time);
		WebElement address=driver.findElement(By.xpath("//*[@id=\"main_body\"]/div[3]/div/div/div/form/div[6]/input"));
		address.clear();
		address.sendKeys("2nd Floor, 45 Universal Tower, P. U. 4, Scheme 54 PU4, Indore, Madhya Pradesh 452001");
		Thread.sleep(waiting_time);
		WebElement email=driver.findElement(By.xpath("//*[@id=\"main_body\"]/div[3]/div/div/div/form/div[8]/input"));
		email.clear();
		email.sendKeys("Sagar.we2code@gmail.com");
		Thread.sleep(waiting_time);
		WebElement pincode=driver.findElement(By.xpath("//*[@id=\"main_body\"]/div[3]/div/div/div/form/div[9]/input"));
		pincode.clear();
		pincode.sendKeys("452002");
		Thread.sleep(waiting_time);
		WebElement city=driver.findElement(By.xpath("//*[@id=\"main_body\"]/div[3]/div/div/div/form/div[10]/input"));
		city.clear();
		city.sendKeys("indore");
		Thread.sleep(waiting_time);
		WebElement saveProfile=driver.findElement(By.xpath("//*[@id=\"main_body\"]/div[3]/div/div/div/form/button"));
		saveProfile.click();
		Thread.sleep(waiting_time);
		js.executeScript("window.scrollBy(0,-500)");
		WebElement home=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/nav[2]/div/div/div/div/ul/li[1]/a"));
		home.click();
		Thread.sleep(waiting_time);
		Customer_application obj=new Customer_application();
		obj.shop(driver,waiting_time);
		//		obj.home(driver,waiting_time);
	}
	//	public void home(WebDriver driver,int waiting_time) throws InterruptedException {
	//		JavascriptExecutor js=(JavascriptExecutor) driver;
	//		js.executeScript("window.scrollBy(0,500)");
	//		Thread.sleep(waiting_time);
	//		WebElement product=driver.findElement(By.xpath("//*[@id=\"trending\"]/div/div[2]/div[1]/div"));
	//		System.out.println("product is present");
	//		Thread.sleep(waiting_time);
	//		WebElement add_to_basket=driver.findElement(By.xpath("//*[@id=\"trending\"]/div/div[2]/div[1]/div/div[2]/button"));
	//		add_to_basket.click();
	//		System.out.println("The product added to cart.");
	//		Thread.sleep(waiting_time+3000);
	//		WebElement cart=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/nav[1]/div/div[3]/div/button/i"));
	//		cart.click();
	//		Thread.sleep(waiting_time);
	//		//		int number_of_product_in_list=driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[1]/nav[1]/div/div[1]/div/ul/a")).size();
	//		//		for (int i=1;i<=number_of_product_in_list;i++) {
	//		//			WebElement product0=driver.findElement(By.xpath("//*[@id=\\\"root\\\"]/div/div[1]/nav[1]/div/div[1]/div/ul/a["+i+"]"));
	//		//			WebElement price=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/nav[1]/div/div[1]/div/ul/a[1]/div/div[2]/div[2]/h6"));
	//		//			System.out.println(price.getText());
	//		//		}
	//		WebElement proceed_to_checkout=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/nav[1]/div/div[1]/div/div[2]/a"));
	//		proceed_to_checkout.click();
	//		Thread.sleep(waiting_time);
	//		js.executeScript("window.scrollBy(0,1000)");
	//		//			js.executeScript("window.scrollBy(500,600)");
	//		//			Thread.sleep(waiting_time);
	//		//			WebElement payment_option=driver.findElement(By.xpath("//*[@id=\"area\"]"));
	//		//			payment_option.click();
	//		//			js.executeScript("window.scrollBy(00)");
	//		//			WebElement term_and_Condition=driver.findElement(By.xpath("//*[@id=\"checkout-check\"]"));
	//		//			term_and_Condition.click();
	//		//			WebElement proceed_to_checkout1=driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/div/div/div[3]/div/div[4]/a"));
	//		//			proceed_to_checkout1.click();
	//		//			Thread.sleep(waiting_time+4000);
	//		//			proceed_to_checkout1.click();
	//	}
	public void shop(WebDriver driver,int waiting_time) throws InterruptedException {
		Thread.sleep(waiting_time);
		WebElement shop=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/nav[2]/div/div/div/div/ul/li[2]/a"));
		shop.click();
		Thread.sleep(waiting_time);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Select showby=new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/section/div/div/div[2]/div[1]/div/div[2]/div[1]/select")));
		List<WebElement>options=showby.getOptions();
		System.out.println(options.size());
		for(WebElement printoption:options) {
			System.out.println(printoption.getText());
		}
		//		System.out.println(showby.getFirstSelectedOption());
	}
}
