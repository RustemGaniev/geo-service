import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationTest {

    @Test
    public void lTest(){

        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String[] expected = {"Добро пожаловать", "Welcome"};
        Country[] country = {Country.RUSSIA, Country.USA};
        for(int i = 0; i < expected.length; i++){
            String result = localizationService.locale(country[i]);
            Assertions.assertEquals(expected[i], result);
        }
    }

}
