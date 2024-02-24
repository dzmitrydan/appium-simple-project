package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainScreen extends AbstractScreen {
    private String skipButtonXpath = "//*[contains(@text, 'Skip')]";

    @AndroidFindBy(xpath = "//*[contains(@text, 'Search Wikipedia')]")
    private WebElement searchField;

    @AndroidFindBy(id = "voice_search_button")
    private WebElement voiceSearchButton;

    public MainScreen(AppiumDriver driver) {
        super(driver);
    }

    public MainScreen clickOnSkipButton() {
        if (isElementVisible(By.xpath(skipButtonXpath))) {
            driver.findElement(By.xpath(skipButtonXpath)).click();
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
