package com.rhoulihan.weather;

import java.io.InputStream;

import junit.framework.TestCase;

public class WeatherParserTest extends TestCase{

	public WeatherParserTest(String name) {
		super(name);
	}

	public void testParser() throws Exception {
		// GIVEN some weather xml data
		InputStream pragueWeatherData = getClass()
							.getClassLoader()
							.getResourceAsStream("prague-weather.xml");

		// WHEN the data is parsed
		Weather weather = new WeatherParser().parse(pragueWeatherData);

		// THEN the weather object has been created with the correct values
		assertEquals("Prague", weather.getCity());
		assertEquals("Hlavni mesto Praha", weather.getRegion());
		assertEquals("Czech Republic", weather.getCountry());
		assertEquals("0", weather.getTemp());
		assertEquals("Partly cloudy", weather.getCondition());
		assertEquals("-1.1", weather.getChill());
		assertEquals("69", weather.getHumidity());
	}
}
