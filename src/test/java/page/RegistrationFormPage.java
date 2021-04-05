package page;

import static data.FakeData.*;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {

    public RegistrationFormPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        return this;
    }

    public RegistrationFormPage fillForm() {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue(String.valueOf(phone));
        setDate(birthYear, birthMonth, birthDay);
        $("#subjectsInput").setValue(subjects);
        $("#subjectsInput").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        //----LoadFile
        $("#uploadPicture").uploadFile(new File("./src/test/java/../resources/" + photoName));
        //----
        $("#currentAddress").setValue(address);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();
        return this;
    }

    public void setDate(String year,String month,String day) {
        //----DateOfBirth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(String.format("[aria-label='Choose Wednesday, %s %sth, %s']",month,day,year)).click();
    }

    public void checkData() {
        $("#example-modal-sizes-title-lg").shouldHave(text(checkFillForm));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName), text(lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(email));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(String.valueOf(phone)));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(birthCheck));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subjects));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobby));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(photoName));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(address));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(state + " " + city));
    }


}
