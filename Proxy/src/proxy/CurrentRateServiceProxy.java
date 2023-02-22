package proxy;

import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

public class CurrentRateServiceProxy implements CurrentRateService {

    private final CurrentRateService currentRateService;
    private final Map<Currency, Double> currencyRateMap = new HashMap<>();

    public CurrentRateServiceProxy () {
        this.currentRateService = new CurrentRateServiceImpl();
    }

    @Override
    public double getDailyRate(Currency currency) {
        if (currencyRateMap.containsKey(currency)) {
            return currencyRateMap.get(currency);
        }
        // here we can check connection to the source/repeat it if necessary
        // so => use proxy functionality
        double currentRate = currentRateService.getDailyRate(currency);
        currencyRateMap.put(currency, currentRate);
        return currentRate;
    }
}
