import ge.tbcitacademy.data.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebElementTest extends Constants {
    private static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(HU_D_D_URL);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
    @Test
    public void dimensionsTest(){

        WebElement columnA = driver.findElement(By.id(COLUMN_A_ELEMENT));
        WebElement columnB = driver.findElement(By.id(COLUMN_B_ELEMENT));

        Assert.assertEquals(columnA.getLocation().getY(),columnB.getLocation().getY());

        /*int columnA1 = columnA.getLocation().getY();
        int columnB2 = columnB.getLocation().getY();
        Assert.assertEquals(columnA1,columnB2);*/

        Assert.assertEquals(columnA.getAttribute(DRAGGABLE_LMNT),TRUE_LMNT);
        Assert.assertEquals(columnB.getAttribute(DRAGGABLE_LMNT),TRUE_LMNT);

    }

    @Test
    public void linkTest(){

        WebElement linkText = driver.findElement(By.linkText(ELEMENTAL_SELENIUM_LMNT));

        String hrefOfLink = linkText.getAttribute(HREF_LMNT);
        Assert.assertEquals(hrefOfLink,ELEMENTAL_SELENIUM_URL);
    }


}