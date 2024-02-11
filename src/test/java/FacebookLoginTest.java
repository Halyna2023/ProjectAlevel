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
import java.util.concurrent.atomic.AtomicReference;


public class FacebookLoginTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        // Enter valid email
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"social-auth\"]/div[1]/a"));
        emailInput.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(2000); // Подождите, чтобы убедиться, что новая страница загружена (это не самый лучший способ, но простой для примера)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Получение URL новой страницы
        String newPageUrl = driver.getCurrentUrl();

        // Проверка, что URL новой страницы не равен URL предыдущей страницы (простой способ проверки перехода)
        if (!newPageUrl.equals("https://www.facebook.com/login.php?skip_api_login=1&api_key=1204461136295750&kid_directed_site=0&app_id=1204461136295750&signed_next=1&next=https%3A%2F%2Fwww.facebook.com%2Fdialog%2Foauth%3Fclient_id%3D1204461136295750%26response_type%3Dcode%26redirect_uri%3Dhttps%253A%252F%252Fpn.com.ua%252Fmy%252Fo%252Ffacebook%252F%26xoauth_displayname%3D%25D0%259F%25D1%2580%25D0%25B0%25D0%25B9%25D1%2581%2B%25D0%25BD%25D0%25B0%25D0%25B2%25D0%25B8%25D0%25B3%25D0%25B0%25D1%2582%25D0%25BE%25D1%2580.%2B%25D0%25A5%25D0%25B0%25D1%2580%25D1%258C%25D0%25BA%25D0%25BE%25D0%25B2%26scope%3Demail%26state%3Dc52322bd668ac51828edeafacec04f953dc8a19380f071a2eb3f281d13c14da8%26ret%3Dlogin%26fbapp_pres%3D0%26logger_id%3D4231bfac-07d7-4422-8565-7c2fce445d85%26tp%3Dunspecified&cancel_url=https%3A%2F%2Fpn.com.ua%2Fmy%2Fo%2Ffacebook%2F%3Ferror%3Daccess_denied%26error_code%3D200%26error_description%3DPermissions%2Berror%26error_reason%3Duser_denied%26state%3Dc52322bd668ac51828edeafacec04f953dc8a19380f071a2eb3f281d13c14da8%23_%3D_&display=page&locale=ru_RU&pl_dbl=0")) {
            System.out.println("Переход на новую страницу выполнен успешно!");
        } else {
            System.out.println("Ошибка: переход на новую страницу не выполнен!");
        }

        // Закрытие браузера
        driver.quit();
    }
        }



