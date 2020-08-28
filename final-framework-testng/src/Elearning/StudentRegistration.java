package Elearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StudentRegistration {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\LPB24\\Selenium-Jar\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://elearningm1.upskills.in");	

	}

}
