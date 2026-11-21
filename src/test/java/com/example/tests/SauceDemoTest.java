package com.example.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Sample test against the public SauceDemo practice site.
 * Replace the URL and locators with your own application as needed.
 */
public class SauceDemoTest extends BaseTest {

    @Test(description = "Log in to SauceDemo and verify the inventory page")
    public void verifyLogin() {
        driver.get("https://www.saucedemo.com/");

        Assert.assertEquals(driver.getTitle(), "Swag Labs", "Login page title should match");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("inventory.html"));

        Assert.assertEquals(driver.findElement(By.className("title")).getText(), "Products",
                "Inventory page heading should match");
    }
}
