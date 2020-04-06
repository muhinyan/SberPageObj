package test.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.WebDriverSetting;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class SecondPage {
   
    private WebDriver chromeDriver;
    private WebElement searchField;
    private WebElement searchButton;
    private List<WebElement> listOfPrice;
    private List<WebElement> requestNumb;
    private WebElement nextButton;
    private List<WebElement>requestLink;
    private static final double minPrice=4000000;

    private Map<String,String> requestNumLink=new HashMap<>();//номер заявки и ссылка

    public static final Logger log=Logger.getLogger(SecondPage.class.getName());


    public SecondPage(WebDriver chromeDriver)
    {
        this.chromeDriver = chromeDriver;
        searchField = chromeDriver.findElement(By.xpath("//*[@id=\"searchInput\"]"));
        searchButton = chromeDriver.findElement(By.xpath("//*[@class=\"mainSearchBar-find\"]"));
        listOfPrice = chromeDriver.findElements(By.xpath("//*[@class=\"es-el-amount\"]"));
        requestNumb = chromeDriver.findElements(By.xpath("//*[@class=\"es-el-code-term\"]"));
        requestLink=chromeDriver.findElements(By.xpath("//*[@class=\"element-in-one-row\"]/*[@value=\"Просмотр\"]"));

    }
    public void search(String strahovanie)
    {
        searchField.sendKeys(strahovanie);
        searchButton.click();
    }
    public void reFreshListOfPrice()
    {
        listOfPrice = chromeDriver.findElements(By.xpath("//*[@class=\"es-el-amount\"]"));
    }
    public void reFreshRequestNumb()
    {
        requestNumb = chromeDriver.findElements(By.xpath("//*[@class=\"es-el-code-term\"]"));
    }
    public void reFreshReqLink()
    {
        requestLink = chromeDriver.findElements(By.xpath("//*[@class=\"element-in-one-row\"]/*[@value=\"Просмотр\"]"));
    }

    public List<WebElement> getListOfPrice()
    {
        return listOfPrice;
    }

    public void addToFit(double price,int j){
        if (price >= minPrice)
        {
            requestNumLink.put(requestNumb.get(j).getText(),requestLink.get(j).getText());//вставить ссылкуКАК
        }

    }
    public void clickNextButton(int page){
        nextButton = chromeDriver.findElement(By.xpath("//span[@id=\"pagesControl\"]/span[@id=\"pageButton\"]/span[@content=" + page + "]"));
        nextButton.click();
    }
    public Map<String,String> getRequestNumLink()
    {
        return requestNumLink;
    }
}
