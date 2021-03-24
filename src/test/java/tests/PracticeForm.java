package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pageObjects.RegistrationForm;

public class PracticeForm {

    RegistrationForm registrationForm=new RegistrationForm();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized=true;
    }

    @Test
    void selenideSearchTest() {
        registrationForm
                .openPage()
                .fillForm()
                .checkData();
    }
}
