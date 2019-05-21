package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.PropertiesReader;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

	private static PropertiesReader prop = new PropertiesReader();

	private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

	public static ChromeDriver getDriver() {
		if (webDriverThreadLocal.get() != null) {
			return (ChromeDriver) webDriverThreadLocal.get();
		}
		System.setProperty(prop.getPropValues("driverName"), prop.getPropValues("driverPath"));
		WebDriver instance = new ChromeDriver() {
			{
				manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
				get(prop.getPropValues("url"));
			}
		};
		webDriverThreadLocal.set(instance);
		return (ChromeDriver) webDriverThreadLocal.get();
	}

	public static void quit() {
		webDriverThreadLocal.get().quit();
		webDriverThreadLocal.set(null);
	}

	/*public static WebDriver driver = null;
	private static PropertiesReader prop = new PropertiesReader();

	static {
		System.setProperty(prop.getPropValues("driverName"), prop.getPropValues("driverPath"));
		//System.setProperty(prop.getDriverName(), src/main/resources/chromedriver.exe);
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			driver = setUp();
		}
		return driver;
	}

	public static WebDriver setUp() {
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		chromeDriver.get(prop.getPropValues("url"));
		//chromeDriver.get(prop.getUrl());

		return chromeDriver;
	}
	public static void quit(){
		driver.quit();
	}*/
}
