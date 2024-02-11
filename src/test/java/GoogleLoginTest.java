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
import static java.util.concurrent.TimeUnit.SECONDS;


public class GoogleLoginTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, SECONDS);
        driver.get("https://pn.com.ua/");

        // Находим элемент "Войти" и кликаем по нему
        WebElement loginButton = driver.findElement(By.xpath("//nav/ul/li[3]/span/a"));
        loginButton.click();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Google authentication")
    @Owner("Halyna Olifirenko")
    public void LoginForm() {
        // Enter valid email
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"social-auth\"]/div[2]/a"));
        emailInput.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(2000); // Подождите, чтобы убедиться, что новая страница загружена (это не самый лучший способ, но простой для примера)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Получение URL новой страницы
        String newPageUrl = driver.getCurrentUrl();

        // Проверка, что URL новой страницы не равен URL предыдущей страницы (простой способ проверки перехода)
        if (!newPageUrl.equals("https://accounts.google.com/v3/signin/identifier?opparams=%253Fxoauth_displayname%253D%2525D0%25259F%2525D1%252580%2525D0%2525B0%2525D0%2525B9%2525D1%252581%252B%2525D0%2525BD%2525D0%2525B0%2525D0%2525B2%2525D0%2525B8%2525D0%2525B3%2525D0%2525B0%2525D1%252582%2525D0%2525BE%2525D1%252580.%252B%2525D0%2525A5%2525D0%2525B0%2525D1%252580%2525D1%25258C%2525D0%2525BA%2525D0%2525BE%2525D0%2525B2&dsh=S1258645832%3A1707654412449436&client_id=1046299562186-sq5o6pem0s2ctggkkfumilb5224bd65i.apps.googleusercontent.com&o2v=1&redirect_uri=https%3A%2F%2Fpn.com.ua%2Fmy%2Fo%2Fgoogle%2F&response_type=code&scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&service=lso&state=2d699268322413136f00418e3dc93cd3f801e14726c2c7a93a908a9a3cd9f82d&theme=glif&flowName=GeneralOAuthFlow&continue=https%3A%2F%2Faccounts.google.com%2Fsignin%2Foauth%2Fconsent%3Fauthuser%3Dunknown%26part%3DAJi8hAOhWPuVsxIdN3r4cgT0s7LvTupnB-DkLIEM2IPXP2OqWaUqKt4nxq4lmhREHaMrH2NRW5ZHntQPpF_NYFEI_TuZHC66tYKdS2ZoEqUmJbXQMegrBeJ5owt3sfMJ-l8FetKEMjYzzhkN-Vznv9lLJQloMwMSn23amH-KMuvP7lcT6PqgJCf9E5kI1SaqQSzpoG6noUcQRUVC5vI3qt37vLLuxhnQd-UuI_4ItLgTRmdFF-o7LVZIChOu8rPL46CVXbTXQwzA3t24vXqFfs65t9_A1NRnoNZ5J5Ce0KTFWidEJPRhUJSHYLAGhc-yqtMvpTkGRbZm2NRni_tIcy2yHRszMPH3HqX9HSSHsK8sRWbo97V3Ysjn49V01BCN81Qgdj-kBPD2KmXbzAY-nldyeYXw3KDqw-2cypnGW2UXFMft0dJmEcEO9-DTEioo4DsZke67KZB-Wr5OuJBvjcTLYDxvYMZn_A%26as%3DS1258645832%253A1707654412449436%26client_id%3D1046299562186-sq5o6pem0s2ctggkkfumilb5224bd65i.apps.googleusercontent.com%26theme%3Dglif%23&app_domain=https%3A%2F%2Fpn.com.ua&rart=ANgoxcc2pqspJcbX8Aw-j29t_xr_JT09jTSBf6Z3Qv5ho5x0SUpUsJJHS3COUXLXT6DE-68DihUlxe8MhjIlQuMd6uvbgUd56nu82eTYoAdYu6juDOdcVfI")) {
            System.out.println("Переход на новую страницу выполнен успешно!");
        } else {
            System.out.println("Ошибка: переход на новую страницу не выполнен!");
        }

        // Закрытие браузера
        driver.quit();
    }

    }


