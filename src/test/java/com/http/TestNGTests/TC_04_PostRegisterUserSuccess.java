package com.http.TestNGTests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.http.Mappers.TC_04_PostRegisterUserSuccess_Mapper;
import com.http.TestBase.TestBase;
import com.http.WebAPI.HttpPostAPI;

public class TC_04_PostRegisterUserSuccess extends TestBase
{
	public String url;
	public File files;
	
	public TC_04_PostRegisterUserSuccess_Mapper mapper;
	
	@BeforeClass
	public void setUp()
	{
		new TestBase();
		url = config.getProperty("registerusersuccess");
	}
	
	@Test
	public void createNewUser() throws ClientProtocolException, IOException
	{
		//create payload in String format
		files = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\http\\Configuration\\Registration");
		
		//create headers
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Accept", "application/json");
		headers.put("Content-Type", "application/json");
		
		//process the request and obtain the response and customize it using ResponsFormatter class
		respFormatter = HttpPostAPI.httpPostAPI(url, files, headers);
		this.statusCode = respFormatter.getStatusCode();
		this.respBody = respFormatter.getResponsePayload();
		
		//map the json response with the gson mapper class
		mapper = (TC_04_PostRegisterUserSuccess_Mapper)getGsonMapper(TC_04_PostRegisterUserSuccess_Mapper.class, this.respBody);
		
		System.out.println(this.statusCode);
		System.out.println(this.respBody);
		System.out.println(mapper.getToken());
		
		Assert.assertTrue(this.statusCode==HttpStatus.SC_CREATED);
		Assert.assertEquals(mapper.getToken(), "QpwL5tke4Pnpja7X");

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
