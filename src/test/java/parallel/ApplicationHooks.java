package parallel;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfiReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/*Hooks are responsible to launch the browsers
 * 
 */

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfiReader configreader;
	Properties prop;
	
	@Before(value= "@Skip",order = 0) //@Skip
	public void skip_scenario(Scenario scenario) {
		System.out.println("Skipped Scenario is : "+scenario.getName());
		Assume.assumeTrue(false);
	}
	
	@Before(order = 1)
	public void getPropert() {
		configreader = new ConfiReader();
		prop = configreader.init_prop();
		
	}
	
	@Before(order = 2)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			// take screenshot:
			
		String	ScreenshotName = scenario.getName().replaceAll(" ", "_");
		byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);	
		scenario.attach(sourcePath, "image/png", ScreenshotName);
		
		}
	}
	

}
