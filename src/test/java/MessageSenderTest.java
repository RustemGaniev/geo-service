import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

public class MessageSenderTest {

    @Test
    public void messageSenderTest() {

        GeoService geoService = new GeoServiceImpl();
        LocalizationService localizationService = new LocalizationServiceImpl();
        String[] mockedIP = {"172.090.163.11", "96.190.164.115"};
        String[] expected = {"Добро пожаловать", "Welcome"};
        for (int i = 0; i < mockedIP.length; i++) {
            Location location = geoService.byIp(mockedIP[i]);
            String result = localizationService.locale(location.getCountry());
            Assertions.assertEquals(expected[i], result);

        }
    }
    }

