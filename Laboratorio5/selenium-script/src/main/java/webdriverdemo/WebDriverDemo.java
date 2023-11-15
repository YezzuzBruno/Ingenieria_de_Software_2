package webdriverdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import org.junit.*;
import static org.junit.Assert.*;

public class WebDriverDemo {
	WebDriver driver;
	@Before
	public void setUp() throws Exception{
		driver = new ChromeDriver();
		//Puts an Implicit wait, Will wait for 10 seconds before throwing exception
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	      //Launch website
	      driver.navigate().to("http://www.calculator.net/");
	      
	      //Maximize the browser
	      driver.manage().window().maximize();
	      
	      // Click on Math Calculators
	      driver.findElement(By.xpath("//*[@id=\"homelistwrap\"]/div[3]/div[2]/a")).click();
	      
	      // Click on Percent Calculators
	      driver.findElement(By.xpath("//*[@id=\"content\"]/table[2]/tbody/tr/td/div[3]/a")).click();
	}
	
	@After
	public void tearDown() throws Exception{
		//Close the Browser.
	    driver.close();
	}
	//VALIDOS----------------------------------------------------------------------------------
	@Test
	public void porcentajeNegativo() {      
	      // Enter value -10 in the first number of the percent Calculator
	      driver.findElement(By.id("cpar1")).sendKeys("-10");
	      
	      // Enter value 100 in the second number of the percent Calculator
	      driver.findElement(By.id("cpar2")).sendKeys("100");
	      
	      // Click Calculate Button
	      driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();

	      
	      // Get the Result Text based on its xpath
	      String result =
	         driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();

	      
	      // Assert actual value and expected value
	      assertEquals(result, "-10");
	      
	}
	
	
	@Test
	public void numeroNegativo() {
	      
	      // Enter value 10 in the first number of the percent Calculator
	      driver.findElement(By.id("cpar1")).sendKeys("10");
	      
	      // Enter value -100 in the second number of the percent Calculator
	      driver.findElement(By.id("cpar2")).sendKeys("-100");
	      
	      // Click Calculate Button
	      driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();

	      
	      // Get the Result Text based on its xpath
	      String result =
	         driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();

	      
	      // Assert actual value and expected value
	      assertEquals(result, "-10");     
	}
	
	@Test
	public void ambosNegativos() {
	      
	      // Enter value -10 in the first number of the percent Calculator
	      driver.findElement(By.id("cpar1")).sendKeys("-10");
	      
	      // Enter value -100 in the second number of the percent Calculator
	      driver.findElement(By.id("cpar2")).sendKeys("-100");
	      
	      // Click Calculate Button
	      driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();

	      
	      // Get the Result Text based on its xpath
	      String result =
	         driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();

	      
	      // Assert actual value and expected value
	      assertEquals(result, "10");     
	}
	
	@Test
	public void ambosPositivos() {
	      
	      // Enter value 10 in the first number of the percent Calculator
	      driver.findElement(By.id("cpar1")).sendKeys("10");
	      
	      // Enter value 50 in the second number of the percent Calculator
	      driver.findElement(By.id("cpar2")).sendKeys("50");
	      
	      // Click Calculate Button
	      driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();

	      
	      // Get the Result Text based on its xpath
	      String result =
	         driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();

	      
	      // Assert actual value and expected value
	      assertEquals(result, "5");     
	}
	
	@Test
	public void porcentajeIgualCero() {
	      
	      // Enter value 0 in the first number of the percent Calculator
	      driver.findElement(By.id("cpar1")).sendKeys("0");
	      
	      // Enter value 50 in the second number of the percent Calculator
	      driver.findElement(By.id("cpar2")).sendKeys("50");
	      
	      // Click Calculate Button
	      driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();

	      
	      // Get the Result Text based on its xpath
	      String result =
	         driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();

	      
	      // Assert actual value and expected value
	      assertEquals(result, "0");     
	}
        //INVALIDO-------------------------------------------------------------------------------
	public void ambosString() {
	      
	      // Enter value 0 in the first number of the percent Calculator
	      driver.findElement(By.id("cpar1")).sendKeys("diez");
	      
	      // Enter value 50 in the second number of the percent Calculator
	      driver.findElement(By.id("cpar2")).sendKeys("cien");
	      
	      // Click Calculate Button
	      driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();

	      
	      // Get the Result Text based on its xpath
	      String result =
	         driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font")).getText();

	      
	      // Assert actual value and expected value
	      assertEquals(result, "Please provide two numeric values in any fields below.");     
	}
	
	
   public static void main(String[] args) {
   	  return;
   }
}
