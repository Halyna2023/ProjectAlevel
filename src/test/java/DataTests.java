
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;


public class DataTests {


    public WebDriver webDriver;

    @DataProvider(name = "Date")
    public Object[][] searchDate()
    {
        return new Object[][]{
                {"electronics"},
                {"domestic-equipment"},
                {"123"},
        };
    }

    @BeforeMethod

    public void before(){
        webDriver = new ChromeDriver();
        webDriver.get("https://pn.com.ua/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void after(){
        webDriver.quit();
    }

    @Test(dataProvider = "Date")
    public void checkSearch(String data){
        WebElement input = webDriver.findElement(By.xpath("//input[@class='search-text-input']"));
        input.sendKeys(data);
        input.sendKeys(Keys.ENTER);
        System.out.println(data);
    }

}

