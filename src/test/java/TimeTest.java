import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class TimeTest {

    @Test
    public void timeTest(){

        Location location =new Location("New York", Country.USA, " 10th Avenue", 32);
        String message = "Добро пожаловать";
        String ip = "172.123.12.19";

            GeoService geoService = Mockito.mock(GeoService.class);
            Mockito.when(geoService.byIp(ip)).thenReturn(location);

            LocalizationService localizationService = Mockito.mock(LocalizationService.class);
            Mockito.when(localizationService.locale(location.getCountry())).thenReturn(message);

            MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

            Map<String, String> headers = new HashMap<String, String>();
            headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);
            long startTime = System.currentTimeMillis();
            messageSender.send(headers);
            long endTime = System.currentTimeMillis();
            long actual = endTime - startTime;
            System.out.println("\n Actual time " + actual);
            long expected = 100;
            assert actual < expected : "Message sending time is too long!";
        }
}
