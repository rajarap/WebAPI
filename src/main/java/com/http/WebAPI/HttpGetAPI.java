package com.http.WebAPI;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.http.Utilities.ReponseFormatter;

public class HttpGetAPI 
{
	public static HttpGet httpGet;
	public static CloseableHttpClient closeableClient;
	public static CloseableHttpResponse httpResponse;
	public static ReponseFormatter respFormatter;
	public static ResponseHandler<String> respHandler;
	
	//GET operation without headers
	public static ReponseFormatter httpGetAPI(String url) throws URISyntaxException
	{
		return httpGetAPI(new URI(url));
	}
	
	public static ReponseFormatter httpGetAPI(URI uri)
	{
		httpGet = new HttpGet(uri); 
		try {
			closeableClient = HttpClientBuilder.create().build();
			httpResponse = closeableClient.execute(httpGet);
			respHandler = new BasicResponseHandler();
			respFormatter = new ReponseFormatter(httpResponse.getStatusLine().getStatusCode(), 
					                              respHandler.handleResponse(httpResponse));
			//closeableClient.close();
			//httpResponse.close();
		} catch (Exception e) 
		{
			if (e instanceof HttpResponseException)
			{
				return new ReponseFormatter(httpResponse.getStatusLine().getStatusCode(), e.getMessage());
			}
			throw new RuntimeException(e.getMessage(), e);
		}
		
		return respFormatter;
	}
	
	//GET operation with headers
	public static ReponseFormatter httpGetAPI(String url , Map<String, String> params)
	{
		
		return respFormatter;
	}
	
	public static void httpGetAPI(URI uri , Map<String, String> headers)
	{
		
	}

	//GET operation with headers and credentials
	public static void httpGetAPI(String url, Map<String, String> headers, String username, String password)
	{
		
	}
	
	public static void httpGetAPI(URI uri, Map<String, String> headers, String username, String password)
	{
		
	}
}
