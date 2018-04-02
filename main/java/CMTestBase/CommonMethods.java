package CMTestBase;

import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CommonMethods 
{
	WebDriver driver;	 
	public CommonMethods(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);  //this - refers current class objects
	}
	
	
	
	public void Identify() throws InterruptedException
	{
		System.out.println("****** Identifying the Unit for Type and Size ****** ");
		Reporter.log("******  Identifying the Unit for Type and Size ****** ");
		Reporter.log(" ");
		
	String currentURL = driver.getCurrentUrl();		
	String iframe = "&isiframe";
	String newURL = null;
	if(!currentURL.contains(iframe))
	{
		 newURL = currentURL+iframe;
	}
	else { newURL = currentURL;}				
	driver.get(newURL); 
	
	/////////////////// Unit Type	
	String[] unit = {"keywords-only","ads-only","hybrid","results"};	
	for(int i = 0; i<unit.length ; i++ )
	{
		if(newURL.contains(unit[i]))
		{
		System.out.println("Type of unit is : " +unit[i]+ " page");
		Reporter.log("Type of unit is : " +unit[i]+ " page");
		}
	}
	
	String lastsize = null;	                             //////Getting Size of the Units 
	for(int i = 1; i<=8888 ; i++ )
	{
		for(int j = 1; j<=9999 ; j++ )
		{	
			if(newURL.contains(i+"x"+j))
			{
				lastsize = i+"x"+j;					
			}		
		}
	}
	
	if(!(lastsize==null))
	{			
		System.out.println("Size of unit is : " +lastsize);	
		Reporter.log("Size of unit is : " +lastsize);	
	}
	else 
	{
		System.out.println("Size of unit is : " + " Full screen size");
		Reporter.log("Size of unit is : " + " Full screen size");
	}
	
	String interstitials[] = {"641x481","642x482","249x300"};   /////////////////// Interstitials	
	for(int a=0; a<interstitials.length; a++)
	{
		if(newURL.contains(interstitials[a]))
		{
		System.out.println("Unit identified is : INTERSTITIAL Unit" );
		Reporter.log("Unit identified is : INTERSTITIAL Unit" );
		}
	}	
	
	
	String Dockedunit[] = {"316x50","316x150"};   ////////////////////////////Docked
	
	for(int b=0; b<Dockedunit.length; b++)
	{
		if(newURL.contains(Dockedunit[b]))
		{
			System.out.println("Unit identified is : DOCKED Unit");
			Reporter.log("Unit identified is : DOCKED Unit");
		}					
	}
	
	try {
		if(driver.findElement(By.xpath("//*[contains(@id,'kbb_bgimg_1')]")).isDisplayed());    //////////////////Considering all imagizers uses tag 'kbb_bgimg_1'
		{
			System.out.println("Unit identified is : IMAGIZER Unit");
			Reporter.log("Unit identified is : IMAGIZER Unit");
		}
	} 
	catch (RuntimeException  e) 
	{
		if(e.toString().contains("NoSuchElementException"))
		{
			
		}
	}
	
	
			//............

			// PLEASE find same elements for each type of unit and create logic for the same (Like above code)
			
			//............
	}
	
	
	public void ConsoleErrors()
	{
		System.out.println(" ********** No console errors should be present. ********** ");
		Reporter.log(" ********** No console errors should be present. ********** ");
		
		Logs log = driver.manage().logs();
    	LogEntries entries = log.get(LogType.BROWSER);
    	List<LogEntry> list = entries.getAll();
    	for (int i = 0; i < list.size(); i++) 
    	{
    		LogEntry e = list.get(i);
    		String newlog = e.toString();
		
    		if((e.getLevel().equals(Level.SEVERE)) )	
    		{    			  
    			
    			System.out.println(newlog);
    			Reporter.log(newlog); 
    			Reporter.log(" ");    			
    		}	   		
    	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
