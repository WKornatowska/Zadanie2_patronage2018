package com.intive.patronage.tests;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;


public class SearchGoogle {
    public SearchGoogle() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver\\chromedriver.exe");
    }

    @Test
    public void TestGoogleSearch() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String searchTerm = "intive";
        String matchUrl = "https://www.intive.com";

        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys(searchTerm,Keys.ENTER);

        int rank = 0;
        boolean foundMatch = false;
        List<WebElement> results = driver.findElements(By.cssSelector("h3.r > a "));
        for (WebElement element : results) {
            rank += 1;
            String link = element.getAttribute("href");
            if (link.contains(matchUrl)) {
                System.out.println("Website position in search results: " + rank);
                foundMatch = true;
                break;
            }
        }
        driver.close();
        assert(foundMatch = true);
        assert(rank == 1);
        }
    }










