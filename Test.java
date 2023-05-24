import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import javax.swing.plaf.basic.BasicSplitPaneUI;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Test {

    @org.junit.Test
    public void logoTest() {
        open("https://pethouse.ua/ua/about/oplata-i-dostavka/");
        $("#tpl-logo").click();

        assert WebDriverRunner.url().equals("https://pethouse.ua/ua/");
        screenshot("https://pethouse.ua/ua/");

    }

@org.junit.Test
    public void SerchIsWorking() {
        open("https://pethouse.ua/ua/");
        $("#search").click();
        $("#search").setValue("Їжа для собак").pressEnter();
        $("h1").shouldHave(Condition.text("Результати пошуку"));
        $("h1").shouldBe(Condition.visible);


}


@org.junit.Test
    public void PaymentDeliveryNovaPoshta() {
        open("https://pethouse.ua/ua/about/oplata-i-dostavka/");
        $(byText("Нова пошта")).click();
     WebDriverRunner.url().equals("https://novaposhta.ua/");

}


@org.junit.Test
    public void DiscountForRegistration() {
    open("https://pethouse.ua/ua/");
    $(byText("Зареєструйтесь та отримайте знижку 5% на перше замовлення!")).click();
    $("h1").shouldHave(Condition.text("Реєстрація користувача"));
    $("h1").shouldBe(Condition.visible);


    }


    @org.junit.Test
    public void sorting () {
        open("https://pethouse.ua/ua/shop/sobakam/suhoi-korm/");
        $("#z2-cat-sort").click();
        $("#z2-cat-sort").getValue();
        $(byText("за популярністю")).click();
        $(byText("за популярністю")).shouldBe(Condition.visible);




    }

//це  намагалась зробити як пропонує чат gpt, але шось не вийшло//
    @org.junit.Test
    public void sorting1 () {
        open("https://pethouse.ua/ua/shop/sobakam/suhoi-korm/");
        SelenideElement dropdownElement = $("#z2-cat-sort");
        String selectedValue = dropdownElement.getValue();
        System.out.println("popular" + selectedValue);
        assert WebDriverRunner.url().equals("https://pethouse.ua/ua/shop/sobakam/suhoi-korm/");
        $("#z2-cat-sort").shouldBe(Condition.visible);



    }


    @org.junit.Test
    public void contactInformation () {
        open("https://pethouse.ua/ua/");
        $(byText("Контакти")).click();
        $(byText("Зателефонуйте мені")).click();
        $("#vex-custom-input-wrapper").shouldBe(Condition.text("Ваш телефон"));


    }



}