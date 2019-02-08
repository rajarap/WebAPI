package com.http.TestNGTests;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpStatus;
import org.apache.http.client.utils.URIBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.http.TestBase.TestBase;
import com.http.Mappers.TC_02_GetCityWeatherWithParams_Mapper1;
import com.http.WebAPI.HttpGetAPI;

public class TC_02_GetCityWeatherWithParams extends TestBase
{
	public String city;
	public String appid;

	public TC_02_GetCityWeatherWithParams_Mapper1 mapper;
	
	@BeforeClass
	public void setUp()
	{
		new TestBase();
		url = config.getProperty("getcityweather");
		city = config.getProperty("city");
		appid = config.getProperty("APPID");
	}

	
	@Test
	public void getCityWeatherWithParams() throws URISyntaxException
	{
		//build the URI using URIBuilder
		URIBuilder builder = new URIBuilder();
		builder.setScheme("http")
		.setHost("api.openweathermap.org").setPath("/data/2.5/weather")
		.setParameter("q", "Bangalore")
		.setParameter("APPID", "01465abc566b2896a86841e68ee06c2a");
		
		//Get the URI object
		URI uri = builder.build();
		System.out.println(uri.toString());
		
		//Process the GET request
		respFormatter = HttpGetAPI.httpGetAPI(uri);
		
		//get status code
		this.statusCode = respFormatter.getStatusCode();
		this.respBody = respFormatter.getResponsePayload();
		
		//Assert status code
		Assert.assertTrue(this.statusCode==HttpStatus.SC_OK);
		
		//to assert on response body, create a gson object
//		gsonBuilder = new GsonBuilder();
//		gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
//		mapper = gson.fromJson(respBody, GetCityWeatherWithParams_Mapper1.class);
		
		mapper = (TC_02_GetCityWeatherWithParams_Mapper1)getGsonMapper(TC_02_GetCityWeatherWithParams_Mapper1.class, this.respBody);
		
		//Display results
		System.out.println(Integer.valueOf(mapper.getId()).toString() +"--"+ Integer.valueOf(1277333).toString());
		System.out.println(mapper.getName()+"--"+ "Bangalore");
		System.out.println(Integer.valueOf(mapper.getCod()).toString() +"--"+Integer.valueOf(200).toString());
		
		System.out.println(Integer.valueOf(mapper.weather.get(0).getId()).toString() +"--"+Integer.valueOf(800).toString());
		System.out.println(mapper.weather.get(0).getDescription()+"--"+ "clear sky");
		System.out.println(mapper.weather.get(0).getIcon()+"--"+"01d");
		System.out.println(mapper.weather.get(0).getMain()+"--"+ "Clear");
		
		//Assert on response body
		Assert.assertEquals(mapper.getId(), 1277333);
		Assert.assertEquals(mapper.getName(), "Bangalore");
		Assert.assertEquals(mapper.getCod(), 200);
		
		Assert.assertEquals(mapper.weather.get(0).getId(), 800);
		Assert.assertEquals(mapper.weather.get(0).getDescription(), "clear sky");
		Assert.assertEquals(mapper.weather.get(0).getIcon(), "01d");
		Assert.assertEquals(mapper.weather.get(0).getMain(), "Clear");			
	}
	
	@AfterClass
	public void tearDown()
	{
		respFormatter = null;
		gsonBuilder = null;
		gson = null;
		config = null;
	}
}
