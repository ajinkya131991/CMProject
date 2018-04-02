package CMScripts;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Reporter;

import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;

public class CheckCodeWorking {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		String url="https://cm-gallery.reports.mn/template/framework/preview.php?frm_id=800060707&pagename=results-full.html&isiframe";
		//String url="https://cm-gallery.reports.mn/template/framework/preview.php?frm_id=800059892&pagename=results-full.html";
		
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("LoginForAdmin");
		driver = new FirefoxDriver(myprofile);
	    driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(9000);
		
        int width = driver.manage().window().getSize().getWidth();
        Thread.sleep(2000);
        int height = driver.manage().window().getSize().getHeight();
        Thread.sleep(2000);
        
        for(int i= width; i>=320 ; i-- )
        {
        	Dimension d = new Dimension(i,height);
        	driver.manage().window().setSize(d);        	
        	JavascriptExecutor javascript = (JavascriptExecutor) driver;
    	    Boolean horzscrollStatus = (Boolean) javascript.executeScript
    	    		("return document.documentElement.scrollWidth>document.documentElement.clientWidth;");
        	
        	if(horzscrollStatus == false)
        	{
        		//do nothing
        	}
        	else
        	{
        		System.out.println("Horizontal Scroll Present at resolution : " +d);
        		Reporter.log("Horizontal Scroll Present at resolution : " +d);
        	}
        }
        
        driver.manage().window().maximize();
        
        
        
        //assertTrue(jsErrors.toString(), jsErrors.isEmpty());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
