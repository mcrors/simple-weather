package com.rhoulihan.weather;

import java.io.InputStream;
import org.apache.log4j.PropertyConfigurator;


public class Main {

	private static final String DEFAULT_CITY = "Prague";
	private final String city;

	public Main(String city) {
		this.city = city;
	}

	public static void main(String[] args) throws Exception {
		PropertyConfigurator.configure(
			Main.class.getClassLoader().getResource("log4j.properties")
		);

		String cityEntered;
		try {
			cityEntered = args[0];
		} catch (Exception e) {
			cityEntered = DEFAULT_CITY;
		}

		new Main(cityEntered).start();
	}

	private void start() throws Exception {
		InputStream dataIn = new WeatherRetriever().retrieve(this.city);
		Weather weather = new WeatherParser().parse(dataIn);
		System.out.println( new WeatherFormatter().format(weather) );
	}
}
