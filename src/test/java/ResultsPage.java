import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultsPage extends BasePage {

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    private By ddlSortPrices = By.id("sort");
    private By tblResults = By.xpath("//*[@id=\"results\"]/table/tbody/tr");


    protected boolean hasAscendingPrices() {
        List<WebElement> elements = findElements(tblResults);
        ArrayList<String> priceList = getPrices(elements.size());

        if (getSortedList(priceList, "asc").equals(priceList))
            return true;

        return false;

    }

    protected void selectPriceAscending() {
        selectElementByValue(ddlSortPrices, "asc");
    }

    private ArrayList<String> getPrices(int nbrElements) {
        ArrayList<String> pricesList = new ArrayList<>();
        String fullXpath = "";
        String xpath = ".//*[@id=\"results\"]/table/tbody/tr[";


        for (int i = 1; i <= nbrElements; i++) {
            fullXpath = xpath + i + "]/td[4]";
            pricesList.add(driver.findElement(By.xpath(fullXpath)).getText());
        }

        return pricesList;
    }

    private ArrayList<String> getSortedList(ArrayList<String> list, String type) {
        ArrayList<String> sortedList = new ArrayList<>(list);

        if (type.equals("asc"))
            Collections.sort(sortedList);
        else
            Collections.sort(sortedList, Collections.reverseOrder());

        return sortedList;
    }
}
