package screens.vinted;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import screens.BaseScreen;

public class ChooseAccountWindow extends BaseScreen {

    @AndroidFindBy(id = "com.google.android.gms:id/account_name")
    private WebElement accountName;

    protected ChooseAccountWindow(AppiumDriver driver) {
        super(driver);
    }

    public PrivacyPreferencesScreen clickAccountNameButton() {
        wait.until(ExpectedConditions.elementToBeClickable(accountName)).click();
        return new PrivacyPreferencesScreen(driver);
    }
}
