import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest {

    @Test
    void get_location_by_ip_test() {

        GeoServiceImpl geoService = new GeoServiceImpl();
        String[] ip = {"172.0.32.11", "96.44.183.149"};
        String[] expected = {"Moscow", "New York"};

        for (int i = 0; i < expected.length; i++) {
            String result = geoService.byIp(ip[i]).getCity();
            System.out.println("\n Expected : " + expected[i] + "\n Result : " + result);
            Assertions.assertEquals(expected[i], result);
        }
    }
}
