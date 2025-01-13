package TestCases;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
public class BaseClass {
	public static WebDriver sadhika;
	public Logger logger;//log4j
	public Properties p;

@Parameters({"os","browser"})
	@BeforeClass(groups = {"Sanity","Regression","Master"})
public void setup(@Optional ("Windows") String os,@Optional("chrome") String br) throws IOException {
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		logger=LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase()) {
		case  "chrome" : sadhika=new ChromeDriver();break;
		case  "edge" : sadhika=new EdgeDriver();break;
		case  "firefox" : sadhika=new FirefoxDriver();break;
		default : System.out.println("Invalid browser name");return;//exit from the execution
		
		}
		
		sadhika=new ChromeDriver();
	sadhika.manage().deleteAllCookies();
	sadhika.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	sadhika.get(p.getProperty("URL"));
	sadhika.manage().window().maximize();
}
@AfterClass(groups = {"Sanity","Regression","Master"})
public void tearDown() {
	sadhika.quit();
}
public String randomString() {
	
	String generatedString=RandomStringUtils.randomAlphabetic(5);
	return generatedString;
	
}
public String randomNumber() {
	String generatedNumber=RandomStringUtils.randomNumeric(10);
	return generatedNumber;
}
public String AlphaNumeric() {
	String generatedString=RandomStringUtils.randomAlphabetic(3);
	String generatedNumber=RandomStringUtils.randomNumeric(3);
	return (generatedNumber+"@"+generatedString);
}
public String captureScreen(String tname) throws IOException {

	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
	TakesScreenshot takesScreenshot = (TakesScreenshot) sadhika;
	File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	
	String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
	File targetFile=new File(targetFilePath);
	
	sourceFile.renameTo(targetFile);
		
	return targetFilePath;

}

}
