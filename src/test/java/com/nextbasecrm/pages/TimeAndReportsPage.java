package com.nextbasecrm.pages;

//import com.nextbasecrm.utils.Driver;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TimeAndReportsPage extends BasePage{

    @FindBy(xpath = "//span[@class='main-buttons-item-text-title']")
    public List <WebElement> featureList;



    public void clickOnFeatureOf (String feature) {
        for (WebElement webElement : featureList) {
            if (webElement.getText().equals(feature)) {
                webElement.click();
                break;
            }
        }
    }

    public WebElement getFeatureElementOf (String feature) {
        for (WebElement webElement : featureList) {
            if (webElement.getText().equals(feature)) {
                return webElement;
            }
        }
        return null;
    }

}
