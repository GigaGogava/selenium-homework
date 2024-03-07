import ge.tbcitacademy.data.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NavigationTest extends Constants {
    private static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(ULTIMATE_QA_URL);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
    @Test
    public void goToSuccessStoriesAndBack() throws InterruptedException {
        driver.findElement(By.id(SUCCESS_STORIES_ELEMENT)).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, TESTIMONIALS_URL);
        driver.navigate().back();
        Thread.sleep(4000);
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, ULTIMATE_QA_URL);

    }

}
