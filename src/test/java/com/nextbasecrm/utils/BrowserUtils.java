package com.nextbasecrm.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BrowserUtils {

    public static void sleep (int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
            System.out.println("Exception happened in sleep method");
        }
    }

    public static void scrollDown ( int pixel) {
        JavascriptExecutor je = (JavascriptExecutor) Driver.getDriver();
        je.executeScript("window.scrollBy(0, " + pixel + ")");
    }

    public static void scrollDown (WebElement elem) {
        JavascriptExecutor je = (JavascriptExecutor) Driver.getDriver();
        je.executeScript("arguments[0].scrollIntoView(true)", elem);
    }

    public static void switchToWindow (String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();

        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(windowHandle);
            if (targetTitle.equals(Driver.getDriver().getTitle())) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    public static void hoveOver (WebElement elem) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(elem).perform();
    }

    public static void doubleClick (WebElement elem) {
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(elem).perform();
    }

    public static void rightCLick (WebElement elem) {
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(elem);
    }

    public static void clickWithJS (WebElement elem) {
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true)", elem);
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].click", elem);
    }

    public static List <String> getElementsText (List <WebElement> list) {
        List <String> elemText = new ArrayList<>();
        for (WebElement elem : list) {
            elemText.add(elem.getText());
        }
        return elemText;
    }

    public static WebElement selectRandomTextFomDropdown (Select select) {
        Random random = new Random();
        List <WebElement> webList = select.getOptions();
        int optionIndex = 1 + random.nextInt(webList.size() - 1);
        select.selectByIndex(optionIndex);
        return select.getFirstSelectedOption();
    }

    public static WebElement waitForVisibility (WebElement elem, int timeout) {
        WebDriverWait wait = new WebDriverWait (Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOf(elem));
    }

    public static void  waitForVisibilityOf (WebElement elem, int timeout) {
        WebDriverWait wait = new WebDriverWait (Driver.getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOf(elem));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickability (WebElement elem, int timeout) {
        WebDriverWait wait =  new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(elem));
    }

    public static WebElement waitForClickability (By locator, int timeout) {
        WebDriverWait wait =  new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
