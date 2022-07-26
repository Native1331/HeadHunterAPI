/**package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    /**
     * static String login = "qaguru@qa.guru",
     * password = "qaguru@qa.guru1",
     * authCookieName = "NOPCOMMERCE.AUTH";
     *
    Faker faker = new Faker();
    String login = faker.internet().emailAddress();
    String password = faker.password().password();

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        baseUrl = "https://hh.ru/";
        RestAssured.baseURI = "https://hh.ru/";
        open(baseUrl);
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }

}
**/