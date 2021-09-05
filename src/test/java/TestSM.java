import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
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

            GeoServiceMock geoService = new GeoServiceMock();
            geoService.setLocation(location[i]);
            LocalizationServiceMock localizationService = new LocalizationServiceMock();
            localizationService.setMessage(message[i]);

            MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

            Map<String, String> headers = new HashMap<String, String>();
            headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip[i]);
            System.out.println("\n" + ip[i] + "\n");
            String result = messageSender.send(headers);
            Assertions.assertEquals(expected[i], result);
        }
    }
}



