package org.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Server {

	private static final TextHandler TEXT_HANDLER = new TextHandler();

	public String getHttpResponse(String url) throws MalformedURLException, IOException {
		InputStream responseStream = new URL(url).openConnection().getInputStream();
		return TEXT_HANDLER.convertStreamToString (responseStream);  		
	}
}
