package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class AuthorizationTests {
    @Test
    @Tag("hhApi")
    @DisplayName("Successful authorization in Head Hunter (UI)")
    void loginTest() {
        step("Open login page", () ->
                open("https://hh.ru/"));

        step("Fill login form", () -> {
            $(byLinkText("Войти")).click();
            $(byName("login")).val("kadyshevani@gmail.com");
            $(".account-login-actions > .bloko-link").click();
            $(".bloko-input_password").val("nata1984");
            $(".bloko-input_password").sendKeys(Keys.ENTER);
            $(".supernova-icon_profile").click();
        });

        step("Verify successful authorization", () ->
                $(".supernova-dropdown-option").shouldHave(text("Наталья Кадышева")));
    }


    @Test
    @Tag("hhApi")
    @DisplayName("Successful authorization on HeadHunter (API + UI)")
    void loginWithApiTest() {
        step("Get cookie by api and set it to browser", () -> {
                    String authCookieValue = given()
            /**"wCbVwXp9Lah4TZckJ0aP5FmN2eHoEhd0ml5j0LIgX78rDCCFXg6HvVeqVy____IkQnfDqwfKQS" +
                            "HowiIEY-ztUGNvT7_F_____Xm84D2_T4i4SW"**/
            /**is_gdpr=0; _ym_uid=1624963633381066981; amcuid=3340381671658151918;
                     yandexuid=2025334541624963637; yuidss=2025334541624963637; ymex=1660758712.
                     oyu.3312580701658090225#1973450225.yrts.1658090225#1973526712.yrtsi.1658166712;
                     gdpr=0; yandex_login=kadyshevani@gmail.com;
                     i=ptl3v7jfgAN8PMH/vgkCh0hOFFb9Jovyme5NQHmeDBwBLCpnRDYTjmDRWRAxwuqUp4nUSMv+BypekmS8Y3VArzlnxVA=;
                     yandex_gid=10867; is_gdpr_b=CNiMXhDKfygC; my=YwA=; _ym_d=1658593960;
                     Session_id=3:1658606362.5.0.1658342278197:CVqtTw:87.1.2:1|1508546496.-1.0.1:305379775|3:10255705.599146.61
                     jCEwWfqYB_BqieaLHm9lU894Q; sessionid2=3:1658606362.5.0.1658342278197:CVqtTw:87.1.2:1.499:1|1508546496.
                     -1.0.1:305379775|3:10255705.828057.xo_eUdJ1VbstU3BFgX5V8ECEmFY;
                     cycada=NT90rHap/YHhCiNosLRx5naRzHzi07lBI/9HUrVVzOM=;
                     yabs-frequency=/5/0W010B4Xss8ZsjfY/sLLbIOQoDsUmHoUjbSQ9XQIvPQn7O-
                     wCbVwXp9Lah4TZckJ0aP5FmN2eHoEhd0ml5j0LIgX78rDCCFXg6HvVeqVy____IkQnfDqwfKQSHowiIEY-ztUGNvT7_F_____Xm84D2_T4i4SW/; yabs-sid=802555121658836385()**/
                    .contentType("application/x-www-form-urlencoded")
                            .formParam("Email", "kadyshevani@gmail.com")
                            .formParam("Password", "nata1984")
//                .body("Email=" + login + "&Password=" + password + "&RememberMe=false")
//                .body(format("Email=%s&Password=%s&RememberMe=false", login, password))
                            .log().all()
                            .when()
                            .post("https://gatchina.hh.ru/")
                            .then()
                            .log().all()
                            .statusCode(302)
                            .extract().cookie("authCookieName)");
                });
    }
}

/**

 @Test
 @DisplayName("Successful authorization to some demowebshop (API + UI)")
 void loginWithApiTest() {
 step("Get cookie by api and set it to browser", () -> {
 String authCookieValue = given()
 .contentType("application/x-www-form-urlencoded")
 .formParam("Email", login)
 .formParam("Password", password)
 //                .body("Email=" + login + "&Password=" + password + "&RememberMe=false")
 //                .body(format("Email=%s&Password=%s&RememberMe=false", login, password))
 .log().all()
 .when()
 .post("/login")
 .then()
 .log().all()
 .statusCode(302)
 .extract().cookie(authCookieName);

 step("Open minimal content, because cookie can be set when site is opened", () ->
 open("/Themes/DefaultClean/Content/images/logo.png"));
 step("Set cookie to to browser", () -> {
 Cookie authCookie = new Cookie(authCookieName, authCookieValue);
 WebDriverRunner.getWebDriver().manage().addCookie(authCookie);
 });
 });

 step("Open main page", () ->
 open(""));
 step("Verify successful authorization", () ->
 $(".account").shouldHave(text(login)));
 }


    /**public final static String USERNAME = "kadyshevani@gmail.com",
            PASSWORD = "",
            XSRF_TOKEN = "95a50912-56ff-4573-8b6f-e3e7f35460c4";


    public static String getAllureTestopsSession() {

        given()
                .header("X-XSRF-TOKEN", XSRF_TOKEN)
                .cookie("XSRF-TOKEN", XSRF_TOKEN)
                .formParam("username", USERNAME)
                .formParam("password", PASSWORD)
                .log().all()
                .when()
                .post("/login/system")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response()
                .getCookie("ALLURE_TESTOPS_SESSION");
    }

}**/


