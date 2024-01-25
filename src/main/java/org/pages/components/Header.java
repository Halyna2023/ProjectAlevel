package org.pages.components;

import org.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage {
    public Header(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "box1")
    public WebElement menu;

}
