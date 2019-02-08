package com.http.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.http.Utilities.ReponseFormatter;

public class TestBase 
{ 
	public Properties config;
	public FileInputStream fis;
	public String url;
	public int statusCode;
	public String respBody;
	public ReponseFormatter respFormatter;
	public GsonBuilder gsonBuilder;
	public Gson gson;
	
	public TestBase()
	{
		try 
		{
			fis = new FileInputStream(
				  new File(System.getProperty("user.dir")+
			      "\\src\\test\\java\\com\\http\\Configuration\\config.properties"));
		} catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		}
		
		try 
		{
			config = new Properties();
			config.load(fis);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public <T> Object getGsonMapper(Class<T> baseType, String responseBody)
	{
		gsonBuilder = new GsonBuilder();
		gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
		return gson.fromJson(responseBody, baseType);
	}
}
