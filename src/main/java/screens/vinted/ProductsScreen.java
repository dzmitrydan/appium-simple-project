package screens.vinted;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import screens.BaseScreen;

import java.util.List;

public class ProductsScreen extends BaseScreen {
    private final String filterXpath = "//*[@resource-id='fr.vinted:id/horizontal_filter_chip' and @text='%s']";

    @AndroidFindBy(id = "fr.vinted:id/view_cell_title")
    private WebElement titleBrand;

    @AndroidFindBy(xpath = "//*[@resource-id='fr.vinted:id/item_box_info_1']")
    private List<WebElement> productsBrand;

    protected ProductsScreen(AppiumDriver driver) {
        super(driver);
    }

    public FilterScreen selectFilter(String filter) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(filterXpath, filter)))).click();
        return new FilterScreen(driver);
    }

    public boolean checkIsFilterSelected(String filter, boolean isSelected) {
        WebElement filterElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(filterXpath, filter))));
        return Boolean.parseBoolean(filterElement.getAttribute("selected")) == isSelected;
    }

    public String getTitleBrand() {
        return titleBrand.getText();
    }

    public boolean checkThatFirstTwoProductsHaveBrand(String brand) {
        return productsBrand.stream().map(WebElement::getText).filter(brand::equals).count() == 2;
    }
}
