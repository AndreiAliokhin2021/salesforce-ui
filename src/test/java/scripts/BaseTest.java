package scripts;

import config.UserConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    protected static UserConfig config;

    @BeforeClass
    public void setUp() {
        if (driver == null) {
            config = ConfigFactory.create(UserConfig.class);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://itechart3.lightning.force.com/");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(config.username(), config.password());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
