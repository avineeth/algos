
public class CurrentConditionsDisplay implements Observer, Display{ 

	private float temperature;
	private float humidity;
	private float pressure;
	
	WeatherData wd;
	
	public CurrentConditionsDisplay(WeatherData weatherdata) {
		wd = weatherdata;
		wd.registerObserver(this);
	}
	
	
	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}
	
	public void removeDisplay() {
		wd.removeObserver(this);
	}
	
	public void display(){
		System.out.println("CurrentConditionsDisplay:[ Temperature: " + temperature + "] [Humidity: "+ humidity +"] [Pressure: " + pressure + "]"  );
		
	}
	
}