package com.qa.tests;

import java.io.IOException;



import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetaPITest extends TestBase{
	
	TestBase testbase; 
	String basurl ; 
	String servicurl; 
	String url;
	
	
	RestClient restclient;
	
	@Test	
	public void setup() throws ClientProtocolException, IOException {
		
		testbase = new TestBase(); 
		basurl =	prop.getProperty("baseurl");
		servicurl = prop.getProperty("sourceurl");
		 url	= 	basurl + servicurl ; 
		
		 
		 restclient = new RestClient();
			restclient.getmethod(url); 
		}
	
	/*
	 * @Test
	 * 
	 * public void GetAPImethod() throws ClientProtocolException, IOException {
	 * 
	 * 
	 * 
	 * }
	 */

}
