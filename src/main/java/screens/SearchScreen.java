package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchScreen extends BaseScreen {
    private final String linkXpath = "//*[@resource-id='org.wikipedia:id/page_list_item_title']";
    private final String textLinkXpath = "//*[@resource-id='org.wikipedia:id/page_list_item_title'" +
            " and contains(@text, '%s')]";

    @AndroidFindBy(xpath = "//*[contains(@text, 'Search Wikipedia')]")
    private WebElement searchField;

    public SearchScreen(AppiumDriver driver) {
        super(driver);
    }

    public SearchScreen enterWordInTheSearchField(String word) {
        searchField.sendKeys(word);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(linkXpath)));
        return this;
    }

    public ArticleScreen openTextLink(String text) {
        driver.findElement(By.xpath(String.format(textLinkXpath, text))).click();
        return new ArticleScreen(driver);
    }
}
