package org.ua.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class MainPage extends BasePage {
    public MainPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//*[@cz-shortcut-listen]")
    public WebElement  contacts;
}



