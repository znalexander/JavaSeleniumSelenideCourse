import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MailYandexTest {
    @Test
    public void loginTestMailYandex() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://yandex.ua");

        WebElement loginMail = driver.findElement(By.xpath("//a[@data-statlog=\"notifications.mail.logout.mail\"]"));
        loginMail.click();
    }
}
