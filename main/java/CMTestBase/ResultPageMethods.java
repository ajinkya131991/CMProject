package CMTestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class ResultPageMethods 
{
	WebDriver driver;	
	SoftAssert softasserts = new SoftAssert();
	
	public ResultPageMethods(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);  //this - refers current class objects
	}

	
	public void checkingcodeCM()
	{
		System.out.println(" ********** Validating Texts to be present or not be present in a source code ********** ");
		Reporter.log(" ********** Validating Texts to be present or not be present in a source code ********** ");	
		Reporter.log(" ");
		
		String stored_report = driver.getPageSource();	
		String[] beincode = {"viewport"," formatViewAfterLoad()"};	                     //// Please add texts to this list 
		String[] notbeincode = {"woff2","trans.png","DetectText()","EmulateIE7","AdChoices.png","AdChoice.png","ad_choice_v4.png",".ads"};    //// Please add texts to this list 
    		   
    	for(String check:beincode)
    		{
    			boolean Present = stored_report.contains(check);	        	
    			if(Present == false)
    			{
    	    		softasserts.assertTrue(Present);
    				System.out.println(check+ " --> Text need to be present in the code");
    				Reporter.log(check+ " --> Text need to be present in the code");
    			}
    		}
    
    	for(String check2:notbeincode)
    		{
    			boolean NeedtoPresent = !stored_report.contains(check2);	   			
    			if(NeedtoPresent == false)
    			{
    				softasserts.assertTrue(NeedtoPresent);
    				System.out.println(check2+ " --> Text should not be present in the code");
    				Reporter.log(check2+ " --> Text need to be present in the code");
    			}
    		}    
    	softasserts.assertAll();
		Reporter.log(" "); 
	}
	
	
	
	
	
	
	
	
	
}	
