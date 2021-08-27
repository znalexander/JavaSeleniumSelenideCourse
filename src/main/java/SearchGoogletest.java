import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchGoogletest {

    @Test
    public void testSearchGoogle() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.navigate().to("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys("купить кофемашину bork c804");
        searchBox.submit();
        WebElement searchPage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@aria-label=\"Page 3\"]")));
        searchPage.click();
        WebElement targetUrl = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//cite[@class=\"iUh30 Zu0yb qLRx3b tjvcx\"])[17]")));
        String textTargetUrl = targetUrl.getAttribute("textContent");

        System.out.println("textTargetUrl->" + textTargetUrl);
        Assert.assertEquals("https://www.mvideo.ru › ... › Кофейные станции › Bork", textTargetUrl);

        driver.quit();
    }
}
