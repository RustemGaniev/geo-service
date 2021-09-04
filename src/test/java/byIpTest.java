import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class byIpTest {

    @Test
    public void byIpTest() {

        String[] ip = {"172.0.32.11", "96.44.183.149"};
        String[] expected = {"Moscow", "New York"};
        GeoServiceImpl mockedGeoServiceImpl = mock(GeoServiceImpl.class);
        when(mockedGeoServiceImpl.byIp(ip[0])).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        when(mockedGeoServiceImpl.byIp(ip[1])).thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
        for (int i = 0; i < expected.length; i++) {
            Location a = mockedGeoServiceImpl.byIp(ip[i]);
            String result = a.getCity();
            Assertions.assertEquals(expected[i], result);
        }
    }
}
