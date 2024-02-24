import org.testng.Assert;
import org.testng.annotations.Test;
import screens.MainScreen;

public class WelcomeScreenTest extends BaseTest {

    @Test
    public void checkSearchingByWord() {
        MainScreen mainScreen = new MainScreen(driver);
        boolean isVoiceSearchButtonExist = mainScreen.clickOnSkipButton()
                .isVoiceSearchButtonExist();
        Assert.assertTrue(isVoiceSearchButtonExist);
    }
}
