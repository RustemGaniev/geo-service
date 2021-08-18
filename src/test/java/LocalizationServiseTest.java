import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiseTest {

    @Test
    public void localizationTest() {

        LocalizationService localizationService = new LocalizationServiceImpl();

        String[] expected = {"Добро пожаловать", "Welcome"};
        Country[] mockedCountry = {Country.RUSSIA, Country.GERMANY};
        for (int i = 0; i < mockedCountry.length; i++) {
            String result = localizationService.locale(mockedCountry[i]);
            Assertions.assertEquals(expected[i], result);
        }
    }
}