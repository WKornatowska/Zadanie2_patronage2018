package com.intive.patronage.tests;

import com.google.common.util.concurrent.FluentFuture;
import com.sun.deploy.util.Waiter;
import com.sun.javafx.jmx.HighlightRegion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.Highlighter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class SearchGoogle {
    public SearchGoogle() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver\\chromedriver.exe"); //path to googledriver
    }

    @Test
    public void TestGoogleSearch() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String searchTerm = "intive";
        String matchUrl = "https://www.intive.com";

        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys(searchTerm);
        driver.findElement(By.name("btnK")).click();

        int rank = 0;
        boolean foundMatch = false;
        List<WebElement> results = driver.findElements(By.cssSelector("h3.r > a "));
        for (WebElement element : results) {
            rank += 1;
            String link = element.getAttribute("href");
            if (link.contains(matchUrl)) {
                System.out.println("Website position in search results: " + rank);
                foundMatch = true;
                assert(rank == 1);
                break;
            }
        }
        assert(foundMatch==true);
        }
    }










