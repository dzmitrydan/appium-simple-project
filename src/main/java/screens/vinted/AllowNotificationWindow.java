package screens.vinted;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import screens.BaseScreen;

public class AllowNotificationWindow extends BaseScreen {

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement allowButton;

    protected AllowNotificationWindow(AppiumDriver driver) {
        super(driver);
    }

    public MainVintedScreen clickAllowButton() {
        wait.until(ExpectedConditions.elementToBeClickable(allowButton)).click();
        return new MainVintedScreen(driver);
    }
}
