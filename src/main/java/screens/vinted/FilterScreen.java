package screens.vinted;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import screens.BaseScreen;

public class FilterScreen extends BaseScreen {

    private final String checkboxXpath = "//*[@resource-id='fr.vinted:id/filtering_option_title' and @text='%s']";

    @AndroidFindBy(id = "fr.vinted:id/catalog_filter_show_results")
    private WebElement showResultsButton;

    protected FilterScreen(AppiumDriver driver) {
        super(driver);
    }

    public ProductsScreen clickButtonShowResults() {
        showResultsButton.click();
        return new ProductsScreen(driver);
    }

    public FilterScreen selectCheckbox(String checkboxName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(checkboxXpath, checkboxName)))).click();
        return this;
    }

    public boolean checkIsCheckboxSelected(String checkboxName, boolean isSelected) {
        WebElement filterElement = driver.findElement(By.xpath(String.format(checkboxXpath, checkboxName)));
        return Boolean.parseBoolean(filterElement.getAttribute("checked")) == isSelected;
    }

}
