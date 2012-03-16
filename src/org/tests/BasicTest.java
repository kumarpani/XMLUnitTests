package org.tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.Server;

public class BasicTest {
	
	private Server server = new Server();

	@Test()
	public void verifyIfServiceGivesResponse() throws MalformedURLException, IOException{
		
		String response = server.getHttpResponse("http://ericssonqabootcamp.heroku.com/accounts.xml");
		System.out.println(response);
		
		Assert.assertNotEquals(response,null);
		
	}

}
