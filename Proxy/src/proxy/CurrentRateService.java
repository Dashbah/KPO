package proxy;

import java.util.Currency;
import java.util.Random;

public interface CurrentRateService {
    double getDailyRate(Currency currency);
}
