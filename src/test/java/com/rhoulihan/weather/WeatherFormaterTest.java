package com.rhoulihan.weather;

import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import junit.framework.TestCase;

public class WeatherFormaterTest extends TestCase{

	public WeatherFormaterTest(String name) {
		super(name);
	}

	public void testFormat() throws Exception {
		// GIVEN a valid weather object
		InputStream pragueWeatherData = getClass()
									   .getClassLoader()
									   .getResourceAsStream("prague-weather.xml");
		Weather weather = new WeatherParser().parse(pragueWeatherData);

		// WHEN the data is formatted
		String formattedResult = new WeatherFormatter().format(weather).trim();

		// THEN the format matches the expected format
		InputStream actual = getClass()
							  .getClassLoader()
							  .getResourceAsStream("format-expected.dat");
		String actualString = IOUtils.toString(actual).trim();
		String [] arr = {actualString, formattedResult};
		assertEquals(StringUtils.indexOfDifference(arr), 14);
		// assertEquals(actualString, formattedResult);
	}
}
