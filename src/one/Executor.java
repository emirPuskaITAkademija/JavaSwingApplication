package one;

import one.observer.*;

import java.util.stream.Stream;

public class Executor {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        weatherData.setMeasurements(-11, 50, 110);
        Observer currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        Observer statisticDisplay = new StatisticDisplay(weatherData);
        weatherData.setMeasurements(-21, 70, 125);
        System.out.println();
        weatherData.setMeasurements(-23, 60, 115);
        System.out.println();
        weatherData.setMeasurements(10, 50, 105);
    }
}
