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
    public void russianMessageSenderTest(){

        GeoService geoService = new GeoServiceImpl();
        LocalizationService localizationService = new LocalizationServiceImpl();
        String mockedIP = "172.090.163.11";
        Location location = geoService.byIp(mockedIP);
        String result = localizationService.locale(location.getCountry());
        String expected = "Добро пожаловать";
        Assertions.assertEquals(expected, result);



        //LocalizationService localizationService = new LocalizationServiceImpl();
        //String expected = "Добро пожаловать";
        //Country mockedCountry = Country.RUSSIA;
        //String result = localizationService.locale(mockedCountry);
        //Assertions.assertEquals(expected, result);
    }

    @Test
    public void englishMessageSenderTest(){
        GeoService geoService = new GeoServiceImpl();
        LocalizationService localizationService = new LocalizationServiceImpl();
        String mockedIP = "96.190.164.115";
        Location location = geoService.byIp(mockedIP);
        String result = localizationService.locale(location.getCountry());
        String expected = "Welcome";
        Assertions.assertEquals(expected, result);
    }
    @BeforeAll
    public static void beforeAll(){
        System.out.println("Test is beginning");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Test has finished");
    }

    }

