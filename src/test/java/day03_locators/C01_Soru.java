package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Soru {
    public static void main(String[] args) throws InterruptedException {
        //1- https://testotomasyonu.com/addremove/ adresine gidin
        //2- Add Element butonuna basin
        //3- Remove butonu’nun gorunur oldugunu test edin
        //4- Remove tusuna basin
        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        System.setProperty("Webdriver.chrome.driver","src/Kurulum Dosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        //1- https://testotomasyonu.com/addremove/ adresine gidin

        driver.get("https://testotomasyonu.com/addremove/");


            //2- Add Element butonuna basin
           driver.findElement(By.id("sub-btn")).click();

        //3- Remove butonu’nun gorunur oldugunu test edin
        WebElement removeButonElementi= driver.findElement(By.className("remove-btn"));

        if (removeButonElementi.isDisplayed()){
            System.out.println("Remove butonu gorunme testi PASSED");
        }else   System.out.println("Remove butonu gorunme testi FAİLED");

        //4- Remove tusuna basin

        removeButonElementi.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveYaziElementi= driver.findElement(By.tagName("h2"));

        if (addRemoveYaziElementi.isDisplayed()){
            System.out.println("test PASSED");
        }else System.out.println("test FAİLED");

        Thread.sleep(3000);
        driver.quit();

    }
}
