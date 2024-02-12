import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;


public class TransitionDataPage{


    public WebDriver webDriver;

    @DataProvider(name = "Date")
    public Object[][] searchDate()
    {
        return new Object[][]{
               
                {"LG"},
        };
    }

    @BeforeMethod

    public void before(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
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
   



    // Получение URL новой страницы
        String newPageUrl = webDriver.getCurrentUrl();

        // Проверка, что URL новой страницы не равен URL предыдущей страницы (простой способ проверки перехода)
        if (!newPageUrl.equals("https://pn.com.ua/search/?fn=LG")) {
            System.out.println("Error!");
        } else {
            System.out.println("You have successfully navigated to the new page!");
        }

        // Закрытие браузера
        webDriver.quit();
    }

}