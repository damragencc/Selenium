import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C08_Xpath {
    public static void main(String[] args) throws InterruptedException {
        //gerekli ayarlari yapin
        System.setProperty("Webdriver.chrome.driver","src/Kurulum Dosyalari/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //testotomasyon.com adresine gidin
        driver.get("http://www.testotomasyonu.com");

        Thread.sleep(2000);

        //phone icin arama yapin
        WebElement arananKutu=driver.findElement(By.xpath("//input[@class='search-input']"));
        arananKutu.sendKeys("phone"+ Keys.ENTER);

        //bulunan sonuc yazisini yazdirin
        WebElement bulunansonuc=driver.findElement(By.xpath("//span[@class='product-count-text']"));
        System.out.println(bulunansonuc.getText());

        //bulunan sonuclarin 2' den fazla oldugunu test edin
        int extendetSonuc=2;
        int actualySonuc=Integer.parseInt(bulunansonuc.getText().replaceAll("\\D",""));

        if (actualySonuc>extendetSonuc){
            System.out.println("test PASSED");
        }else System.out.println("test FAİLED");

        //bulunan urunlerden ikincisine tiklayin
        List<WebElement> urunler=driver.findElements(By.xpath("//div[@Class='product-box my-2  py-1']"));
        urunler.get(1).click();


        //acılan ürün sayfasinda, urun isminde
        //case sensitive olmadan phone gectigini test edin

        WebElement sensvite= driver.findElement(By.xpath("//div[@Class='heading-sm mb-4']"));
        String expectedYazi="phone";
        String actualyYazi=sensvite.getText().toLowerCase();

        if (actualyYazi.contains(expectedYazi)){
            System.out.println("test PASSED");

        }else System.out.println("test FAİLED");



        //sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();
    }
}
