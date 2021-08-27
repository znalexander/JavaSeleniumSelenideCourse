import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReqresIn {
    @Test
    public void testReqresIn() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("https://reqres.in/");

        WebElement searchEndpointSingleUser = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@data-id=\"users-single\"]")));
        searchEndpointSingleUser.click();

        WebElement checkStatus = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-key=\"response-code\"]")));
        String textStatus = checkStatus.getAttribute("innerText");

        System.out.println("Response->" + textStatus);
        Assert.assertEquals("200", textStatus);

        WebElement checkFirstName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//pre[@data-key=\"output-response\"]")));
        String textFirstName = checkFirstName.getAttribute("textContent");
        String substr = "first_name";
        String substrValue = "Janet";
        boolean fname = textFirstName.contains(substr);
        boolean valueFname = textFirstName.contains(substrValue);
        if (fname && valueFname) {
            textFirstName = "first_name = \"Janet\"";
        }
        System.out.println("textFirstName->" + textFirstName);
        Assert.assertEquals("first_name = \"Janet\"", textFirstName);

        driver.quit();
    }
}
