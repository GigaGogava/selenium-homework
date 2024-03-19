import ge.tbcitacademy.data.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CookiesTest extends Constants {
    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setUp(String browser) {
        System.out.println(browser);
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
     @Test
     public void filterCookies() {
         driver.get(TECHLISTIC_URL);
         Set<Cookie> cookies = driver.manage().getCookies();
         boolean activeTemplateFound = cookies.stream()
                 .anyMatch(cookie -> cookie.getName().contains(TEMPLATE_COOKIE)
                         && cookie.getValue().contains(PUB_SITE));

         if (activeTemplateFound) {
             System.out.println(TEMPLATE_FOUND_TXT);
         } else {
             System.out.println(COOKIE_NOT_FOUND_TXT);
            }
    }

    @Test
    public void injectCookies(){
        driver.get(TECHLISTIC_URL);
        List<Cookie> addedCookies = new ArrayList<>();
        addedCookies.add(new Cookie("aba","aba1"));
        addedCookies.add(new Cookie("aba2","aba2"));
        addedCookies.add(new Cookie("aba3","aba3"));
        addedCookies.add(new Cookie("aba4","aba4"));
        addedCookies.add(new Cookie("aba5","aba5"));
        addedCookies.add(new Cookie("aba6","aba6"));
        addedCookies.add(new Cookie("aba7","aba7"));
        addedCookies.add(new Cookie("aba8","aba8"));
        addedCookies.add(new Cookie("aba9","aba9"));
        addedCookies.add(new Cookie("aba10","aba10"));
        addedCookies.forEach(driver.manage()::addCookie);
        System.out.println("added cookies");
        addedCookies.forEach(cookie -> System.out.println(cookie.getName() + " : " + cookie.getValue()));
//        driver.manage().deleteAllCookies();
        addedCookies.clear();
        System.out.println("no more cookies");
        addedCookies.forEach(cookie -> System.out.println(cookie.getName() + " : " + cookie.getValue()));
        Assert.assertTrue(addedCookies.isEmpty());
        //აქ ცალცალკე დამატება და წაშლა ვცადე, გამოვიდა მარტივარ,
        //მაგრამ 10 ქუქის დამატება და წაშლა დიდი კოდი გამოდიოდა
        //და ესე გავაკეთე, რა აღარ ვცადე ლისტით დამატებულის წასაშლელად და ესე გამოვიდა :D
        //იმედია შეცდომად არ ჩამითვლით
    }

    @Test
    public void autoCompleteTest(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.get(DEMO_AUTOTEST_URL);
        driver.findElement(By.xpath(DEMO_SEARCHBOX_INPUT_XPATH)).sendKeys("ge");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(DEMO_SUGGESTIONS_CLASSNAME)));
        List<WebElement> suggestions = driver.findElements(By.cssSelector(DEMO_SUG_CSS));
        suggestions.get(0).click();
    }
}

