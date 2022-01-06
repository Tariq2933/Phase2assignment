package featureDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class AppClass {

    WebDriver driver;
    //WebDriver wait = new WebDriver(driver, 10);

	public  void applaunch() {

		driver.get("https://www.swiggy.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		validatePinCode("110025");
	}

	public void validatePinCode(String PinorLocation) {

		WebElement findfoodButtonElement = driver
				.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/a/span"));
		if (findfoodButtonElement.isDisplayed()) {
			WebElement searchlocationElement = driver.findElement(By.id("location"));
			searchlocationElement.sendKeys(PinorLocation);
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			List<WebElement> searchresultsElements = driver
					.findElements(By.xpath("//div[@class='_1oLDb']//div/descendant::span[@class='_2W-T9']"));
			System.out.println("Print items in the list :" + searchresultsElements.size());
			String tempString = "New Delhi, Delhi 110025, India";

			for (WebElement searchresultsElement : searchresultsElements) {
				System.out.println(searchresultsElement.getText());
				if (searchresultsElement.getText().contains(tempString)) {
					{
						searchresultsElement.click();
					}
				}

			}
		}

	}

}
