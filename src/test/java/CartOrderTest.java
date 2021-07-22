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
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void ShouldBePositiveTest () {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Иванов Иван- Иван");
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("+79045555555");
        // List<WebElement> textField = driver.findElements(By.className("input__control"));
        // textField.get(0).sendKeys("Александр");
        // textField.get(1).sendKeys("+79045555555");
        driver.findElement(By.cssSelector("[class=\"checkbox__box\"]")).click();
        driver.findElement(By.cssSelector("button")).click();
        String actualText = driver.findElement(By.cssSelector("p")).getText().trim();
        String expectedText = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        Assertions.assertEquals(expectedText, actualText);
    }

    @Test
    void ShouldBePositiveTest1 () {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Иван");
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("+79999999999");
        driver.findElement(By.cssSelector("[class=\"checkbox__box\"]")).click();
        driver.findElement(By.cssSelector("button")).click();
        String actualText = driver.findElement(By.cssSelector("p")).getText().trim();
        String expectedText = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        Assertions.assertEquals(expectedText, actualText);
    }




    }
   // @Test
   // void cardTest() {
   //     driver.get("http://localhost:9999/");
        //  driver.findElement() .sendKeys("Александр");
        //  driver.findElement() .sendKeys("+79045555555");
   //     List<WebElement> textField = driver.findElements(By.className("input__control"));
   //     textField.get(0).sendKeys("Александр");
   //     textField.get(1).sendKeys("+79045555555");
    //    driver.findElement(By.className("checkbox__box")) .click();
   //     driver.findElement(By.className("button")) .click();
    //    String actualText = driver.findElement(By.className("paragraph")) .getText().trim();
    //    String expectedText = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
     //   Assertions.assertEquals(expectedText, actualText);


   // }


