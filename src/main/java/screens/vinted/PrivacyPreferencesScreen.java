package screens.vinted;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import screens.BaseScreen;

public class PrivacyPreferencesScreen extends BaseScreen {

    @AndroidFindBy(id = "fr.vinted:id/accept_all_button")
    private WebElement acceptAllButton;

    protected PrivacyPreferencesScreen(AppiumDriver driver) {
        super(driver);
    }

    public AllowNotificationWindow clickAcceptAllButton() {
        wait.until(ExpectedConditions.elementToBeClickable(acceptAllButton)).click();
        return new AllowNotificationWindow(driver);
    }
}
