import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class byIpTest {

    @Test
    public void byIpTest() {

        GeoServiceImpl geoService = new GeoServiceImpl();
        String[] ip = {"172.0.32.11", "96.44.183.149"};
        String[] expected = {"Moscow", "New York"};

        for(int i = 0; i < ip.length; i ++){

            Location a = geoService.byIp(ip[i]);
            String result = a.getCity();
            Assertions.assertEquals(expected[i], result);
        }
    }
}
