package com.http.TestNGTests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.http.Mappers.TC_03_PostCreateUser_Mapper;
import com.http.TestBase.TestBase;
import com.http.WebAPI.HttpPostAPI;

public class TC_03_PostCreateUser extends TestBase
{
	public String url;
	public String payload;
	
	public TC_03_PostCreateUser_Mapper mapper;
	
	@BeforeClass
	public void setUp()
	{
		new TestBase();
		url = config.getProperty("createuser");
	}
	
	@Test
	public void createNewUser() throws ClientProtocolException, IOException
	{
		//create payload in String format
		payload = "{" +
				"\"name\":\"morpheus\","+
				"\"job\":\"leader\" "+
				"}";
		
		//create headers
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Accept", "application/json");
		headers.put("Content-Type", "application/json");
		
		//process the request and obtain the response and customize it using ResponsFormatter class
		respFormatter = HttpPostAPI.httpPostAPI(url, payload, headers);
		this.statusCode = respFormatter.getStatusCode();
		this.respBody = respFormatter.getResponsePayload();
		
		//map the json response with the gson mapper class
		mapper = (TC_03_PostCreateUser_Mapper)getGsonMapper(TC_03_PostCreateUser_Mapper.class, this.respBody);
		
		System.out.println(this.statusCode);
		System.out.println(this.respBody);
		System.out.println(mapper.getName());
		System.out.println(mapper.getJob());
		
		Assert.assertTrue(this.statusCode==HttpStatus.SC_CREATED);
		Assert.assertEquals(mapper.getName(), "morpheus");
		Assert.assertEquals(mapper.getJob(), "leader");
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
