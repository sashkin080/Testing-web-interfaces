import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class CartOrderTest {
    private WebDriver driver;

    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:9999/");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldBePositiveTest() {
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Иванов Иван- Иван");
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("+79045555555");
        driver.findElement(By.cssSelector("[class=\"checkbox__box\"]")).click();
        driver.findElement(By.cssSelector("button")).click();
        String actualText = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();
        String expectedText = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее врем.";
        Assertions.assertEquals(expectedText, actualText);
    }

    @Test
    void shouldBePositiveTest1() {
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Иван");
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("+79999999999");
        driver.findElement(By.cssSelector("[class=\"checkbox__box\"]")).click();
        driver.findElement(By.cssSelector("button")).click();
        String actualText = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();
        String expectedText = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее врем.";
        Assertions.assertEquals(expectedText, actualText);
    }


}



