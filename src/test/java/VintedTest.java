import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import screens.vinted.FilterScreen;
import screens.vinted.MainVintedScreen;
import screens.vinted.ProductsScreen;

public class VintedTest extends BaseTest {

    @Test
    public void checkProductFilter() {
        String product = "hats";
        String filter = "Brand";
        String brand = "H&M";
        MainVintedScreen mainVintedScreen = new MainVintedScreen(driver);
        FilterScreen filterScreen = mainVintedScreen.signIn()
                .clickOnSearchField()
                .enterWordInTheSearchField(product)
                .openProducts(product)
                .selectFilter(filter);
        boolean isCheckboxSelected = filterScreen.selectCheckbox(brand)
                .checkIsCheckboxSelected(brand, true);
        ProductsScreen productsScreen = filterScreen.clickButtonShowResults();
        boolean isFilterSelected = productsScreen.checkIsFilterSelected(filter, true);
        String actualTitle = productsScreen.getTitleBrand();
        boolean isFirstTwoProductsHaveBrandHAndM = productsScreen.checkThatFirstTwoProductsHaveBrand(brand);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isCheckboxSelected);
        softAssert.assertTrue(isFilterSelected);
        softAssert.assertEquals(actualTitle, brand);
        softAssert.assertTrue(isFirstTwoProductsHaveBrandHAndM);
    }
}
