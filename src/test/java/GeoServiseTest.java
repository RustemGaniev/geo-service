import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiseTest {

    @Test
    public void locationByIpTest() {

        GeoServiceImpl geoservice = new GeoServiceImpl();
        Country[] expected = {null, Country.RUSSIA, Country.USA};
        String[] mockedIp = {"127.0.0.1", "172.090.163.11", "96.190.164.115"};
        for (int i = 0; i < mockedIp.length; i++) {
            Country result = geoservice.byIp(mockedIp[i]).getCountry();
            System.out.println("expected : " + expected[i] + "\n result : " + result);
            Assertions.assertEquals(expected[i], result);
        }
    }
}