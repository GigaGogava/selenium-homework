import Utils.UniversalSelector;
import ge.tbcitacademy.data.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class FormsTest extends Constants {
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
    public void customDropDownTest() {
        driver.get(TYMPANUS_URL);
        driver.findElement(By.linkText(LINK_TXT)).click();

        WebElement dropDown = driver.findElement(By.id(BY_ID_LMNT_DD));
        List<WebElement> options = dropDown.findElements(By.tagName(TAG_NAME_LI));

        for (WebElement option : options) {
            Assert.assertFalse(option.isDisplayed());
        }

        dropDown.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BY_ID_LMNT_DD)));
        Assert.assertTrue(driver.findElement(By.cssSelector(CSS_SLCTR_DDLI)).getText().contains("Github"), "true");
        UniversalSelector.universalSelector(dropDown, "Github");
//აქ როგორ დავრწუმდე რო გიტჰაბია მონიშნული, საიტზე ხელით რო ვნიშნავ არ ინიშნება :D

    }

    @Test
    public void nativeDropDownTest() {
        driver.get(TECHCANVAS_URL);
        driver.findElement(By.cssSelector(CHECK_BOX_CSS)).click();
        WebElement dropDown = driver.findElement(By.cssSelector(CHOOSE_DROPDOWN_CSS));
        UniversalSelector.universalSelector(dropDown, SELECTOR_TXT_DD);
        driver.findElement(By.xpath(NAME_INPUT_XPATH)).sendKeys(RANDOM_NAME);
        driver.findElement(By.xpath(LASTNAME_INPUT_XPATH)).sendKeys(RANDOM_LAST_NAME);
        driver.findElement(By.xpath(ADDRES_INPUT_XPATH)).sendKeys(RANDOM_ADDRESS);
        driver.findElement(By.xpath(ADDRES_INPUT_XPATH1)).sendKeys(RANDOM_ADDRESS1);
        driver.findElement(By.xpath(CITY_INPUT_XPATH)).sendKeys(RANDOM_CITY);
        driver.findElement(By.xpath(NUMBER_INPUT_XPATH)).sendKeys(RANDOM_NUMBER);
        driver.findElement(By.xpath(NUMBER1_INPUT_XPATH)).sendKeys(RANDOM_NUMBER);
        WebElement checkBox = driver.findElement(By.cssSelector(TECHCANVASS_CHECKBOX_CSS));
        for (int i = 0; i < 2; i++){
            checkBox.click();
            System.out.println(checkBox.isSelected());
        }
        driver.findElement(By.cssSelector(TECHCAN_SUBMIT_CSS)).click();
    }

}
