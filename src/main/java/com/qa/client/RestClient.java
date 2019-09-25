package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	// 1.Get method
	public void getmethod(String url) throws ClientProtocolException, IOException {

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse closeableresponse = httpclient.execute(httpget);

		//a. status code ::
		int statuscode = closeableresponse.getStatusLine().getStatusCode();
		System.out.println("status code ----->" + statuscode);

		// b.String response
		String Response = EntityUtils.toString(closeableresponse.getEntity(), "UTF-8");

		JSONObject responsejson = new JSONObject(Response);
	    System.out.println("response json code---->>>" + responsejson);

		// c.All headers
		Header[] hearderarray = closeableresponse.getAllHeaders();

		HashMap<String, String> allheader = new HashMap<String, String>();

		for (Header header : hearderarray) {

			allheader.put(header.getName(), header.getValue());
		}

		System.out.println("Header value ----->>>" + allheader);

	}

}
