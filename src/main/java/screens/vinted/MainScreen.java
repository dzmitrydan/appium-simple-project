package screens.vinted;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import screens.BaseScreen;

public class MainScreen extends BaseScreen {

    @AndroidFindBy(id = "fr.vinted:id/view_input_value")
    private WebElement searchField;

    @AndroidFindBy(id = "fr.vinted:id/show_login_options_button")
    private WebElement haveAccountButton;

    @AndroidFindBy(id = "fr.vinted:id/sign_in_google_button")
    private WebElement continueWithGoogleButton;

    @AndroidFindBy(id = "com.google.android.gms:id/account_name")
    private WebElement accountName;

    @AndroidFindBy(id = "fr.vinted:id/accept_all_button")
    private WebElement acceptAllButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement allowButton;

    public MainScreen(AppiumDriver driver) {
        super(driver);
    }

    public MainScreen signIn() {
        if (isElementVisible(haveAccountButton)) {
            haveAccountButton.click();
            wait.until(ExpectedConditions.elementToBeClickable(continueWithGoogleButton)).click();
            wait.until(ExpectedConditions.elementToBeClickable(accountName)).click();
            wait.until(ExpectedConditions.elementToBeClickable(acceptAllButton)).click();
            wait.until(ExpectedConditions.elementToBeClickable(allowButton)).click();
        }
        return this;
    }

    public SearchScreen clickOnSearchField() {
        wait.until(ExpectedConditions.visibilityOf(searchField)).click();
        return new SearchScreen(driver);
    }
}
