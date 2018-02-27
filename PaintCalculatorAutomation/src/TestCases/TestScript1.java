package TestCases;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestScript1 {

	protected static WebDriver webDriver;
	protected static long wait = 500;
	// Entering the total number of rooms can be changed here
	protected static String noOfRooms = "2";
	protected static String result;
	Map<String, Integer> dimensions=new HashMap<>();

	@BeforeClass

	public void setup() {

		// As instructed in the ReadMe, this path has to be changed to the local
		// path of the executer, which will be inside the project downloaded
		// path
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Anjita\\paint-calculator\\PaintCalculatorAutomation\\chromedriver.exe");

		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();

	}

	/**
	 * This test case validates the HomePage
	 */
	@Test(priority = 1)
	void homePageValidation() {

		webDriver.get("http://127.0.0.1:5000/");

		JavascriptExecutor js = (JavascriptExecutor) webDriver;

		// Validating the headings and highlighting it
		Assert.assertTrue(
				webDriver.findElement(By.xpath("//h1[contains(text(),'Calculating Paint Required')]")).isDisplayed());
		js.executeScript("arguments[0].style.border='4px solid black'",
				webDriver.findElement(By.xpath("//h1[contains(text(),'Calculating Paint Required')]")));

		// Validating the second heading and highlighting it
		Assert.assertEquals(webDriver.findElement(By.cssSelector(".lead")).getText(), "Enter the number of rooms");
		js.executeScript("arguments[0].style.border='4px solid black'", webDriver.findElement(By.cssSelector(".lead")));

		// Footer validation
		Assert.assertTrue(webDriver
				.findElement(
						By.xpath("//p[contains(text(),'1 gallon of paint is required for every 400ft of surface.')]"))
				.isDisplayed());
		Assert.assertTrue(webDriver.findElement(By.xpath("/html/body/footer/p[2]")).isDisplayed());
		Assert.assertEquals(webDriver.findElement(By.xpath("//p[@class='text-center']/code")).getText(),
				"((Length * 2) + (Width * 2)) * Height");
		js.executeScript("arguments[0].style.border='4px solid black'",
				webDriver.findElement(By.xpath("//p[@class='text-center']/code")));

		Assert.assertTrue(webDriver.findElement(By.xpath("/html/body/footer/p[3]")).isDisplayed());
		// This wait has been added to delay the execution to see the progress
		// of automation in this case(this is ideally not necessary)
		try {
			Thread.sleep(wait);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String noOfRooms = "2";
		webDriver.findElement(By.name("rooms")).sendKeys(noOfRooms);
		webDriver.findElement(By.xpath("//input[@type='submit']")).click();

		// The following was a trial to validate the error message, since the
		// error validations are inbuilt form html 5 validations in this case,
		// it is tricky to obtain them using java and selenium, however using
		// Rspec with selenium can still do it

		// String errorMessage=webDriver.switchTo().activeElement().getText();
		// System.out.println(errorMessage);
		//
		//
		// if(Integer.parseInt(noOfRooms)<1){
		//// List<String> inputs=new ArrayList<String>();
		//// list.add("0")
		//
		// Assert.assertEquals(errorMessage,"Value must be greater than or equal
		// to 1.","Not a valid error message");
		// }else if(Integer.parseInt(noOfRooms)>1){
		// System.out.println("Page Navigated Successfully");
		// }
		// else{
		// //String errorMessage=webDriver.switchTo().alert().getText();
		// System.out.println(errorMessage);
		// Assert.assertEquals(errorMessage,"Please enter a number.","Not a
		// valid error message");
		// }

	}

	/**
	 * This method validates the dimensions page
	 */
	@Test(priority = 2)
	void dimensionsPageVlidation() {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		// This wait has been added to delay the execution to see the progress
		// of automation in this case(this is ideally not necessary)

		try {
			Thread.sleep(wait);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// All headers and Text validation and highlighting for visibility of
		// validation
		Assert.assertTrue(
				webDriver.findElement(By.xpath("//h1[contains(text(),'Calculating Paint Required')]")).isDisplayed());
		js.executeScript("arguments[0].style.border='4px solid black'",
				webDriver.findElement(By.xpath("//h1[contains(text(),'Calculating Paint Required')]")));

		Assert.assertTrue(webDriver.findElement(By.xpath("//th[contains(text(),'Room Number')]")).isDisplayed());
		js.executeScript("arguments[0].style.border='4px solid black'",
				webDriver.findElement(By.xpath("//th[contains(text(),'Room Number')]")));
		Assert.assertTrue(webDriver.findElement(By.xpath("//th[contains(text(),'Length')]")).isDisplayed());
		js.executeScript("arguments[0].style.border='4px solid black'",
				webDriver.findElement(By.xpath("//th[contains(text(),'Length')]")));
		Assert.assertTrue(webDriver.findElement(By.xpath("//th[contains(text(),'Width')]")).isDisplayed());
		js.executeScript("arguments[0].style.border='4px solid black'",
				webDriver.findElement(By.xpath("//th[contains(text(),'Width')]")));
		Assert.assertTrue(webDriver.findElement(By.xpath("//th[contains(text(),'Height')]")).isDisplayed());
		js.executeScript("arguments[0].style.border='4px solid black'",
				webDriver.findElement(By.xpath("//th[contains(text(),'Height')]")));

		// Footer validation
		Assert.assertTrue(webDriver
				.findElement(
						By.xpath("//p[contains(text(),'1 gallon of paint is required for every 400ft of surface.')]"))
				.isDisplayed());
		Assert.assertTrue(webDriver.findElement(By.xpath("/html/body/footer/p[2]")).isDisplayed());
		Assert.assertEquals(webDriver.findElement(By.xpath("//p[@class='text-center']/code")).getText(),
				"((Length * 2) + (Width * 2)) * Height");
		js.executeScript("arguments[0].style.border='4px solid black'",
				webDriver.findElement(By.xpath("//p[@class='text-center']/code")));

		Assert.assertTrue(webDriver.findElement(By.xpath("/html/body/footer/p[3]")).isDisplayed());

		// Checking if the number of rows match the total rooms entered.
		List<WebElement> rows = webDriver.findElements(By.xpath("/html/body/div/form/table/tbody/tr"));
		System.out.println(rows.size());
		Assert.assertEquals((Integer.parseInt(noOfRooms) + 1), rows.size(),
				"Total number of rooms doest not match the number entered");
		//entering the dimensions
		webDriver.findElement(By.name("length-0")).sendKeys("22");
		webDriver.findElement(By.name("width-0")).sendKeys("25");
		webDriver.findElement(By.name("height-0")).sendKeys("18");
		webDriver.findElement(By.name("length-1")).sendKeys("30");
		webDriver.findElement(By.name("width-1")).sendKeys("30");
		webDriver.findElement(By.name("height-1")).sendKeys("20");

		dimensions.put("length-1", 22);
		dimensions.put("width-1", 25);
		dimensions.put("height-1", 18);
		dimensions.put("length-2", 30);
		dimensions.put("width-2", 30);
		dimensions.put("height-2", 20);
		
		webDriver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	@Test(priority = 3)
	void resultsValidation() {

		JavascriptExecutor js1 = (JavascriptExecutor) webDriver;
		// This wait has been added to delay the execution to see the progress
		// of automation in this case(this is ideally not necessary)

		try {
			Thread.sleep(wait);
		} catch (Exception e) {

		}
		// Validating the headings and highlighting it

		Assert.assertTrue(
				webDriver.findElement(By.xpath("//h1[contains(text(),'Calculating Paint Required')]")).isDisplayed());
		js1.executeScript("arguments[0].style.border='4px solid black'",
				webDriver.findElement(By.xpath("//h1[contains(text(),'Calculating Paint Required')]")));
		//
		Assert.assertTrue(webDriver.findElement(By.xpath("/html/body/div/table/tbody/tr[1]/th[1]")).isDisplayed());
		js1.executeScript("arguments[0].style.border='4px solid black'",
				webDriver.findElement(By.xpath("/html/body/div/table/tbody/tr[1]/th[1]")));
		Assert.assertTrue(webDriver.findElement(By.xpath("/html/body/div/table/tbody/tr[1]/th[2]")).isDisplayed());
		js1.executeScript("arguments[0].style.border='4px solid black'",
				webDriver.findElement(By.xpath("/html/body/div/table/tbody/tr[1]/th[2]")));
		Assert.assertTrue(webDriver.findElement(By.xpath("/html/body/div/table/tbody/tr[1]/th[3]")).isDisplayed());
		js1.executeScript("arguments[0].style.border='4px solid black'",
				webDriver.findElement(By.xpath("/html/body/div/table/tbody/tr[1]/th[3]")));
		
		//Footer validation
		Assert.assertTrue(webDriver
				.findElement(
						By.xpath("//p[contains(text(),'1 gallon of paint is required for every 400ft of surface.')]"))
				.isDisplayed());
		Assert.assertTrue(webDriver.findElement(By.xpath("/html/body/footer/p[2]")).isDisplayed());
		Assert.assertEquals(webDriver.findElement(By.xpath("//p[@class='text-center']/code")).getText(),
				"((Length * 2) + (Width * 2)) * Height");
		js1.executeScript("arguments[0].style.border='4px solid black'",
				webDriver.findElement(By.xpath("//p[@class='text-center']/code")));

		Assert.assertTrue(webDriver.findElement(By.xpath("/html/body/footer/p[3]")).isDisplayed());
		
		//Checking if the total rows match the dimensions entered

		List<WebElement> rows = webDriver.findElements(By.xpath("/html/body/div/table/tbody/tr"));
		System.out.println(rows.size());
		Assert.assertEquals((Integer.parseInt(noOfRooms) + 1), rows.size(),
				"Total number of rooms displayed doest not match the number entered in the HomePage.");

		//FormulaValidation
		Assert.assertTrue(webDriver.findElement(By.xpath("/html/body/div/h5")).isDisplayed());
		js1.executeScript("arguments[0].style.border='4px solid black'",
				webDriver.findElement(By.xpath("/html/body/div/h5")));
		String totalGallons=webDriver.findElement(By.xpath("/html/body/div/h5")).getText();
		
		String surfaceAreaToPaint=webDriver.findElement(By.xpath("//p[@class='text-center']/code")).getText();
		System.out.println("Total Surface Area To Paint Formula"+surfaceAreaToPaint);
		String roomOne=webDriver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[2]")).getText();
		System.out.println("AmountOfFeet for Room1 :"+roomOne);
		String gallonRoom1=webDriver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[3]")).getText();
		System.out.println("Gallon for Room1 :"+gallonRoom1);
		
		String roomTwo=webDriver.findElement(By.xpath("/html/body/div/table/tbody/tr[3]/td[2]")).getText();
		System.out.println("AmountOfFeet for Room2 :"+roomTwo);
		String gallonRoom2=webDriver.findElement(By.xpath("/html/body/div/table/tbody/tr[3]/td[3]")).getText();
		System.out.println("Gallon for Room1 :"+gallonRoom2);
		int gallonsrequiredOne=0;
		int gallonsrequiredTwo=0;
		int length=0;
		int width=0;

		int height=0;

		if(!dimensions.isEmpty()){
			for(int i=1;i<=Integer.parseInt(noOfRooms);i++){
				if(dimensions.containsKey("length-"+i)){
				 length=dimensions.get("length-"+i);
				System.out.println("Length of Room"+i +":"+length);
				}
				if(dimensions.containsKey("width-"+i)){
				 width=dimensions.get("width-"+i);
				System.out.println("Width of Room"+i +":"+width);
				}
				if(dimensions.containsKey("height-"+i)){
				 height=dimensions.get("height-"+i);
				System.out.println("Height of Room"+i +":"+height);
				}
				int expectedAmoutOfFeat=((length * 2) + (width * 2)) * height;
				System.out.println(expectedAmoutOfFeat);
				int gallonsrequired=expectedAmoutOfFeat/400;
				if(i==1){
					 gallonsrequiredOne=expectedAmoutOfFeat/400;

				Assert.assertEquals(Integer.parseInt(roomOne), expectedAmoutOfFeat, "Acual Displayed Feet of Paint DoesNot Match the expected value for Room"+i);
				Assert.assertEquals(Integer.parseInt(gallonRoom1), gallonsrequired, "Acual Displayed gallon of Paint DoesNot Match the expected valuefor Room"+i);

				}else{
					 gallonsrequiredTwo=expectedAmoutOfFeat/400;

					Assert.assertEquals(Integer.parseInt(roomTwo), expectedAmoutOfFeat, "Acual Displayed Feet of Paint DoesNot Match the expected value for Room"+i);
					Assert.assertEquals(Integer.parseInt(gallonRoom2), gallonsrequired, "Acual Displayed gallon of Paint DoesNot Match the expected valuefor Room"+i);
				}
				
				
					
			}
			Assert.assertEquals(Integer.parseInt(totalGallons), (gallonsrequiredOne+gallonsrequiredTwo), "Total Displayed gallon of Paint DoesNot Match the expected value");
		}
		
		

	}

	 @AfterClass	
	 public static void teardown() {		 
		 //Navigating to HomeButton before closing the browser.
		 		 try {
				Thread.sleep(wait);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 
			webDriver.findElement(By.xpath("//input[@type='submit']")).click();
//Closing the browser marking the end of the test,
	 webDriver.close();
	
	 webDriver.quit();
	
	 }
}
