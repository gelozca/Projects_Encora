import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReportsPage extends BasePage {

    public ReportsPage(WebDriver driver) {
        super(driver);
    }

    private By txtReportFrom = By.id("fromDate");
    private By txtReportTo = By.id("toDate");
    private By ddlReportToDisplaye = By.id("selectedReport");
    private By rdoFullReport = By.xpath("//*[@name=\"reportType\"][@value=\"full\"]");
    private By btnViewReport = By.xpath("//*[@class=\"far fa-file-alt\"]");

    protected void enterReportFrom(String text) {
        sendKeys(txtReportFrom, text);
    }

    protected void enterReportTo(String text) {
        sendKeys(txtReportTo, text);
    }

    protected void selectPricesReport() {
        selectElementByValue(ddlReportToDisplaye, "prices");
    }

    protected void clickViewRepor() {
        click(btnViewReport);
    }

    protected void selectFullReport() {
        click(rdoFullReport);
    }

}
