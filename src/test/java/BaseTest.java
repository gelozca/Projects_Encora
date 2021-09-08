import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected WebDriver driver;

    public void startTest(String browser) {

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.navigate().to("file:///usr/local/bin/site2/reports.html");
    }

    @After
    public void finishTest() {
        driver.quit();
    }

}
