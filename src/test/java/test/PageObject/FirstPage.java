package test.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstPage {
    private WebDriver chromeDriver;
    private WebElement subMenu;
    private WebElement linkSubMenu;


    public FirstPage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;

    }

    public void searchSubMenu(String zakupki,String vid_zakupki)
    {
        subMenu = chromeDriver.findElement(By.xpath("//li[span=\""+zakupki+"\"]"));
        subMenu.click();
        linkSubMenu = chromeDriver.findElement(By.xpath("//li[a=\""+vid_zakupki+"\"]"));
        linkSubMenu.click();

    }
}
