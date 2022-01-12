package com.nextbasecrm.pages;

import com.nextbasecrm.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DriveMainPage {

    public DriveMainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='My Drive']")
    public WebElement myDriveTab;

    @FindBy (xpath = "//span[.='All Documents']")
    public WebElement allDocumentsTab;

    @FindBy (xpath = "//span[.='Company Drive']")
    public WebElement companyDriveTab;

    @FindBy (xpath = "//span[.='Sales and Marketing']")
    public WebElement salesAndMarketingTab;

    @FindBy (xpath = "//span[.='Sales and Marketing']")
    public WebElement moreTab;
}
