import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;

public class LocalizationServiceMock implements LocalizationService {

    private String message;

    @Override
    public String locale(Country country) {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }
}
