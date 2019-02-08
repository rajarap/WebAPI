package com.http.TestNGTests;

import java.net.URISyntaxException;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.http.Mappers.TC_01_GetListOfUsers_Mapper1;
import com.http.TestBase.TestBase;
import com.http.WebAPI.HttpGetAPI;

public class TC_01_GetListOfUsers extends TestBase
{
	public TC_01_GetListOfUsers_Mapper1 mapper;

	@BeforeClass
	public void setUp()
	{
		new TestBase();
		url = config.getProperty("listofusers");
	}
	
	@Test
	public void getListOfUsers() throws URISyntaxException
	{
		respFormatter = HttpGetAPI.httpGetAPI(url);
		this.statusCode = respFormatter.getStatusCode();
		this.respBody = respFormatter.getResponsePayload();
		
		//map the json objects with mapper class
//		gsonBuilder = new GsonBuilder();
//		gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
//		mapper = gson.fromJson(respBody, TC_01_GetListOfUsers_Mapper1.class);
		mapper = (TC_01_GetListOfUsers_Mapper1)getGsonMapper(TC_01_GetListOfUsers_Mapper1.class, this.respBody);
		
		//Assertions
		Assert.assertTrue(this.statusCode == HttpStatus.SC_OK);
		Assert.assertEquals(mapper.getPage(), 2);
		Assert.assertEquals(mapper.getPer_page(), 3);
		Assert.assertEquals(mapper.getTotal(), 12);
		Assert.assertEquals(mapper.getTotal_pages(), 4);
		Assert.assertEquals(mapper.mapper2.get(0).getFirst_name(), "Eve" );
		Assert.assertEquals(mapper.mapper2.get(1).getFirst_name(), "Charles");
		Assert.assertEquals(mapper.mapper2.get(2).getFirst_name(), "Tracey");
		Assert.assertEquals(mapper.mapper2.get(2).getAvatar(), "https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg");

		System.out.println("Page : "+ mapper.getPage());
		System.out.println("Per_page : "+mapper.getPer_page());
		System.out.println("Total : "+mapper.getTotal());
		System.out.println("Total_pages : "+mapper.getTotal_pages());
		System.out.println("First_name(0) : "+mapper.mapper2.get(0).getFirst_name());
		System.out.println("First_name(1) : "+mapper.mapper2.get(1).getFirst_name());
		System.out.println("First_name(2) : "+mapper.mapper2.get(2).getFirst_name());
		System.out.println("Avatar(2) : "+mapper.mapper2.get(2).getAvatar());
	}
	
	@AfterClass
	public void tearDown()
	{
		respFormatter = null;
		gsonBuilder = null;
		gson = null;
		mapper = null;
		config = null;
	}

}
