import org.testng.Assert;
import org.testng.annotations.Test;
import screens.wikipedia.MainWikipediaScreen;

public class WikipediaSearchingTest extends BaseTest {

    @Test
    public void checkSearchingByWord() {
        String text = "Appium";
        MainWikipediaScreen mainWikipediaScreen = new MainWikipediaScreen(driver);
        String actualTitle = mainWikipediaScreen.clickOnSkipButton()
                .clickOnSearchField()
                .enterWordInTheSearchField(text)
                .openTextLink(text)
                .getTitle();
        Assert.assertEquals(actualTitle, text);
    }
}
