package screens.vinted;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import screens.BaseScreen;

public class LogInDrawer extends BaseScreen {

    @AndroidFindBy(id = "fr.vinted:id/sign_in_google_button")
    private WebElement continueWithGoogleButton;

    protected LogInDrawer(AppiumDriver driver) {
        super(driver);
    }

    public ChooseAccountWindow clickContinueWithGoogleButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueWithGoogleButton)).click();
        return new ChooseAccountWindow(driver);
    }
}
