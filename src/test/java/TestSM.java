import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Location;
import ru.netology.i18n.LocalizationServiceImpl;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static ru.netology.entity.Country.RUSSIA;

public class TestSM {

    @Test
    public void messageSenderTest() {

        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        Location mockedLocation = mock(Location.class);
        when(mockedLocation.getCountry()).thenReturn(RUSSIA);
        String result = localizationService.locale(mockedLocation.getCountry());
        String expected = "Добро пожаловать";
        Assertions.assertEquals(expected, result);
    }
}



