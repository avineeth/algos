
public class ForecastDisplay implements Observer, Display{ 

	private float temperature;
	private float humidity;
	private float pressure;
	
	WeatherData wd;
	
	public ForecastDisplay(WeatherData weatherdata) {
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
		System.out.println("ForecastDisplay:[ Temperature: " + temperature + "] [Humidity: "+ humidity +"] [Pressure: " + pressure + "]"  );
		
	}
	
}