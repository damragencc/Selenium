package day02_webelement_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C07_XPATCHc {
    public static void main(String[] args) throws InterruptedException {
        //gerekli ayarlari yapin
        System.setProperty("Webdriver.chrome.driver","src/Kurulum Dosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //testotomasyon.com adresine gidin
        driver.get("http://www.testotomasyonu.com");

        //phone icin arama yapin
        WebElement arananElement= driver.findElement(By.xpath("//input[@class='search-input']"));
        arananElement.sendKeys("phone" +Keys.ENTER);

        //bulunan sonuc yazisini yazdirin
        WebElement sonucyazdir= driver.findElement(By.xpath("//span[@class='product-count-text']"));
        System.out.println(sonucyazdir.getText());


        //bulunan sonuclarin 2' den fazla oldugunu test edin

        int extectedSayi=2;
        int actualSayi=Integer.parseInt(sonucyazdir.getText().replaceAll("\\D",""));

        if (actualSayi>extectedSayi){
            System.out.println("test PASSED");
        }else System.out.println("test FAİLED");


        //bulunan urunlerden ikincisine tiklayin
        List<WebElement> urunListesi=driver.findElements(By.xpath("//div[@class='product-box my-2  py-1']"));
        urunListesi.get(1).click();

        //acılan ürün sayfasinda, urun isminde
        //case sensitive olmadan phone gectigini test edin

        WebElement urunyazi= driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        String expectedYazi="phone";
        String actualYazi=urunyazi.getText().toLowerCase();

        if (actualYazi.contains(expectedYazi)){
            System.out.println("test PASSED");

        }else System.out.println("test FAİLED");




        //sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();
    }
}

