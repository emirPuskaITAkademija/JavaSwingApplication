package one.observer;

import java.util.ArrayList;
import java.util.List;

public class StatisticDisplay implements  Observer {
    private List<Float> temps = new ArrayList<>();
    private List<Float> humidities = new ArrayList<>();
    private List<Float> pressures = new ArrayList<>();

    public StatisticDisplay(Subject subject){
        subject.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        temps.add(temp);
        humidities.add(humidity);
        pressures.add(pressure);
        System.out.println("Temp avg: " +
                average(temps)+", Humidities avg: "
                + average(humidities)+", Pressures avg: "
                + average(pressures));
    }

    private float average(List<Float> values){
        return (float) values.stream().mapToDouble(it->it).average().orElse(0f);
    }
}
