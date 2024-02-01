package org.ua.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {

    public DragAndDropPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "box1")
    private WebElement oslo;

    @FindBy(id = "box2")
    private WebElement stockholm;

    @FindBy(id = "box105")
    private WebElement southKorea;

    @FindBy(id = "box102")
    private WebElement sweden;

    public String getOsloText()
    {
        return oslo.getText();
    }

    public DragAndDropPage moveOsloToSouthKorea()
    {
        new Actions(driver).dragAndDrop(oslo,southKorea).build().perform();
        return this;
    }
    public DragAndDropPage moveStockholmToSweden()
    {
        new Actions(driver).dragAndDrop(stockholm,sweden).build().perform();
        return this;
    }
}
