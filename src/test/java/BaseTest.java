import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import testutility.TestListener;

@Listeners({TestListener.class})
public abstract class BaseTest {
    protected AppiumDriver driver;

    @BeforeMethod()
    public void setUp() {
        driver = DriverManager.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverManager.quitDriver();
    }
}
