package screens.vinted;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import screens.BaseScreen;

public class SearchScreen extends BaseScreen {
    private final String textLinkXpath = "//*[@resource-id='fr.vinted:id/view_cell_title' and @text='%s']";

    @AndroidFindBy(id = "fr.vinted:id/view_input_value")
    private WebElement searchField;

    public SearchScreen(AppiumDriver driver) {
        super(driver);
    }

    public SearchScreen enterWordInTheSearchField(String text) {
        searchField.sendKeys(text);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(textLinkXpath, text))));
        return this;
    }

    public ProductsScreen openProducts(String text) {
        driver.findElement(By.xpath(String.format(textLinkXpath, text))).click();
        return new ProductsScreen(driver);
    }
}
