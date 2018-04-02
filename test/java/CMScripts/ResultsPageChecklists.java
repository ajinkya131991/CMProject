package CMScripts;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CMTestBase.CommonMethods;
import CMTestBase.TestBaseCM;
import CMTestBase.ResultPageMethods;

public class ResultsPageChecklists extends TestBaseCM 
{
	ResultPageMethods Results;
	CommonMethods common;
	
	@BeforeClass
	public void setUp() throws InterruptedException 
	{
	  Resultpageinit();
	  Thread.sleep(5000);     
	}
	
	@Test(priority=0)
	public void TC001_IdentityoftehUnit() throws InterruptedException 
	{
		Reporter.log(" ");
	    System.out.println("TESTING BELOW CHECKLIST FOR URL : --> " +driver.getCurrentUrl());
	    Reporter.log("TESTING BELOW CHECKLIST FOR URL : --> " +driver.getCurrentUrl());
	    Results = new ResultPageMethods(driver);
	    common = new CommonMethods(driver);
	    common.Identify();
	}
	
	@Test
	public void TC002_CheckingCode() throws InterruptedException 
	{
		Results.checkingcodeCM();
	}
	
	@Test
	public void TC003_ConsoleErrors()
	{
		common.ConsoleErrors();
	}
	
	/*@Test(priority=2)
	public void TC003_Screenshots() throws IOException
	{
		ThankyouMethod.Screenshots();
	}
	
	@Test(priority=3)
	public void TC004_Sv7Sv9Checks() throws IOException, InterruptedException
	{
		ThankyouMethod.Sv7Sv9Checks();
	}
	
	@Test(priority=4)
	public void TC005_ImageURLCheck() throws IOException, InterruptedException
	{
		ThankyouMethod.imageURLcheck();
	}
	
	@Test(priority=5)
	public void TC005_ValidatingBrokenLinks() throws IOException, InterruptedException
	{
		ThankyouMethod.brokenLinks();
	}
	
	@Test(priority=6)
	public void TC006_VerifyFooterLinks() throws IOException, InterruptedException
	{
		ThankyouMethod.FooterLinks();
	}
	
	@Test(priority=7)
	public void TC007_CheckPrefixSlashForFooters() throws IOException, InterruptedException
	{
		ThankyouMethod.CheckPrefixSlashForFooters();
	}*/

	@AfterClass
	public void close()
	{
		closeBrowser();
	}
		
}
