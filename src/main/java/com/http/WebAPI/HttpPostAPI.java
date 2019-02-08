package com.http.WebAPI;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.http.Utilities.ReponseFormatter;

public class HttpPostAPI 
{
	public static HttpPost httpPost;
	public static CloseableHttpClient closeableClient;
	public static CloseableHttpResponse httpResponse;
	public static ReponseFormatter respFormatter;
	public static ResponseHandler<String> respHandler;
	
	public static ReponseFormatter httpPostAPI(String url, String payload, HashMap<String, String> headers) throws ClientProtocolException, IOException
	{		
		//create a HttpPost object
		httpPost = new HttpPost(url);
		
		//add headers to the post request.
		if(headers != null)
		{
			for(String key: headers.keySet())
			{
				httpPost.addHeader(key, headers.get(key));
			}
		}
		
		//Create a String entity
		StringEntity entity = new StringEntity(payload);
		httpPost.setEntity(entity);
		
		//Execute the httpPost which contains the url, header and request payload as String
		closeableClient = HttpClientBuilder.create().build();
		try {
			httpResponse = closeableClient.execute(httpPost);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		respHandler = new BasicResponseHandler(); 
		respFormatter = new ReponseFormatter(httpResponse.getStatusLine().getStatusCode(), respHandler.handleResponse(httpResponse));
	
		closeableClient.close();
		httpResponse.close();
		
		return respFormatter;
	}
	
	public static ReponseFormatter httpPostAPI(String url, File files, HashMap<String, String> headers) throws ClientProtocolException, IOException
	{
		//create HttpPost object
		httpPost = new HttpPost(url);
		
		if(headers != null)
		{
			for(String key: headers.keySet())
			{
				httpPost.addHeader(key, headers.get(key));
			}
		}
		
		//add the request payload file to the httpPost object
		FileEntity fileEntity = new FileEntity(files);
		httpPost.setEntity(fileEntity);
		
		//Execute the httpPost which contains the url, header and request payload in a file
		closeableClient = HttpClientBuilder.create().build();
		httpResponse = closeableClient.execute(httpPost);
		
		respHandler = new BasicResponseHandler();
		respFormatter = new ReponseFormatter(httpResponse.getStatusLine().getStatusCode(), respHandler.handleResponse(httpResponse));
			
		closeableClient.close();
		httpResponse.close();
		
		return respFormatter;
	}
}
