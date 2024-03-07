import ge.tbcitacademy.data.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CommandsTest extends Constants {
    private static WebDriver driver;


    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(HEROKUAPP_URL);
    }
    @AfterClass
    public static void tearDown() {
            driver.quit();
    }

    @Test
    public void buttonTest() throws InterruptedException {
        driver.findElement(By.xpath(DISABLE_BTN)).click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(By.xpath(TXT_INPUT)).isEnabled());
        Assert.assertEquals(driver.findElement(By.id(MESSAGE_ELEMENT)).getText(),ENABLED_MSG_TXT);
        driver.findElement(By.xpath(TXT_INPUT)).sendKeys(INPUT_TXT);
        driver.findElement(By.xpath(TXT_INPUT)).clear();
    }

    @Test
    public void labelsTest(){
        String headingText = driver.findElement(By.tagName(HEARING_TXT_ELEMENT)).getText();
        Assert.assertEquals(DYNAMIC_CONTROLS,headingText);
        String headingText1 = driver.findElement(By.tagName(HEADING_TXT_ELEMENT1)).getText();
        Assert.assertEquals(HEADING_TXT,headingText1);
    }

}
