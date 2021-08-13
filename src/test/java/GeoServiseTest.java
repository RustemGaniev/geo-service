import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiseTest {

    @Test
    public void locationByIpTest(){

        GeoServiceImpl geoservice = new GeoServiceImpl();
        Country expected = null;
        String mockedIp = "127.0.0.1";
        Country result = geoservice.byIp(mockedIp).getCountry();
        System.out.println("expected : " + expected + "\n result : " + result);
        Assertions.assertEquals(expected, result);


        Country expectedRus = Country.RUSSIA;
        String mockedIpRus = "172.090.163.11";
        Country resultRus = geoservice.byIp(mockedIpRus).getCountry();
        System.out.println("\n \n expected : " + expectedRus + "\n result : " + resultRus);
        Assertions.assertEquals(expectedRus, resultRus);

        Country expectedUsa = Country.USA;
        String mockedIpUsa = "96.190.164.115";
        Country resultUsa = geoservice.byIp(mockedIpUsa).getCountry();
        System.out.println("\n \n expected : " + expectedUsa + "\n result : " + resultUsa);
        Assertions.assertEquals(expectedUsa, resultUsa);

    }
    @BeforeAll
    public static void beforeAll(){
        System.out.println("\n Test has started \n");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("\n Test has finished");
    }
}
