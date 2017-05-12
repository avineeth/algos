
import java.util.List;
import java.util.ArrayList;

public class WeatherData implements Subject {
	
	private float temperature;
	private float humidity;
	private float pressure;
	
	List<Observer> observerlist;
	
	public WeatherData() {
		observerlist = new ArrayList<>();
	}
	public void registerObserver(Observer o) {
		observerlist.add(o);
		
	}
	public void removeObserver(Observer o) {
		observerlist.remove(o);
	}
	
	public void notifyObservers(){
		
		for(Observer o: observerlist) {
			o.update(getTemperature(),getHumidity(),getPressure());
		}
		
	}
	
	public void measurementChanged(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		
		notifyObservers();
	}
	
	public float getTemperature(){
		return this.temperature;
	}
	
	public float getHumidity(){
		return this.humidity;
	}
	
	public float getPressure(){
		return this.pressure;
	}
	
}
