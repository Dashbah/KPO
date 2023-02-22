import proxy.CurrentRateServiceProxy;

import javax.sound.midi.Soundbank;
import java.util.Currency;
import java.util.Observable;
import java.util.Observer;

public class Main {

    public static void main(String[] args) {
        CurrentRateServiceProxy currentRateServiceProxy = new CurrentRateServiceProxy();

        var EUR = Currency.getInstance("EUR");
        var RUB = Currency.getInstance("RUB");

        System.out.println("EUR: " + currentRateServiceProxy.getDailyRate(EUR));
        System.out.println("EUR: " + currentRateServiceProxy.getDailyRate(EUR));
        System.out.println("EUR: " + currentRateServiceProxy.getDailyRate(EUR));

        System.out.println("RUB: " + currentRateServiceProxy.getDailyRate(RUB));
        System.out.println("RUB: " + currentRateServiceProxy.getDailyRate(RUB));
        System.out.println("RUB: " + currentRateServiceProxy.getDailyRate(RUB));
    }
}