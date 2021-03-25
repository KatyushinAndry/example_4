package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.RegistrationFormPage;

public class RegistrationFormTest {

    RegistrationFormPage registrationFormPage=new RegistrationFormPage();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized=true;
    }

    @Test
    void registrationFormTest() {
        registrationFormPage
                .openPage()
                .fillForm()
                .checkData();
    }
}
