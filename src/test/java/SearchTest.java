import org.automation.pages.HomePage;
import org.automation.pages.LauncherPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.domstorage.model.Item;
import org.testng.annotations.Test;

import java.util.List;


public class SearchTest {


        @Test
        public void verifySearchResultShowsRelevantResults(){

        /* Arrange

        1. Go to WebPlayground : Url : "https://web-playground.ultralesson.com/"
        LauncherPage launcherPage = new LauncherPage(webDriver);
        launcherPage.navigateTo(""https://web-playground.ultralesson.com/"");
        2. Search product : keyword - Jeans
        String searchProduct = "Jeans";
        String searchKey = "Jean";
        3. Search result :  */

                //1. Navigate to URL

                String searchItem =  "Jeans";
                String searchKey = "Polo Jeans";
                WebDriver driver = null;
                LauncherPage launcherPage = new LauncherPage(driver);
                launcherPage.navigateTo("https://web-playground.ultralesson.com/");


        //Act // 2. Click on Search Icon // 3. Type Search keyword
        HomePage homePage = new HomePage(driver);
        homePage.search(searchItem);




        //4. verify search result
        List<Item> searchItems = homePage.getSearchItems();

        //Assert
        //1.Verify the product name
        Assertions.assertEquals(4,searchItems.size());
        Assertions.assertTrue(searchItems.stream().allMatch(item -> item.getName().contains(searchKey)));

        }

}
