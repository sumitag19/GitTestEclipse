package applicationModules;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoItTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		// To disable the extension message coming after launching the Chrome 
		options.addArguments("--disable-extensions");
		// To disable the Chrome being controlled by automated software message coming after launching the Chrome 
		options.addArguments("disable-infobars");
		// To Launch the Chrome Driver, you need to install this .exe file and place it somewhere
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sumit\\Desktop\\chromedriver_win32\\chromedriver.exe");
		// Pass the options parametere to define the parameter while launching chrome
		WebDriver oDriver = new ChromeDriver(options);
		
		oDriver.get("http://toolsqa.com/automation-practice-form/");
		WebElement button = oDriver.findElement(By.id("photo"));
		button.click();
		
		try {
			Runtime.getRuntime().exec("C:\\Users\\Sumit\\Desktop\\AutoIt_Scripts\\Upload.exe");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
