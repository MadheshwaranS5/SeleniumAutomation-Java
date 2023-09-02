package eCommerce;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddItems {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Downloads\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		int j=0;
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String [] names = {"Brocolli", "Cucumber", "Beetroot"};
		
		Thread.sleep(2000);
		
		List<WebElement> vegetables = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<vegetables.size();i++) {
			String[] neededItem = vegetables.get(i).getText().split("-");
			String itemsNeeded = neededItem[0].trim();
			
			List veggies = Arrays.asList(names);
			
			if(veggies.contains(itemsNeeded)){
				j++;
                driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
//				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(); ----> This is thread method
//				Thread.sleep(5000);
				/*
				 * Here we are use to steps to avoid miss locating one is using thread.sleep until it's get's normal.
				 * But not static locators it's not good method to write the code so we can select the locator in different method.
				 */
				if(j==names.length) {
					break;
				}
			}
		}
		
	}

}
