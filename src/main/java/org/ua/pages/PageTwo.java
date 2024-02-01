package org.ua.pages;


import org.ua.pages.components.Footer;
import org.ua.pages.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageTwo extends BasePage {

    @FindBy(xpath = "//body")
    public WebElement bodyTwo;
    public Footer footer;
    public Header header;


    public PageTwo(WebDriver driver) {
        super(driver);
        this.footer = new Footer(driver);
        this.header = new Header(driver);
    }

}
