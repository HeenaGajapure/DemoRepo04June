package com.testBase;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;




import io.github.bonigarcia.wdm.WebDriverManager;

	public class TestBase {
		
		
		public static WebDriver driver;
		public static Logger logger;
		
		
		
		@BeforeSuite
		public void test1()
		{
			
		}
		
		@BeforeClass
		public void start()
		{
			logger = Logger.getLogger("dalal Street Framework");
			PropertyConfigurator.configure("Log4j.properties");
			
			logger.info("Framework execution started");
		}
		
		@AfterClass
		public void stop()
		{
			logger.info("Framework execution finished");
		}
		
		@Parameters("browser")
		
		@BeforeMethod
		public void setUp(String br )
		{
	
			
			if(br.equalsIgnoreCase("Chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(br.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else if(br.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			else
			{
				System.out.println("Please provide correct browser");
			}
				
			driver.get("https://www.apps.dalalstreet.ai/login");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
			
			
		}
		
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
		

	}



