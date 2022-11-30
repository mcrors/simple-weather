package com.rhoulihan.weather;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;


public class WeatherParser {

	private static final Logger log = Logger.getLogger(WeatherParser.class);

	public Weather parse(InputStream inputStream) throws Exception {
		Weather weather = new Weather();

		log.info("Creating XML Reader");

		SAXReader xmlReader = createXmlReader();
		Document doc = xmlReader.read(inputStream);

		log.info("Parsing XML Response");
		Node locationNode = doc.selectSingleNode("/root/location");
		Node weatherNode = doc.selectSingleNode("/root/current");

		weather.setCity(locationNode.selectSingleNode("name").getText());
		weather.setRegion(locationNode.selectSingleNode("region").getText());
		weather.setCountry(locationNode.selectSingleNode("country").getText());
		weather.setCondition(weatherNode.selectSingleNode("condition/text").getText());
		weather.setTemp(weatherNode.selectSingleNode("temp_c").getText());
		weather.setChill(weatherNode.selectSingleNode("feelslike_c").getText());
		weather.setHumidity(weatherNode.selectSingleNode("humidity").getText());

		return weather;
	}

	private SAXReader createXmlReader() {
		Map<String, String> uris = new HashMap<>();
		uris.put("y", "http://xml.weather.yahoo.com/ns/rss/1.0");
		DocumentFactory factory = new DocumentFactory();
		factory.setXPathNamespaceURIs(uris);
		SAXReader xmlreader = new SAXReader();
		xmlreader.setDocumentFactory(factory);
		return xmlreader;
	}

}
