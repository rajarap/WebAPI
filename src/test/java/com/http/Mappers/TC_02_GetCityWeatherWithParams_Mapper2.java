package com.http.Mappers;

import com.google.gson.annotations.SerializedName;

public class TC_02_GetCityWeatherWithParams_Mapper2 
{
	@SerializedName("id")
	public int id;
	
	@SerializedName("main")
	public String main;

	@SerializedName("description")
	public String description;
	
	@SerializedName("icon")
	public String icon;
	
	public int getId() {
		return id;
	}

	public String getMain() {
		return main;
	}

	public String getDescription() {
		return description;
	}

	public String getIcon() {
		return icon;
	}

}
