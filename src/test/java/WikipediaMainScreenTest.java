import org.testng.Assert;
import org.testng.annotations.Test;
import screens.wikipedia.MainWikipediaScreen;

public class WikipediaMainScreenTest extends BaseTest {

    @Test
    public void checkSearchingByWord() {
        MainWikipediaScreen mainWikipediaScreen = new MainWikipediaScreen(driver);
        boolean isVoiceSearchButtonExist = mainWikipediaScreen.clickOnSkipButton()
                .isVoiceSearchButtonExist();
        Assert.assertTrue(isVoiceSearchButtonExist);
    }
}
