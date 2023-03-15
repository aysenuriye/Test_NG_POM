package tests.day11_POM_assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.security.Key;

public class C01_configReaderKullanimi {

    @Test
    public void test01(){

        //amazona gidelim

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //Nutella içi arama yap
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);
        //arama sonçlarının nutella içerdiğini test et
String expectedIcerik= ConfigReader.getProperty("amazonAranacakKelime");
String actualAramaSonucYazisi= amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik));

        Driver.closeDriver();


    }
}
