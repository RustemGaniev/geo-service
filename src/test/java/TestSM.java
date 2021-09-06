import org.junit.jupiter.api.Assertions;
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

public class TestSM {

    @Test
    public void messageSenderTest() {

        Location[] location = {new Location("Moscow", Country.RUSSIA, "Lenina", 15),
                new Location("New York", Country.USA, " 10th Avenue", 32)};
        String[] message = {"Добро пожаловать", "Welcome"};
        String[] expected = {"Добро пожаловать", "Welcome"};
        String[] ip = {"172.123.12.19", "96.44.183.149"};

        for (int i = 0; i < location.length; i++) {

            GeoService geoService = Mockito.mock(GeoService.class);
            Mockito.when(geoService.byIp(ip[i])).thenReturn(location[i]);

            LocalizationService localizationService = Mockito.mock(LocalizationService.class);
            Mockito.when(localizationService.locale(location[i].getCountry())).thenReturn(message[i]);

            MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

            Map<String, String> headers = new HashMap<String, String>();
            headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip[i]);
            System.out.println("\n" + ip[i] + "\n");
            String result = messageSender.send(headers);
            Assertions.assertEquals(expected[i], result);
        }
    }
}



