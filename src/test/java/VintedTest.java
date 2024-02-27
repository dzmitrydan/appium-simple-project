import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import screens.vinted.FilterScreen;
import screens.vinted.MainVintedScreen;
import screens.vinted.ProductsScreen;

public class VintedTest extends BaseTest {
    private static final String PRODUCT = "hats";
    private static final String FILTER = "Brand";
    private static final String BRAND = "H&M";

    @Test
    public void checkProductFilter() {
        MainVintedScreen mainVintedScreen = new MainVintedScreen(driver);
        FilterScreen filterScreen = mainVintedScreen.signIn()
                .clickOnSearchField()
                .enterWordInTheSearchField(PRODUCT)
                .openProducts(PRODUCT)
                .selectFilter(FILTER);
        boolean isCheckboxSelected = filterScreen.selectCheckbox(BRAND)
                .checkIsCheckboxSelected(BRAND, true);
        ProductsScreen productsScreen = filterScreen.clickButtonShowResults();
        boolean isFilterSelected = productsScreen.checkIsFilterSelected(FILTER, true);
        String actualTitle = productsScreen.getTitleBrand();
        boolean isFirstTwoProductsHaveBrandHAndM = productsScreen.checkThatFirstTwoProductsHaveBrand(BRAND);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isCheckboxSelected);
        softAssert.assertTrue(isFilterSelected);
        softAssert.assertEquals(actualTitle, BRAND);
        softAssert.assertTrue(isFirstTwoProductsHaveBrandHAndM);
    }
}
