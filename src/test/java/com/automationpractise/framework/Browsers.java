package com.automationpractise.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.automationpractise.staticvariables.StaticVariables.DOWNLOAD_DIRECTORY_PATH;

public class Browsers {
    public WebDriver driver;
    ChromeOptions options=new ChromeOptions();

    public WebDriver open(String browser){
         switch (browser){
             case "chrome":
             {   WebDriverManager.chromedriver().setup();
                 options = new ChromeOptions();
                 Map<String, Object> prefs = new HashMap<>();
                 prefs.put("profile.default_content_settings.popups", 0);
                 prefs.put("download.default_directory",DOWNLOAD_DIRECTORY_PATH);
                 options.setExperimentalOption("prefs", prefs);
                 options.setExperimentalOption("excludeSwitches",
                         List.of("disable-popup-blocking"));
                 driver = new ChromeDriver(options);}
                 break;
             case "firefox":
                 WebDriverManager.firefoxdriver().setup();
                 driver=new FirefoxDriver();
                 break;
             case "msedge":
                 WebDriverManager.edgedriver().setup();
                 driver=new EdgeDriver();
                 break;
             default:
                 System.out.println("There is no such browser");
                 break;
        }
        return driver;
    }
}
