import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_DriverManageMethodlari {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("Webdriver.chrome.driver","src/Kurulum Dosyalari/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");

        Thread.sleep(3000);

        //sayfanin acilmasi veya sayfada aradigimiz web elementleri
        //bulmak icin belirlenen maximum bekleme süresidir.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
