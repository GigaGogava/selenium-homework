package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UniversalSelector {
    public static void universalSelector(Object element, String visibleText) {
        if (element instanceof Select select) {
            select.selectByVisibleText(visibleText);
        } else if (element instanceof WebElement) {
            WebElement webElement = (WebElement) element;
            List<WebElement> options = webElement.findElements(By.tagName("option"));
            for (WebElement option : options) {
                if (option.getText().equals(visibleText)) {
                    option.click();
                    break;
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid element type");
        }
System.out.println("I AM A CHANGE MEANWHILE/RESOLVED");

    }
}
