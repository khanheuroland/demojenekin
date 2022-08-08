package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hook {
    public static WebDriver driver;

    @Before
    public void Setup()
    {
        String browser = System.getProperty("browser", "chrome");
        switch (browser.toLowerCase())
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver =  new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver =  new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new NotFoundException("webdriver not found");
        }
    }

    @After
    public void TearDown(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            byte[] img = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(img, "image/png", "Screenshot");
        }
        driver.quit();
    }
}
