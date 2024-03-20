package day02_webelement_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_DriverMethodlariSoru {
    public static void main(String[] args) throws InterruptedException {

       // 1.Yeni bir class olusturalim (Homework)
        //2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook” oldugunu test edin, degilse dogru basligi yazdirin.
        //3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        //4.https://www.walmart.com/ sayfasina gidin.
        //5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        //6. Tekrar “facebook” sayfasina donun
        //7. Sayfayi yenileyin
        //8. Sayfayi tam sayfa (maximize) yapin
        //9.Browser’i kapatin


        System.setProperty("Webdriver.chrome.driver","src/Kurulum Dosyalari/chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        driver.get("https://www.facebook.com");

      //  sayfa basliginin (title) “facebook” oldugunu test edin, degilse dogru basligi yazdirin.

        String expectedTitle="facebook";
        String actualTitle=driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Facebook title testi PASSED");
        }else{
            System.out.println("Facebook title testi FAİLED");
            System.out.println(actualTitle);
        }

        //3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.

        String expectedUrlICerik="facebook";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedTitle)){
            System.out.println("Facebook Url testi PASSED");
        }else {
            System.out.println("Facebook Url testi FAİLED");
            System.out.println(actualUrl);
        }

        Thread.sleep(3000);


        //4.https://www.walmart.com/ sayfasina gidin
        driver.get("http://www.walmart.com");

        //5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String expectedTitleIcerik="Walmart.com";
        actualTitle=driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Walmart title testi PASSED");

        }else {
            System.out.println("Walmart title testi FAİLED");
        }

        //6. Tekrar “facebook” sayfasina donun

        driver.navigate().back();
        Thread.sleep(3000);

        //7. Sayfayi yenileyin

        driver.navigate().refresh();

        //8. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        //9.Browser’i kapatin
        driver.quit();






    }
}
