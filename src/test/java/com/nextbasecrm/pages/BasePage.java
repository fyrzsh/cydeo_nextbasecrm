package com.nextbasecrm.pages;

import com.nextbasecrm.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
//import java.util.NoSuchElementException;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "USER_LOGIN")
    public WebElement usernameInput;

    @FindBy(name = "USER_PASSWORD")
    public WebElement passwordInput;

    @FindBy (css = "login-text.login-item")         //using cssSelector and instead of space in the attribute value, we need dto put dot (.)
    public WebElement rememberThisComp;

    @FindBy (className = "login-btn")
    public WebElement loginButton;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotYourPasswordLink;

//----------------------------------------------------------------------

    @FindBy (className = "sitemap-menu-lines")
    public WebElement siteMapMenu;

    @FindBy (id = "logo_24_text")
    public WebElement homePageButton;

    @FindBy (className = "header-search-input")
    public WebElement searchBar;

    @FindBy (id = "timeman-background")
    public WebElement clockInAndOutButton;

    @FindBy (id = "user-name")
    public WebElement userMenu;

    @FindBy (className = "help-block-counter-wrap")
    public WebElement helpButton;

    @FindBy(xpath = "//span[@class='menu-item-link-text']")
    public List<WebElement> modules;

    @FindBy(className = "menu-favorites-more-text")
    public WebElement moreOrHideButton;

    @FindBy (id = "left-menu-settings")
    public WebElement configMenuButton;

    @FindBy (xpath = "//span[@class='menu-popup-item-text']")
    public List <WebElement> configMenuList;

    @FindBy (xpath = "//span[@id='pagetitle']")
    public WebElement featurePageTitle;

    @FindBy (id = "bx-im-bar-notify")
    public WebElement notificationButton;

    @FindBy (id = "bx-im-bar-search")
    public WebElement searchButton;

    @FindBy (xpath = "//span[.='Themes']")
    public WebElement themeButton;

    @FindBy (xpath = "//span[.='Print']")
    public WebElement printButton;


    public WebElement getModuleOf (String moduleName) {

        for (WebElement module : modules) {
            if(module.getText().equals(moduleName)) {
                return module;
            }
        }

        return null;

       // return Driver.getDriver().findElement(By.xpath("//a[.=' " + moduleName + " ']"));

        //        return Driver.getDriver().findElement(By.xpath("//li[@class='menu-item-block']/a[@title='" + moduleName + "']"));  //a[.=' " + moduleName + " ']
    }

    public void clickOnModuleOf (String moduleName) {

        for (WebElement module : modules) {
            if(module.getText().equals(moduleName)) {
                module.click();
                break;
            }
        }
    }

    public void clickOnMoreOrHide (String moreOrHide) {
        if ((moreOrHide+ "...").equalsIgnoreCase(moreOrHideButton.getText()) || moreOrHide.equalsIgnoreCase(moreOrHideButton.getText())) {
            moreOrHideButton.click();
        }
    }

    public WebElement getConfigMenuItemOf (String configMenuItem) {

        return Driver.getDriver().findElement(By.xpath("//span[@class='" + configMenuItem + " ']"));
    }

    public void login (String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

}
