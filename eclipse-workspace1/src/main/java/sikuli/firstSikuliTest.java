/*package sikuli;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class firstSikuliTest {

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
		
		oDriver.get("https://www.google.co.in/");
		
		Screen s = new Screen();
		try {
			s.click("C:\\Users\\Sumit\\Desktop\\test.png");
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
*/