package day03_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_RelativeLocators {
    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver","src/Kurulum Dosyalari/chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1 ) https://testotomasyonu.com/relativeLocators adresine gidin
        driver.get("https://testotomasyonu.com/relativeLocators");

        //2 ) DSLR Camera’yi etrafindaki elementleri kullanarak 3 farkli relative locator ile locate edip tiklayin

        //3 ) Acilan urunun DSLR Camera oldugunu test edin.
    }
}
