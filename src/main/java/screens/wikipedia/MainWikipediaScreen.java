package screens.wikipedia;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import screens.BaseScreen;

public class MainWikipediaScreen extends BaseScreen {
    private String skipButtonXpath = "//*[contains(@text, 'Skip')]";

    @AndroidFindBy(xpath = "//*[contains(@text, 'Search Wikipedia')]")
    private WebElement searchField;

    @AndroidFindBy(id = "voice_search_button")
    private WebElement voiceSearchButton;

    public MainWikipediaScreen(AppiumDriver driver) {
        super(driver);
    }

    public MainWikipediaScreen clickOnSkipButton() {
        if (isElementVisible(By.xpath(skipButtonXpath))) {
            driver.findElement(By.xpath(skipButtonXpath)).click();
            log.info("Click 'Skip' button");
        }
        return this;
    }

    public SearchScreen clickOnSearchField() {
        wait.until(ExpectedConditions.visibilityOf(searchField)).click();
        return new SearchScreen(driver);
    }

    public boolean isVoiceSearchButtonExist() {
        return isElementVisible(voiceSearchButton);
    }
}
