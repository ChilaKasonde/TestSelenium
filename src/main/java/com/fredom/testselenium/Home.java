/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fredom.testselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Chila
 */
public class Home {

    public static void main(String[] args) throws InterruptedException {

        //Mozilla works better than Chrome
        testelementByID();

    }

    public static void testMozilla() {

        // Try-Catch Block For Implementing Sleep Method
        try {
            // String Where Home Page URL Is Stored
            String baseUrl = "https://www.google.com/";

            // Implementation of SetProperty Method
            //download gecko driver here: https://github.com/mozilla/geckodriver/releases
            System.setProperty(
                    "webdriver.gecko.driver",
                    "C:\\selenium\\geckodriver.exe");

            // Creating New Object driver Of Webdriver
            WebDriver driver = new FirefoxDriver();

            // Calling the Home Page By Using Get() Method
            driver.get(baseUrl);

            // Delaying The Output
            Thread.sleep(2000);

            // Closing The Opened Window
            driver.quit();
        } catch (Exception e) {
            // Catching The Exception
            System.out.println(e);
        }
    }

    public static void testChrome() {

        // Try-Catch Block For Implementing Sleep Method
        try {
            // String Where Home Page URL Is Stored
            String baseUrl = "https://www.google.com/";

            // Implementation of SetProperty Method
            System.setProperty(
                    "webdriver.chrome.driver",
                    "C:\\selenium\\chromedriver.exe");

            // Creating New Object driver Of Webdriver
            WebDriver driver = new ChromeDriver();

            // Calling the Home Page By Using Get() Method
            driver.get(baseUrl);

            // Delaying The Output
            Thread.sleep(3000);

            // Closing The Opened Window
            driver.quit();
        } catch (Exception e) {
            // Catching The Exception
            System.out.println(e);
        }
    }

    public static void testGoogleSearch() throws InterruptedException {

        // Optional. If not specified, WebDriver searches the PATH for chromedriver.       
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/");

        Thread.sleep(5000);  // Let the user actually see something!     

        WebElement searchBox = driver.findElement(By.name("q"));

        searchBox.sendKeys("ChromeDriver");

        searchBox.submit();

        Thread.sleep(5000);  // Let the user actually see something!     

        driver.quit();

    }

    public static void testGetTitle() {
        //download gecko driver here: https://github.com/mozilla/geckodriver/releases
        System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        //comment the above 2 lines and uncomment below 2 lines to use Chrome

        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        //close Fire fox
        driver.close();
    }

    public static void testelementByID() {
        //download gecko driver here: https://github.com/mozilla/geckodriver/releases
        System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://www.facebook.com";
        String tagName = "";
        String expectedTitle = "input";

        driver.get(baseUrl);
        //tag name describes what kind of html tag something 
        tagName = driver.findElement(By.id("email")).getTagName();
        System.out.println("TAG name:" + tagName);

        //check tag type
        if (tagName.contentEquals(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        //close browser
        driver.close();
        //close application
        System.exit(0);
    }

}
