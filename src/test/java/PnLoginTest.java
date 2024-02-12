import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PnLoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://pn.com.ua/");

        // Находим элемент "Войти" и кликаем по нему
        WebElement loginButton = driver.findElement(By.xpath("//nav/ul/li[3]/span/a"));
        loginButton.click();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Facebook authentication")
    @Owner("Halyna Olifirenko")
    public void LoginForm() {

        // Нахождение полей ввода логина и пароля
        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"login-form-login\"]"));
        usernameField.sendKeys("TestTestTest@test.t");
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"login-form-password\"]"));

        // Ввод логина и пароля
        passwordField.sendKeys("test123!");

        // Нахождение кнопки входа и клик на ней
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"loginButton\"]"));
        submitButton.click();

        // Дополнительные проверки или утверждения
        // Получение URL новой страницы
        String newPageUrl = driver.getCurrentUrl();

        // Проверка, что URL новой страницы не равен URL предыдущей страницы (простой способ проверки перехода)
        if (newPageUrl.equals("https://pn.com.ua/")) {
            System.out.println("Successful!");
        } else {
            System.out.println("Error: transition to a new page failed!");
        }

        // Закрытие браузера
        driver.quit();
    }
}
