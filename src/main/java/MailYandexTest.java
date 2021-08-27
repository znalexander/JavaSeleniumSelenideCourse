import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class MailYandexTest {
    @Test
    public void loginTestMailYandex() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://yandex.ua");

        WebElement loginMail = driver.findElement(By.xpath("//a[@data-statlog=\"notifications.mail.logout.mail\"]"));
        loginMail.click();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        WebElement loginId = driver.findElement(By.name("login"));
        loginId.sendKeys("my@yandex.ua");

        WebElement loginButton = driver.findElement(By.id("passp:sign-in"));
        loginButton.click();

        WebElement pass = driver.findElement(By.name("passwd"));
        pass.sendKeys("pass");

        WebElement passButton = driver.findElement(By.id("passp:sign-in"));
        passButton.click();
    }
}
