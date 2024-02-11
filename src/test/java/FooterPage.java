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

public class FooterPage {
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
    @Description("Check that searching is working")
    @Owner("Halyna Olifirenko")
    public void successfulSearch() {
        final String searchQuery = "Тактичне взуття ";

        WebElement searchField = driver.findElement(By.xpath("//div[5]/div/div[2]/ul/li[5]/a"));
        searchField.sendKeys(searchQuery);
        searchField.sendKeys(Keys.ENTER);


        // Получение URL новой страницы
        String newPageUrl = driver.getCurrentUrl();

        // Проверка, что URL новой страницы не равен URL предыдущей страницы (простой способ проверки перехода)
        if (!newPageUrl.equals("https://pn.com.ua/ct/6931/")) {
            System.out.println("Помилка: перехід на сторінку електороніка не виконано!");
                 } else {
            System.out.println("Перехід на нову сторінку електроніка виконано успішно!");
        }

        // Закрытие браузера
        driver.quit();
    }
}
