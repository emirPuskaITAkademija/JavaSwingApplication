package one.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private float temp;
    private float humidity;
    private float pressure;

    public void setMeasurements(float t, float h, float p){
        this.temp = t;
        humidity = h;
        pressure = p;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        if(!observers.contains(observer)){
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if(observers.contains(observer)){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(temp, humidity, pressure);
        }
    }
}
