import ge.tbcitacademy.data.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WaitTest extends Constants {
    private WebDriver driver;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void waitForDisappearance(){

        driver.get(HEROKUAPP_URL);
        WebElement button = driver.findElement(By.cssSelector(ENABLE_BTN_CSS));
        button.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(LOADING_CSS)));
        String buttonText = button.getText();
        Assert.assertTrue(buttonText.contains("Disable"));
        driver.findElement(By.cssSelector(ENABLE_DISABLE_INPUT_CSS)).sendKeys("ACCESS GRANTED");
    }
    @Test
    public void waitForText(){
        driver.get(DEMOQA_PROG_BAR_URL);
        WebElement startBtn = driver.findElement(By.id(START_STOP_BTN));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(SCROLL_DOWN);
        startBtn.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(PROGRESS_BAR_ID),"100%"));
        WebElement proBar = driver.findElement(By.id(PROGRESS_BAR_ID));
        String progressBar = proBar.getText();
        Assert.assertTrue(progressBar.contains("100%"));
    }

}
