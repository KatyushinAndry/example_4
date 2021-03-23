package pageObjects;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationForm {


    String firstName="Andru";
    String lastName="Katyushin";
    String gender="Male";
    String email="a.katyushin@gmail.com";
    String phone="3759999999";
    String birthDay="4";
    String birthMonth="December";
    String birthYear="1985";
    //String birth = "12/04/1985";
    String birthСheck="04 December,1985";
    String subjects="English";
    String hobby="Sports";
    String photoName="photo_2021-03-10_20-56-18.jpg";
    String address="Suite 12 2nd Floor,\n" + "Queens House,\n" + "180 Tottenham Court Road,\n" + "London W1T 7PD";
    String state="Haryana";
    String city="Karnal";

    public RegistrationForm openPage() {
        //----OpeningAndValidationPage
        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        return this;
    }

    public RegistrationForm fillForm() {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue(phone);

        setDate(birthYear,birthMonth,birthDay);

        //----Subjects
        $("#subjectsInput").setValue(subjects);
        $("#subjectsInput").pressEnter();
        //----
        $("[for='hobbies-checkbox-1']").click();
        //----LoadFile
        $("#uploadPicture").uploadFile(new File("./src/test/java/../resources/" + photoName));
        //----
        $("#currentAddress").setValue(address);
        //----DropDown
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
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
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName),text(lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(email));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(phone));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(birthСheck));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subjects));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobby));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(photoName));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(address));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(state + " " + city));
    }


}
