import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class lesson2 {

    String T = "Test";
    String email = "Test@mail.ru";
    String currentAddress = "first some address";
    String permanentAddress = "second some address";

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";  //общий адрес
        Configuration.startMaximized = true;
    }


    @Test
     void successFillTest(){
        open("/text-box");  //конкретный адрес
        //ассерт с текстовым элементов
        $(".main-header").shouldHave(text("Text Box"));

        //ввод в поля какие-либо значения
        $("#userName").setValue(T);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);

        //скрол к кнопке + клик по кнопке
        $("#submit").scrollTo();
        $("#submit").click();
        //ассерт

        $("#output").shouldHave(text(T), text(email), text(currentAddress), text(permanentAddress));
    }
}
