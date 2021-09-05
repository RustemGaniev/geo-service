import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplTest {

    @Test
    void bring_locale_text_test() {

        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        Country[] country = {Country.RUSSIA, Country.USA};
        String[] expected = {"Добро пожаловать", "Welcome"};

        for (int i = 0; i < expected.length; i++) {
            String result = localizationService.locale(country[i]);
            System.out.println("\n Expected : " + expected[i] + "\n Result : " + result);
            Assertions.assertEquals(expected[i], result);
        }
    }
}
