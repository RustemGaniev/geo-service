import ru.netology.entity.Location;
import ru.netology.geo.GeoService;

public class GeoServiceMock implements GeoService {

    private Location location;

    @Override
    public Location byIp(String ip) {

        return location;
    }

    @Override
    public Location byCoordinates(double latitude, double longitude) {

        return null;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
