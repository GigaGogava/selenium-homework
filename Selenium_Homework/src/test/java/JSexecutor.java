import ge.tbcitacademy.data.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSexecutor extends Constants {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void deleteTest() {
        driver.get(TECHLISTIC_URL);
        WebElement item = driver.findElement(By.xpath("//*[@id=\"container\"]/ul/li[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(item).perform();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].remove()", item);
        List<WebElement> todoItems = driver.findElements(By.tagName("li")).stream().toList();
        boolean itemDeleted = todoItems.stream().noneMatch(element -> element.getText().equals(" Go to potion class"));
        Assert.assertTrue(itemDeleted, "Item was not deleted successfully");
    }

    @Test
    public void scrollTest() {
        driver.get(TECHLISTIC_URL);
        Map<String, String> codeExamples = new HashMap<>();
        List<WebElement> sections = driver.findElements(By.xpath("//*[@id=\"PopularPosts1\"]/h3"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (WebElement section : sections) {
            String sectionName = section.getText().trim();
            js.executeScript("arguments[0].scrollIntoView();", section);
            String codeExample = section.findElement(By.xpath("//*[@id=\"PopularPosts1\"]/div")).getText();
            codeExamples.put(sectionName, codeExample);
        }

        System.out.println(CODE_EX_TXT);
        for (Map.Entry<String, String> entry : codeExamples.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        WebElement popularTutorials = driver.findElement(By.xpath("//*[@id=\"PopularPosts1\"]"));
        js.executeScript("arguments[0].scrollIntoView();", popularTutorials);
        Map<String, String> tutorialLinks = new HashMap<>();
        List<WebElement> tutorials = popularTutorials.findElements(By.cssSelector(POP_TUT_CSS));
        for (WebElement tutorial : tutorials) {
            String label = tutorial.getText().trim();
            String href = tutorial.getAttribute(HREF);
            tutorialLinks.put(label, href);
        }

        System.out.println(TUT_LINKS_TXT);
        for (Map.Entry<String, String> entry : tutorialLinks.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
    @Test
    public void anotherScrollTest() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get(WEBDRIVER_UNI_URL);
        WebElement entriesBox = driver.findElement(By.xpath("//*[@id=\"zone2-entries\"]"));
        js.executeScript("arguments[0].scrollIntoView();", entriesBox);
        String entriesText = (String) js.executeScript("return arguments[0].textContent;", entriesBox);
        Assert.assertTrue(entriesText.contains("Entries"));
    }

}
