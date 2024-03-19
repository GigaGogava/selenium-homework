import ge.tbcitacademy.data.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Exceptions extends Constants{
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(TYMPANUS_URL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testNoSuchElementException() {
        try {
            driver.findElement(By.id("non-existent-element"));
        } catch (NoSuchElementException e) {
            // Solution: Verify the element locator or handle the exception gracefully (e.g., log the error)
        }
    }

    @Test
    public void noAlertPresentException() {

        try {
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());

        } catch (
                NoAlertPresentException e) {
            // Solution: Handle the case when no alert is present before interacting with it
        }

    }

    @Test
    public void testNoSuchFrameException() {
        try {
            driver.switchTo().frame("non-existent-frame");
        } catch (NoSuchFrameException e) {
            // Solution: Verify the frame name or id before switching to it.
        }
    }
    @Test
    public void noSuchElementException() {
        try {
            WebElement element = driver.findElement(By.id("nonExistingElement")); // This element likely doesn't exist
            System.out.println(element.getText());
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: Element not found! ");
            //Solution:** Double-check the locator or use more robust element identification strategies
        }
    }
    @Test
    public void testElementNotVisibleException() {
        driver.navigate().to(DEMO_AUTOTEST_URL);
        try {
            driver.findElement(By.xpath(Constants.DEMO_SEARCHBOX_INPUT_XPATH)).getSize();
            List<WebElement> suggestions = driver.findElements(By.cssSelector(Constants.DEMO_SUG_CSS));
            suggestions.get(1).click();
        } catch (ElementNotVisibleException | TimeoutException e) {
            // Solution: Use explicit waits to ensure element becomes visible before interaction.
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Constants.DEMO_SEARCHBOX_INPUT_XPATH)));
            driver.findElement(By.cssSelector(Constants.DEMO_SUG_CSS)).sendKeys("ge");
            List<WebElement> suggestions = driver.findElements(By.cssSelector(Constants.DEMO_SUG_CSS));
            suggestions.get(1).click();
        }
        //cant find hidden element :D
    }

    @Test
    public void testNoSuchWindowException() {
        try {
            driver.switchTo().window("non-existent-window");
        } catch (NoSuchWindowException e) {
            // Solution: Handle scenarios where multiple windows might open and identify the correct one before switching.

        }
    }

    @Test
    public void testSessionNotFoundException() {
        try {
            driver.quit();
            driver.getTitle();
        } catch (NoSuchSessionException e) {
            //Solution : To handle such exceptions,
            // we need to revisit our code and check if
            // the code is not accidentally closing the browser before some tests are not finished.
        }
    }

    @Test
    public void testStaleElementReferenceException() {

        // StaleElementReferenceException
        driver.findElement(By.cssSelector("body > div.container > header > nav > a:nth-child(2)")).click();
        WebElement staleElement = driver.findElement(By.id("dd"));


        try {
            System.out.println(staleElement.getText()); // This might throw StaleElementReferenceException
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException: Element reference is stale! ");
        }
        // Solution: Refresh the web page before accessing the web element.
            //Use the try-catch block to handle the exception and attempt to locate the element again.
            //Use explicit wait to ensure the element is present or refreshed before interacting with it.
    }
}