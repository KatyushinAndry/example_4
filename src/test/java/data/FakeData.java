package data;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import java.util.Locale;

public class FakeData {

    static Faker faker=new Faker();

    static FakeValuesService fakeValuesService=new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    public static String firstName=faker.name().firstName(),
            lastName=faker.name().lastName(),
            gender="Male",
            email=fakeValuesService.bothify("????##@gmail.com"),
            birthDay="4",
            birthMonth="December",
            birthYear="1985",
            birthCheck="04 December,1985",
            subjects="English",
            hobby="Sports",
            photoName="photo_2021-03-10_20-56-18.jpg",
            address=faker.address().streetAddress(),
            state="Haryana",
            phone=faker.number().digits(10),
            city="Karnal";
}
