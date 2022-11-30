package com.rhoulihan.weather;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import org.apache.log4j.Logger;

import io.github.cdimascio.dotenv.Dotenv;


public class WeatherRetriever {

	private static final Logger log = Logger.getLogger(WeatherRetriever.class);

	public InputStream retrieve(String city) throws Exception {
		log.info("Retrieving Weather  Data");
		Dotenv dotenv = Dotenv.load();
		String apiKey = dotenv.get("API_KEY");

		String url="http://api.weatherapi.com/v1/current.xml?key=" + apiKey + "&q=" + city + "&api=no";
		URLConnection conn = new URL(url).openConnection();

		return conn.getInputStream();
	}
}
