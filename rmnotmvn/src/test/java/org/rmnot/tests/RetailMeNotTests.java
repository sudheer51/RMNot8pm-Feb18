package org.rmnot.tests;
import org.rmnot.pages.GiftCardsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utility.BaseClass;
public class RetailMeNotTests extends BaseClass{
	GiftCardsPage giftPage;
	
	//Writing tests for Retail Me Not Tests Application
	@Test
	public void validateSearchForAmazonStore()
	{
		giftPage= new GiftCardsPage(driver);
		String storeName = "amazon";
		driver.get(url);
		String actual = giftPage.searchForAStore(storeName);
		String expected = storeName;
		Assert.assertTrue(expected.equalsIgnoreCase(actual));
	}
	@Test
	public void validateSearchForEbayStore()
	{
		giftPage= new GiftCardsPage(driver);
		String storeName = "ebay";
		driver.get(url);
		String actual = giftPage.searchForAStore(storeName);
		String expected = storeName;
		Assert.assertTrue(expected.equalsIgnoreCase(actual));
	}
	@Test
	public void validate10PercentDiscItems()
	{
		giftPage= new GiftCardsPage(driver);
		int expected =10;
		driver.get(url);
		boolean result = giftPage.checkDiscountedItems(expected);
		Assert.assertTrue(result);
	}
}
