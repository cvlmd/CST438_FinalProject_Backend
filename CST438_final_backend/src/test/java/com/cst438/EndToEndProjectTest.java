package com.cst438;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EndToEndProjectTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Users/louis/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        
        // Initialize the WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() throws InterruptedException {
       
        driver.get("http://localhost:3000/login");

        // Find and fill in the username and password fields
        WebElement usernameField = driver.findElement(By.id("username")); 
        WebElement passwordField = driver.findElement(By.id("password")); 

        usernameField.sendKeys("user");
        passwordField.sendKeys("user");

        // Find and click the login button
        WebElement loginButton = driver.findElement(By.id("login-button")); 
        loginButton.click();

        // Wait for a few seconds
        Thread.sleep(5000); // Sleep for 5 seconds

        
    }

    @AfterEach
    public void tearDown() {
        // Close the WebDriver
        if (driver != null) {
            driver.quit();
        }
    }
}
