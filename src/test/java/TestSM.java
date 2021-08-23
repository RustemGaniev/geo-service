import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import java.util.stream.Stream;

public class TestSM {

    @ParameterizedTest
    @MethodSource("MessageSenderTest.rustem")
    public void messageSenderTest(Location argument) {

        String expection;
        GeoServiceImplMock geoService = new GeoServiceImplMock();
        geoService.setValue(argument);
        Location location = geoService.byIp("Test ip");
        LocalizationServiceMock localizationService = new LocalizationServiceMock();
        String result = localizationService.locale(location.getCountry());
        if (location.getCountry().equals(Country.RUSSIA)) {
            expection = "Добро пожаловать";
        } else expection = "Welcome";
        Assertions.assertEquals(expection, result);
    }

    public static Stream<Arguments> rustem() {
        return Stream.of(Arguments.of(new Location("Moscow", Country.RUSSIA, "Lenina", 15)),
                Arguments.of(new Location("New York", Country.USA, " 10th Avenue", 32)));
    }

}


