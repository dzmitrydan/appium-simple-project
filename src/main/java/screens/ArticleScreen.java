package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ArticleScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//*[@resource-id='pcs']/*/*")
    private WebElement title;

    public ArticleScreen(AppiumDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }
}
