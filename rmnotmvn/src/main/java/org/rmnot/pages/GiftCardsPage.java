package org.rmnot.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GiftCardsPage {

	WebDriver driver;
	public GiftCardsPage(WebDriver driver) {
		System.out.println("in Constructor");
		this.driver = driver;
	}

	public String searchForAStore(String storeName)
	{
		driver.findElement(By.xpath(".//*[@id='top']/div/nav/ul/li[3]/a/span")).click();
		driver.findElement(By.cssSelector("input[placeholder='Search by store name']")).sendKeys(storeName);
		String actual = driver.findElement(By.className("catalog-grid-card-name")).getText();
		return actual;
	}
	public boolean checkDiscountedItems(int expected)
	{
		driver.findElement(By.xpath(".//*[@id='top']/div/nav/ul/li[3]/a/span")).click();
		driver.findElement(By.xpath("//li/label[contains(text(),'10%')]")).click();;
		boolean result = true;
		try{
			List<WebElement> itemsList = driver.findElements(By.cssSelector("a>div.catalog-grid-card-discount"));
			 
			for(int i=0;i<itemsList.size();i++)
			{
				int actual = Integer.parseInt(itemsList.get(i).getText().split(" ")[2].replace("%", "").trim());
				if(!(actual>=expected))
				{
					result = false;
					System.out.println("Actual Percent::" + actual);
					System.out.println("Expected Percent::" + expected);
					break;
				}	
			}
		}
		catch(Exception e)
		{
			result = false;
			System.out.println(e.getMessage());
		}
		return result;
	}
}
