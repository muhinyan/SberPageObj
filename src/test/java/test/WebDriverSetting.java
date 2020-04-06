package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class WebDriverSetting {
    public static final Logger log=Logger.getLogger(WebDriverSetting.class.getName());
    public WebDriver chromeDriver;

    @Before
    public void setupGoogleTest(){
        log.info("Before");
        System.setProperty("webdriver.chrome.driver","/Users/mhn/Documents/chromedriver");
        chromeDriver=new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(80, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
    }

    @After
    public void closeGoogleTest(){
        log.info("After");
        chromeDriver.quit();
    }
}
