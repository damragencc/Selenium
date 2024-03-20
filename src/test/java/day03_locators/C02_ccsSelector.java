package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_ccsSelector {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/Kurulum Dosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //2- https://www.testotomasyonu.com/ adresine gidin

        driver.get("https://www.testotomasyonu.com/");

        //3- Browseri tam sayfa yapin
       driver.manage().window().maximize();

        //4- Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5- Sayfa basliginin “Test Otomasyonu” ifadesi icerdigini test edin
        String expectedTitle="Test Otomasyonu";
        String actualTitle= driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAİLED");


        //6- Furniture linkine tiklayin
        driver.findElement(By.linkText("Furniture")).click();

        //7- price range filtresinde min degere 40, max degere 200 yazip filtreleyin
        WebElement minFiyatKutusu= driver.findElement(By.cssSelector("input[name='min']"));
        WebElement maxFiyatKutusu= driver.findElement(By.cssSelector("input[name='max']"));
        WebElement filtreButonu= driver.findElement(By.cssSelector("button[name='button']"));

        minFiyatKutusu.clear();
        minFiyatKutusu.sendKeys("40");
        maxFiyatKutusu.clear();
        maxFiyatKutusu.sendKeys("200");
        filtreButonu.click();


        //8- filtreleme sonucunda urun bulunabildigini test edin
        List<WebElement>bulunanElementler=driver.findElements(By.cssSelector("div[class'product-box mb-2 pb-1']"));
        if (bulunanElementler.size()>0){

            System.out.println("Test PASSED");
        }else System.out.println("Test FAİLED");


        //10-Ilk urunu tiklayin
        bulunanElementler.get(0).click();

        //11- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin

        WebElement urunfiyatı=driver.findElement(By.cssSelector("span[id='priceproduct']"));
        String urunFiyatıStr=urunfiyatı.getText().replaceAll("\\D","");
        double urunFiyatı=Double.parseDouble(urunFiyatıStr)/100;



        //12-Sayfayi kapatin

        Thread.sleep(3000);
        driver.quit();

    }
}
