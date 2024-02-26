import org.testng.Assert;
import org.testng.annotations.Test;
import screens.MainScreen;

public class WikipediaSearchingTest extends BaseTest {

    @Test
    public void checkSearchingByWord() {
        String text = "Appium";
        MainScreen mainScreen = new MainScreen(driver);
        String actualTitle = mainScreen.clickOnSkipButton()
                .clickOnSearchField()
                .enterWordInTheSearchField(text)
                .openTextLink(text)
                .getTitle();
        Assert.assertEquals(actualTitle, text);
    }
}
