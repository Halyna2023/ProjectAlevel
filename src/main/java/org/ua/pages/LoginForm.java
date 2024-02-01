package org.ua.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.ua.pages.components.Footer;
import org.ua.pages.components.Header;



public class LoginForm extends BasePage {

    @FindBy(xpath = "//body")
    public WebElement bodyOne;
    public Footer footer;
    public Header header;

    public LoginForm(WebDriver driver) {
        super(driver);
        this.footer = new Footer(driver);
        this.header = new Header(driver);
    }

    public  PageOne clickOnFooterAndHeader()
    {
        footer.contacts.click();
        header.menu.click();
        return this.clickOnFooterAndHeader();
    }
}
