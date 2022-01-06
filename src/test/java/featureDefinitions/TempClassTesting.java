package featureDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TempClassTesting {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmad\\Documents\\Automation Testing Program\\Phase 2\\ChromeDriver ver 97\\chromedriver_win32 97version\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		// ---------------------------------------app
		// launch-----------------------------

		driver.get("https://www.swiggy.com/");
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		WebElement findfoodButtonElement = driver
				.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/a/span"));

		WebElement searchlocationElement = driver.findElement(By.id("location"));
		searchlocationElement.sendKeys("110017");

		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		WebElement FindFoodButton = driver
				.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/a/span"));
		// FindFoodButton.click();
		// driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
//				List<WebElement> searchresultsElements = driver.findElements(By.xpath("//div[@class='_1oLDb']//div/descendant::span[@class='_2W-T9']"));
//				System.out.println(searchresultsElements.size());
//				searchresultsElements.get(1).click();

		// ----------------------------------Product
		// page------------------------------------------------------------------------------

		try {
			// driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			List<WebElement> searchresultsElements = driver
					.findElements(By.xpath("//div[@class='_1oLDb']//div/descendant::span[@class='_2W-T9']"));
			System.out.println("List of locations: " + searchresultsElements.size());
			searchresultsElements.get(1).click();

			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			WebElement swiggyloggoElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div/div/a"));

			WebElement cartlogoElement = driver
					.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div/div/ul/li[1]/div/div/div/a/span[2]"));
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

			if (swiggyloggoElement.isDisplayed() && cartlogoElement.isDisplayed()) {
				System.out.println("Your have sucessfully landed on the Product page");

			}
			// return true;
		} catch (TimeoutException e) {
			System.out.println("ERROR: Timeout. Not able to access Shopping Cart");
			// return false;
		} catch (Throwable e) {
			// other potential error
			System.out.println("ERROR: Not able to access Shopping Cart");
			// return false;
		}

		// ----------------------------------Add product to cart
		// ------------------------------------------------------------------------------

		// driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		List<WebElement> findResturantlistElement;
		List<WebElement> sideOptionalitemstoselectElements = null;
		WebElement selectingItemtoEatWebElement = null;
		WebDriverWait wait = new WebDriverWait(driver, 5);

		if (driver.findElements(By.xpath("//div[@class='MZy1T']//div/descendant::*[@href]")).size() >=0) {
			// System.out.println("We are in If");
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
			findResturantlistElement = driver.findElements(By.xpath("//div[@class='MZy1T']//div/descendant::*[@href]"));
		}
		else {
			findResturantlistElement = driver.findElements(By.xpath("//div[@class='MZy1T']//div/descendant::*[@href]"));
			// System.out.println("We are in Else");
		}

		System.out.println("List of Resturants: " + findResturantlistElement.size());

		// selecting a random restaurant
		findResturantlistElement.get(3).click();



		if (driver.findElement(By.xpath("//div/descendant::div[@class='_1RPOp']")).isDisplayed()) {
			selectingItemtoEatWebElement = driver.findElement(By.xpath("//div/descendant::div[@class='_1RPOp']"));

		} else if (driver.findElement(By.xpath("//div[@class='_2wg_t']//div/descendant::div[@class='_1RPOp']")).isDisplayed()) {
			// div[@class='_2wg_t']//div/descendant::div[@class='_1RPOp']
			selectingItemtoEatWebElement = driver.findElement(By.xpath("//div[@class='_2wg_t']//div/descendant::div[@class='_1RPOp']"));

		} else if (driver.findElement(By.xpath("//div[@id='h-1847531872']//div/descendant::div[@class='_1RPOp']")).isDisplayed()) {
			selectingItemtoEatWebElement = driver.findElement(By.xpath("//div[@id='h-1847531872']//div/descendant::div[@class='_1RPOp']"));
		}

	else if (driver.findElement(By.xpath("//div[@id='h-1847531872']//div/descendant::div[@class='_2wg_t']")).isDisplayed()) {
		selectingItemtoEatWebElement = driver.findElement(By.xpath("//div[@id='h-1847531872']//div/descendant::div[@class='_2wg_t']"));
	}

		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		//Clicking Rain Alert
		
		if (driver.findElements(By.xpath("//*[@id='root']/div[2]/div/div/div[3]")).size() != 0 ) {
			    driver.findElement(By.xpath("//*[@id='root']/div[2]/div/div/div[3]")).click();
			 }
		selectingItemtoEatWebElement.click();

		// To check if the selected item from the selected restaurant is deliverable.
		if (driver.findElements(By.xpath("//*[@id='root']/div[2]/div/div/div[2]/div[2]")).size() != 0) {
			//*[@id="root"]/div[2]/div/div
			System.out.println("The Selected Restaurant doesnt deliver to your location");
		}

		//Capturing additional demand charges, alert.
		System.out.println("You are at the Demand high, condition");

		if (driver.findElements(By.xpath("//div[@id='root']//div/descendant::div[@class='_1zVBl']")).size() != 0) {
			driver.findElement(By.xpath("//div[@id='root']//div/descendant::div[@class='_1zVBl']")).click();
										
			System.out.println("Demand is currently high");
		}


		System.out.println("Selecting an item");

//


//		//looking for optional items to select if available.
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
//
		if (driver.findElements(By.xpath("//label[@class='_3MtuI']//div/descendant::label[@class='b5XpK']")).size() > 0)
		{

			sideOptionalitemstoselectElements = driver
					.findElements(By.xpath("//label[@class='_3MtuI']//div/descendant::label[@class='b5XpK']"));
			System.out.println("optional items: " + sideOptionalitemstoselectElements.size());
			// Adding items to the cart.
			sideOptionalitemstoselectElements.get(0).click();

			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
			driver.findElement(By.xpath("//*[@id='modal-placeholder']//div/descendant::span[@class='_38xdN']")).click();

		} 

//		if (driver.findElements(By.xpath("//div[@class='_1J_la']//div/descendant::div[@class='_2wg_t']")).size() >= 0) {
//			driver.findElement(By.xpath("//div[@class='_1J_la']//div/descendant::div[@class='_2wg_t']")).click();
//
//		}
//		
		if (driver.findElements(By.xpath("//*[@id='modal-placeholder']/div[2]/div/div[2]/div/div[3]/div[2]/span[2]")).size() >=0) {
			driver.findElement(By.xpath("//*[@id='modal-placeholder']/div[2]/div/div[2]/div/div[3]/div[2]/span[2]")).click();

		}
		else if(driver.findElements(By.xpath("//*[@id='modal-placeholder']//div/descendant::span[@class='_38xdN']")).size() >=0) {
			driver.findElement(By.xpath("//*[@id='modal-placeholder']//div/descendant::span[@class='_38xdN']")).click();
		}
		else if (driver.findElements(By.xpath("//*[@id='modal-placeholder']/div[3]/div/div[2]/div/div[3]/div[2]")).size() >=0) {

			driver.findElement(By.xpath("//*[@id='modal-placeholder']/div[3]/div/div[2]/div/div[3]/div[2]")).click();
		}
		else if (driver.findElements(By.xpath("//*[@id='modal-placeholder']/div[2]/div/div[2]/div/div[3]/div[3]/span[2]")).size() >=0) {

			driver.findElement(By.xpath("//*[@id='modal-placeholder']/div[2]/div/div[2]/div/div[3]/div[3]/span[2]")).click();
		}

		
		else if (driver.findElements(By.xpath("//div[@id='modal-placeholder']//div/descendant::span[@class='_38xdN']")).size() >=0) {

			driver.findElement(By.xpath("//div[@id='modal-placeholder']//div/descendant::span[@class='_38xdN']")).click();
		}
		else if (driver.findElements(By.xpath("//*[@id='modal-placeholder']/div[3]/div/div[2]/div/div[3]/div[2]/span[2]")).size() >=0) {

			driver.findElement(By.xpath("//*[@id='modal-placeholder']/div[3]/div/div[2]/div/div[3]/div[2]/span[2]")).click();
		}
		
		
//		else if ((driver.findElements(By.xpath("//label[@class='_3MtuI']//div/descendant::label[@class='b5XpK']")).size() > 0) &&
//			(driver.findElements(By.xpath("//*[@id='modal-placeholder']/div[3]/div/div[2]/div/div[3]/div[2]/span[2]")).size()>0 )) {
			                               //*[@id="modal-placeholder"]/div[2]/div/div[2]/div/div[3]/div[2]/span[2]
			//*[@id="modal-placeholder"]/div[2]/div/div[2]/div/div[3]/div[2]/span[2]
//		}
//			sideOptionalitemstoselectElements = driver
//					.findElements(By.xpath("//label[@class='_3MtuI']//div/descendant::label[@class='b5XpK']"));
//			System.out.println("optional items: " + sideOptionalitemstoselectElements.size());
////Adding items to the cart.
//			sideOptionalitemstoselectElements.get(0).click();
//
//			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
//			driver.findElement(By.xpath("//*[@id='modal-placeholder']/div[3]/div/div[2]/div/div[3]/div[2]/span[2]")).click();
//
//		}

		// --------------------Check Cart---------------
		WebElement cartWebElement = null;
		cartWebElement = driver.findElement(By.xpath("//span[@class='_2vS77']"));
		//System.out.println(cartWebElement.getAttribute("value").toString());
		String cartValue;
		cartValue = driver.findElement(By.xpath("//span[@class='_2vS77']")).getText();

		System.out.println("Cart Value: " + cartValue);

		// else if
		// (driver.findElement(By.xpath("//*[@id=\"modal-placeholder\"]/div[2]/div/div[2]/div/div[3]/div[3]/span[2]")).isDisplayed()
		// == false) {
//					//Adding items to the cart.
//					driver.findElement(By.xpath("//*[@id=\"modal-placeholder\"]/div[2]/div/div[2]/div/div[3]/div[3]/span[2]")).click();
//				}

	}

}
