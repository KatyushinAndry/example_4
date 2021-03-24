package pageObjects;
import data.FakeData;

import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationForm {

    public RegistrationForm openPage() {
        //----OpeningAndValidationPage
        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        return this;
    }

    public RegistrationForm fillForm() {
        $("#firstName").setValue(FakeData.firstName);
        $("#lastName").setValue(FakeData.lastName);
        $("#userEmail").setValue(FakeData.email);
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue(String.valueOf(FakeData.phone));

        setDate(FakeData.birthYear, FakeData.birthMonth, FakeData.birthDay);

        //----Subjects
        $("#subjectsInput").setValue(FakeData.subjects);
        $("#subjectsInput").pressEnter();
        //----
        $("[for='hobbies-checkbox-1']").click();
        //----LoadFile
        $("#uploadPicture").uploadFile(new File("./src/test/java/../resources/" + FakeData.photoName));
        //----
        $("#currentAddress").setValue(FakeData.address);
        //----DropDown
        $("#react-select-3-input").setValue(FakeData.state).pressEnter();
        $("#react-select-4-input").setValue(FakeData.city).pressEnter();
        //----
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
        //----assetrs
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(FakeData.firstName), text(FakeData.lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(FakeData.email));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(FakeData.gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(String.valueOf(FakeData.phone)));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(FakeData.birthСheck));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(FakeData.subjects));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(FakeData.hobby));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(FakeData.photoName));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(FakeData.address));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(FakeData.state + " " + FakeData.city));
    }


}
