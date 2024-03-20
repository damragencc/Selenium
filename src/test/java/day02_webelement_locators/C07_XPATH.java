package day02_webelement_locators;

import com.sun.tools.javac.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C07_XPATH {
    public static void main(String[] args) throws InterruptedException {

        //gerekli ayarlari yapin
        //testotomasyon.com adresine gidin
        //phone icin arama yapin
        //bulunan sonuc yazisini yazdirin
        //bulunan sonuclarin 2' den fazla oldugunu test edin
        //bulunan urunlerden ikincisine tiklayin
        //acılan ürün sayfasinda, urun isminde
        //case sensitive olmadan phone gectigini test edin
        //sayfayi kapatin
//

        //gerekli ayarlari yapin
        System.setProperty("Webdrive.chrome.drive","src/Kurulum Dosyalari/chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //testotomasyon.com adresine gidin
        driver.get("http://www.testotomasyonu.com");

        //phone icin arama yapin
        WebElement aramakutusu=driver.findElement(By.id("global-search"));
        aramakutusu.sendKeys("phone" + Keys.ENTER);

        //bulunan sonuc yazisini yazdirin
        WebElement sonucYaziElementi=driver.findElement(By.className("product-count-text"));
        System.out.println(sonucYaziElementi.getText());  // 4 Products Found

        //bulunan sonuclarin 2' den fazla oldugunu test edin
        int expectedMinSonuc=2;
        int actualSonucsayisi=Integer.parseInt(sonucYaziElementi.getText().replaceAll("\\D",""));

        if (actualSonucsayisi>expectedMinSonuc){
            System.out.println("Bulunan urun sayisi testi PASSED");
        }else System.out.println("Bulunan urun sayisi testi FAİLED");

        //bulunan urunlerden ikincisine tiklayin

        //once tum bulunan urunleri bir liste olarak kaydedelim

        //List<WebElement> bulunanURunElementlerList= driver.findElements(By.className("product-box my-2 py-1"));
        //class attribute'unun value'sunde space oldugu icin By.className() calismadi

        List<WebElement> bulunanURunElementlerList= driver.findElements(By.xpath("//div[@class='product-box my-2  py-1']"));
        bulunanURunElementlerList.get(1).click();

        //acılan ürün sayfasinda, urun isminde
        //case sensitive olmadan phone gectigini test edin

        WebElement urunisimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        String expectedIsımicerik="Phone";
        String actualUrunIsmiKucukHarf=urunisimElementi.getText().toLowerCase();

        if (actualUrunIsmiKucukHarf.contains(expectedIsımicerik)){
            System.out.println("Urun isim testi PASSED");
        }else  System.out.println("Urun isim testi FAİLED");






        //sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();
    }
}
