package proxy;

import java.util.Currency;
import java.util.Random;

public class CurrentRateServiceImpl implements CurrentRateService {
    @Override
    public double getDailyRate(Currency currency) {
        Random rnd = new Random();
        return rnd.nextDouble(100) + 20;
    }
}
