package one.observer;

public class CurrentConditionDisplay implements Observer {

    private Subject subject;
    private float temp;
    private float humidity;

    public CurrentConditionDisplay(Subject subject){
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        System.out.println("Current conditions: "+ temp+" F degrees and " + humidity+" %");
    }
}
