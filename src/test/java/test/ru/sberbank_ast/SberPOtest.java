package test.ru.sberbank_ast;

import net.bytebuddy.pool.TypePool;
import org.junit.Assert;
import org.junit.Test;
import test.PageObject.FirstPage;
import test.PageObject.SecondPage;
import test.WebDriverSetting;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class SberPOtest extends WebDriverSetting {
    @Test
    public void SberPOtest() throws InterruptedException {
        chromeDriver.get("https://www.sberbank-ast.ru");
        FirstPage sberFP = new FirstPage(chromeDriver);
        sberFP.searchSubMenu("Закупки","Закупки по 44-ФЗ");

        SecondPage sberSP=new SecondPage(chromeDriver);
        sberSP.search("Страхование");
        Thread.sleep(3000);

        int amountOfElements = 120,currentElement = 0, page = 1, minNumbOfElements=10;
        while (currentElement < amountOfElements) {
            sberSP.reFreshListOfPrice();
            sberSP.reFreshRequestNumb();
            sberSP.reFreshReqLink();

            for (int j = 0; j < sberSP.getListOfPrice().size(); j++) {
                if (currentElement < amountOfElements) {
                    currentElement++;
                    double doublePrice = Double.parseDouble(sberSP.getListOfPrice().get(j).getText().replaceAll("\\s", ""));

                    sberSP.addToFit(doublePrice,j);
                }
            }
            page++;
            sberSP.clickNextButton(page);
            Thread.sleep(4000);

        }

        log.log(Level.INFO,"Номера сделок: "+sberSP.getRequestNumLink());
        Boolean check=false;
        if (sberSP.getRequestNumLink().size()>=minNumbOfElements)
            check=true;
        Assert.assertTrue(check);
    }
}
