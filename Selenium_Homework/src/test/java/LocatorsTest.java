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
import java.util.List;
import java.util.stream.Collectors;

public class LocatorsTest extends Constants {
private WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void unorderedList() {
        driver.get(JQUERYUI_URL);
        WebElement aside = driver.findElement(By.xpath(ASIDE_H3_XPATH));
        List<WebElement> elements = aside.findElements(By.xpath(UL_LI_XPATH));
        List<WebElement> filterElements = elements.stream()
                .filter(lmnt -> lmnt.getText().toLowerCase().contains("o"))
                .collect(Collectors.toList());
        filterElements.parallelStream().forEach(lmnt ->{
            WebElement forEa = lmnt.findElement(By.tagName("a"));
            String href = forEa.getAttribute(HREF);
            System.out.println(HREF_SOUT_TXT + href);
            if (!href.contains(HREF_ASSERT)) {
                System.out.println(HREF_SOUT_TXT + href);//??
            }
            });
    }
    @Test
    public void buttonsTest() {
        driver.get(HEROKU_A_R_URL);

        for (int i = 0; i < 3; i++) {
            WebElement addButton = driver.findElement(By.xpath(ADD_BTN));
            addButton.click();
        }

        WebElement lastDeleteButton = driver.findElement(By.cssSelector(LAST_DLT_BTN_CSS));
        Assert.assertTrue(lastDeleteButton.getAttribute(LDB_ATTRIBUTE).contains(ASSERT_CONTAINS_A_M));

        List<WebElement> deleteButtons = driver.findElements(By.cssSelector(DELETE_BTN_CSS));
        Assert.assertFalse(deleteButtons.isEmpty());
        for (WebElement button : deleteButtons) {
            Assert.assertEquals(button.getAttribute(ONCLICK_ATT), DEL_LMNT);
        }
    }
    @Test
    public void challengingDomTest() {
        driver.get(HEROKU_CHALLENGING_DOM);
        WebElement element = driver.findElement(By.xpath(APERIAN_XPATH));
        System.out.println(element.getText());
    }



}
