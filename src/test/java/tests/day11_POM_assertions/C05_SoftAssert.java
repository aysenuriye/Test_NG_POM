package tests.day11_POM_assertions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Keys;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C05_SoftAssert extends TestBaseRapor {

    @Test(groups = "smoke")
    public void amazonTesti(){
        extentTest = extentReports.createTest("Pozitif login testi","gecerli bilgilerle giris yapilabilmeli");

        /*
            Genel olarak
            test edin denirse hard assert
            dogrulayin(verify) denirse soft assert kasdedilir
         */

            // amazon anasayfaya gidip, dogru sayfaya gittigimizi DOGRULAYIN (verify)
            Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
            String expectedIcerik= "amazon";
            String actualUrl= Driver.getDriver().getCurrentUrl();

            SoftAssert softAssert= new SoftAssert();
            softAssert.assertTrue(actualUrl.contains(expectedIcerik),"url amazon icermiyor");
          extentTest.pass("url amazon iceriyor");
            // Nutella icin arama yapip, sonuclarin Nutella icerdigini dogrulayin
            AmazonPage amazonPage= new AmazonPage();
            amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

            expectedIcerik ="Nutella";
            String actualAramaSonucYazisi= amazonPage.aramaSonucElementi.getText();
            softAssert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik),"arama sonucu Nutella icermiyor");
extentTest.pass("nutella iceriyor");

            // ilk urune tiklayip, urun isminde Nutella gectigini dogrulayin
            amazonPage.ilkUrun.click();
            expectedIcerik ="Nutella";
            String actualIlkUrunIsim= amazonPage.ilkUrunIsimElementi.getText();

            softAssert.assertTrue(actualIlkUrunIsim.contains(expectedIcerik),"ilk urun ismi Nutella icermiyor");
extentTest.pass("ilk urun gecerli");
            softAssert.assertAll();
            Driver.closeDriver();
        }
    }
