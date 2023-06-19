package ru.netology.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BaseTest {

    @BeforeAll
    public static void setup() {
        Configuration.baseUrl = "http://localhost:7777";
        Configuration.headless = Boolean.parseBoolean(System.getProperty("selenide.headless"));
    }

}
