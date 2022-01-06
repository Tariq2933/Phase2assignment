package featureDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Scenario scenario;
	public static boolean ScrenShotFlag; // default enable ScreenShot after each step

	// Before hook === Setup the Chrome Webdriver

	@Before
	public static void setup() {

		//Using Third party dependency to avoid chrome version mistach issue
		//WebDriverManager.chromedriver().setup();
		// System.setProperty("webdriver.chrome.driver",// "C:\\Users\\ahmad\\Documents\\Automation Testing Program\\Phase
		// 2\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		ScrenShotFlag = true;

	}


public static void applaunch() {

		driver.get("https://www.swiggy.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		//validatePinCode("110025");
	}



	/*
	 * AfterStep hook === We can perform screen capture, tweaked by the ssFlag from
	 * each step methods, default to true (enable)
	 */
	@AfterStep
	public void afterStep(Scenario scenario) {

		System.out.println("DEBUG: afterStep: ScrenShotFlag " + BaseClass.ScrenShotFlag);

		if (BaseClass.ScrenShotFlag) {
			scenario.log("Add Screenshot");
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");
		} else {
			BaseClass.ScrenShotFlag = true; // toggle back to enable
		}
	}

	/*
	 * Common method
	 *
	 */
	public static void accessShoppingCart() {

		WebDriverWait wait = new WebDriverWait(driver, 5);

		// Navigate to the Shopping Cart
		String sCartIconXpath = "//a[@class='shopping_cart_link']";
		driver.findElement(By.xpath(sCartIconXpath)).click();
		System.out.println("INFO: Navigated to Shopping Cart page.");

		// Verify landed at Shopping Cart Page
		try {
			String weCartTitleXPath = "//span[@class='title']";
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(weCartTitleXPath)));

			assertEquals(driver.findElement(By.xpath(weCartTitleXPath)).getText(), "YOUR CART");
			System.out.print("INFO: Landed at Shopping cart page");

		} catch (TimeoutException e) {
			System.out.println("ERROR: Timeout. Not able to access Shopping Cart");
		} catch (Throwable e) {
			// other potential error
			System.out.println("ERROR: Not able to access Shopping Cart");
		}

	}

	// Method for validating location.

	public static void validatePinCode(String PinorLocation) {

		WebElement findfoodButtonElement = driver
				.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/a/span"));
		if (findfoodButtonElement.isDisplayed()) {

			WebElement searchlocationElement = driver.findElement(By.id("location"));
			searchlocationElement.sendKeys("PinorLocation");

			WebElement FindFoodButton = driver
					.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/a/span"));
			FindFoodButton.click();

			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			List<WebElement> searchresultsElements = driver
					.findElements(By.xpath("//div[@class='_1oLDb']//div/descendant::span[@class='_2W-T9']"));

			if (searchresultsElements.size() == 0) {
				System.out.println("Sorry! We don't serve at your location currently");
				driver.quit();

			}

			else if (searchresultsElements.size() != 0) {

				searchresultsElements.get(1).click();
				if (driver
						.findElement(
								By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div[3]"))
						.isDisplayed()) {
					System.out.println("Sorry! We don't serve at your location currently");
					driver.quit();
				}

			}

		}

	}

	public static  boolean ConfirmProductPage() {

		try {
			/*
			 * driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
			 * List<WebElement> searchresultsElements = driver.findElements(By.xpath(
			 * "//div[@class='_1oLDb']//div/descendant::span[@class='_2W-T9']"));
			 * System.out.println(searchresultsElements.size());
			 * searchresultsElements.get(1).click();
			 */
			WebElement swiggyloggoElement  = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div/div/a"));

			WebElement cartlogoElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div/div/ul/li[1]/div/div/div/a/span[2]"));
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

			if(swiggyloggoElement.isDisplayed() && cartlogoElement.isDisplayed() ) {
				System.out.println("Your have sucessfully landed on the Product page");

			}
			return true;
		}

		catch (TimeoutException e) {
				System.out.println("ERROR: Timeout. Not able to access Shopping Cart");
				 return false;
				 }
		catch (Throwable e ) {
				// other potential error
				System.out.println("ERROR: Not able to access Shopping Cart");
				 return false;
			}


	}






	/*
	 * === After hook === clean up step
	 */
	@After
	public void teardown() throws InterruptedException {

		Thread.sleep(2000);
		driver.quit();

	}

}
