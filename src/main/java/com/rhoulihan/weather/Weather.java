package com.rhoulihan.weather;


public class Weather {
	private String city;
	private String region;
	private String country;
	private String condition;
	private String temp;
	private String chill;
	private String humidity;

	public Weather() {}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCondition() {
		return this.condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getTemp() {
		return this.temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getChill() {
		return this.chill;
	}

	public void setChill(String chill) {
		this.chill = chill;
	}

	public String getHumidity() {
		return this.humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	@Override
	public String toString() {
		return "Weather [chill=" + chill + ", city=" + city + ", condition=" + condition + ", country=" + country
				+ ", humidity=" + humidity + ", region=" + region + ", temp=" + temp + "]";
	}
}
