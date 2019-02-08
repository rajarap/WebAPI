package com.http.Mappers;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class TC_02_GetCityWeatherWithParams_Mapper1 
{
	@SerializedName("id")
	public int id;
	
	@SerializedName("name")
	public String name;

	@SerializedName("cod")
	public int cod;
	
	@SerializedName("weather")
	public List<TC_02_GetCityWeatherWithParams_Mapper2> weather;
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getCod() {
		return cod;
	}

	public List<TC_02_GetCityWeatherWithParams_Mapper2> getWeather() {
		return weather;
	}
}


