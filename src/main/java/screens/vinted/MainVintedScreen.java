package screens.vinted;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import screens.BaseScreen;

public class MainVintedScreen extends BaseScreen {

    @AndroidFindBy(id = "fr.vinted:id/view_input_value")
    private WebElement searchField;

    @AndroidFindBy(id = "fr.vinted:id/show_login_options_button")
    private WebElement haveAccountButton;

    public MainVintedScreen(AppiumDriver driver) {
        super(driver);
    }

    public MainVintedScreen signIn() {
        if (isElementVisible(haveAccountButton)) {
            log.info("Log in to the app");
            clickHaveAccountButton().clickContinueWithGoogleButton()
                    .clickAccountNameButton()
                    .clickAcceptAllButton()
                    .clickAllowButton();
        }
        return this;
    }

    public LogInDrawer clickHaveAccountButton() {
        wait.until(ExpectedConditions.elementToBeClickable(haveAccountButton)).click();
        return new LogInDrawer(driver);
    }

    public SearchScreen clickOnSearchField() {
        wait.until(ExpectedConditions.visibilityOf(searchField)).click();
        return new SearchScreen(driver);
    }
}
