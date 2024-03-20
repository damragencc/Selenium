import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_ilkOtomasyon {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/Kurulum Dosyalari/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://testotomasyonu.com");
    }
}
