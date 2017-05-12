
public class WeatherStation {

	public static void main(String[] args) {
		WeatherData wd = new WeatherData();
		
		CurrentConditionsDisplay ob1 = new  CurrentConditionsDisplay(wd);
		ForecastDisplay ob2 = new ForecastDisplay(wd);
		
		wd.measurementChanged(1.0f ,2.0f ,3.0f);
		wd.measurementChanged(11.0f ,22.0f ,33.0f);
		wd.measurementChanged(111.0f ,222.0f ,333.0f);
		
		ob1.removeDisplay();
		
		wd.measurementChanged(23.0f ,24.0f ,25.0f);
	}
}