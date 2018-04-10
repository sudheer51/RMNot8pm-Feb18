package org.utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	protected WebDriver driver;
	protected String url;
	@Parameters({"url","browserType"})
	@BeforeClass
	public void validateJS(String url,String browserType)
	{
		if(browserType.equals("FF"))
		{
			System.out.println("in FF");
			System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
			 
		}
		else if(browserType.equals("CH"))
		{
			System.out.println("in CH");
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			 
		}
		else
		{
			System.out.println("in IE");
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			 
		}
		this.url = url;

	}
	 
}
