import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestExampleJUni5 {
    @Test
    void exampleJUnit5() {

        step("Перейти на страницу Selenide в github", () -> {
            open("https://github.com/selenide/selenide");
        });
        step("Перейти в раздел Wiki", () -> {
            $("#wiki-tab").click();;
        });
        step("Проверить, что на странице есть раздел SoftAssertions", () -> {
            $(".js-wiki-more-pages-link").click();
            $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        });
        step("Перейти на страницу SoftAssertions", () -> {
            $("#wiki-pages-box").find(byText("SoftAssertions")).click();
        });
        step("Првоерка того,  что внутри есть пример кода для JUnit5", () -> {
            $(".markdown-body").shouldHave(text(
                    "@ExtendWith({SoftAssertsExtension.class})\n" +
                            "class Tests {\n" +
                            "@Test\n" +
                            "void test() {\n" +
                            "Configuration.assertionMode = SOFT;\n" +
                            "open(\"page.html\");\n" +
                            "\n" +
                            "$(\"#first\").should(visible).click();\n" +
                            "$(\"#second\").should(visible).click();\n" +
                            "}\n" +
                            "}"));
        });

//
    }

}
