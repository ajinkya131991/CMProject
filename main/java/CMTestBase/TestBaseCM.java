package CMTestBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Reporter;



public class TestBaseCM {
	
	public WebDriver driver;
	
	public void Resultpageinit() throws InterruptedException 
	{
		String url="https://cm-gallery.reports.mn/template/framework/preview.php?frm_id=800060707&pagename=results-full.html&isiframe";
		//String url="https://cm-gallery.reports.mn/template/framework/preview.php?frm_id=800059892&pagename=results-full.html";
		
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("LoginForAdmin");
		driver = new FirefoxDriver(myprofile);
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(5000);				
	}
	

	
	public void Imagizerinit() throws InterruptedException     // For Browsers
	{
		String url="https://cm.reports.mn/template/framework/preview.php?frm_id=800060642&pagename=keywords-only-1012x200.html";
		//String url="https://www.msn.com/en-in/";
		
		//For Firefox
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\jars\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		//driver = new FirefoxDriver();
		
		//For Chrome
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/jars/chromedriver/chromedriver.exe");
	    driver = new ChromeDriver();
	    
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(5000);
	}		
	
	public void closeBrowser()
	{
		driver.close();
		driver.quit();
	}
	
	

	/*public static void main(String[] args) throws InterruptedException 
	{
		TestBaseDLA test = new TestBaseDLA();
		//test.init();

	}*/

}
