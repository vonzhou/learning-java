package basic.dp.observer;

//当前天气状况布告板
public class CurrentConditionDisplay implements Observer, DisplayElement{
	private float temperature;
	private float humidity;
	private Subject weatherData;
	//用WeatherData作为构造器参数，作为注册之用
	public CurrentConditionDisplay(Subject weatherData){
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("CurrentConditionDisplay: " + this.temperature + " F degrees and "
						+ this.humidity + "% humidity..");
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		//先把状态改变保存起来，而后进行业务处理（显示）
		this.temperature = temp;
		this.humidity = humidity;
		display();
	}
}
