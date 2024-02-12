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

public class TransitionComputerPage {
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
        final String searchQuery = "Комп'ютери";

        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"column-center\"]/section/div[1]/a"));
        searchField.sendKeys(searchQuery);
        searchField.sendKeys(Keys.ENTER);


        // Получение URL новой страницы
        String newPageUrl = driver.getCurrentUrl();

        // Проверка, что URL новой страницы не равен URL предыдущей страницы (простой способ проверки перехода)
        if (!newPageUrl.equals("https://pn.com.ua/computer/")) {
            System.out.println("Error: The transition to the Computers page failed!");
        } else {
            System.out.println("You have successfully navigated to the new Computers page!");
        }

        // Закрытие браузера
        driver.quit();
    }
}
