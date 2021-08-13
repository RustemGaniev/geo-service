import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiseTest {

    @Test
    public void localizationTest(){

        LocalizationService localizationService = new LocalizationServiceImpl();

        String expected = "Добро пожаловать";
        Country mockedCountry = Country.RUSSIA;
        String result = localizationService.locale(mockedCountry);
        Assertions.assertEquals(expected, result);

        String expectedOther = "Welcome";
        Country mockedOtherCountry = Country.BRAZIL;
        String result2 = localizationService.locale(mockedOtherCountry);
        Assertions.assertEquals(expectedOther, result2);
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("\n Test has started");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("\n Test has finished");
    }
}
