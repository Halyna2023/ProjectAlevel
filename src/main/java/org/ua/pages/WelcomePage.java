package org.ua.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class WelcomePage extends BasePage {

    public WelcomePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//div/a[@href='/computer/']")
    private WebElement computer;

    @FindBy(xpath = "//div/a[@href='/electronics/'")
    private WebElement electronics;

    @FindBy(xpath = "//div/a[@href='/domestic-equipment/'")
    private WebElement domestic_equipment;

    @FindBy(xpath = "//div/a[@href='/furniture/'")
    private WebElement furniture;

    @FindBy(xpath = "//input[@class]")
    private WebElement searchTextInput;

    @FindBy(xpath = "//nav/ul/li[2]/a")
    //@FindBy(xpath = "//a[@href='/fm/']")
    private WebElement stor;

    @FindBy(xpath = "//nav/ul/li[1]/a/span")
    private WebElement goods;


    public String getComputerText()
    {
        return computer.getText();
    }

    public WelcomePage moveOsloToSouthKorea()
   {
       new Actions(driver).dragAndDrop(goods,stor).build().perform();
       return this;
    }
    public WelcomePage moveStockholmToSweden()
    {
        new Actions(driver).dragAndDrop(domestic_equipment,electronics).build().perform();
        return this;
    }
}



