import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class test extends BaseTest {

    @Before
    public void startTest() {

        startTest(System.getProperty("name"));
    }

    @Test
    public void test() {
        ReportsPage reportsPage = new ReportsPage(driver);
        ResultsPage resultsPage = new ResultsPage(driver);

        reportsPage.enterReportFrom("01/09/2021");
        reportsPage.enterReportTo("01/10/2021");
        reportsPage.selectPricesReport();
        reportsPage.selectFullReport();
        reportsPage.clickViewRepor();

        resultsPage.selectPriceAscending();
        Assert.assertTrue(resultsPage.hasAscendingPrices());
    }
}
