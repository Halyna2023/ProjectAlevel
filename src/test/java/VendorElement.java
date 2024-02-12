import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class VendorElement {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://pn.com.ua/");
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Check to see if the link in the footer of the page works")
    @Owner("Halyna Olifirenko")
    public void successfulSearch() {
        final String searchQuery = "Vendor";

        WebElement searchField = driver.findElement(By.xpath("//footer//a[@href='/vendor/']"));
        searchField.sendKeys(searchQuery);
        searchField.sendKeys(Keys.ENTER);


        // Получение URL новой страницы
        String newPageUrl = driver.getCurrentUrl();

        // Проверка, что URL новой страницы не равен URL предыдущей страницы (простой способ проверки перехода)
        if (!newPageUrl.equals("https://pn.com.ua/vendor/")) {
            System.out.println("Error: the link in the footer of the page is not working!");
        } else {
            System.out.println("The transition to a new page via the link in the footer was successful!");
        }

        // Закрытие браузера
        driver.quit();
    }
}
