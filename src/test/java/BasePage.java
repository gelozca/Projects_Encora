import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement findElement(By element) {
        return waitForElement(element);
    }

    protected WebElement waitForElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    protected void click(By element) {
        findElement(element).click();
    }

    protected void sendKeys(By element, String text) {
        findElement(element).sendKeys(text);
    }

    protected List<WebElement> findElements(By element) {
        waitForElement(element);
        return driver.findElements(element);
    }

    protected void selectElementByText(By element, String text) {
        Select selectObject = new Select(findElement(element));
        selectObject.selectByVisibleText(text);
    }

    protected void selectElementByValue(By element, String value) {
        Select selectObject = new Select(findElement(element));
        selectObject.selectByValue(value);
    }

}
