package org.telcomp.jslocation;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public class RequestTask extends AsyncTask<String, String, String>{

	@Override
	protected String doInBackground(String... uri) {
		String responseString = null;
		try {
        	HttpClient httpclient = new DefaultHttpClient(); 
            HttpResponse response = httpclient.execute(new HttpGet(uri[0]));
            StatusLine statusLine = response.getStatusLine();
            if(statusLine.getStatusCode() == HttpStatus.SC_OK){
            	response.getEntity().getContent().close();
            	responseString = "200 OK";
            } else{
                response.getEntity().getContent().close();
                responseString = "Failed";
            }
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseString;
	}

}
