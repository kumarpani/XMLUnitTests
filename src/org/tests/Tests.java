package org.tests;

import java.io.IOException;

import junit.framework.Assert;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLAssert;
import org.custommonkey.xmlunit.exceptions.XpathException;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import org.utils.TextHandler;

public class Tests {
	
	private TextHandler textHandler = new TextHandler();

	@Test (description="This test should fail as xmls are similar but not identical")
	public void verifyServerResponse() throws IOException, SAXException{
		String serverResponse = textHandler.getStringFromFile("allUser_1.xml");
		String expectedResponse = textHandler.getStringFromFile("allUser.xml");

		Diff diffXml = new Diff(serverResponse,expectedResponse);
		System.out.println(diffXml.toString());

		Assert.assertTrue(diffXml.similar());	// Would pass
		Assert.assertTrue(diffXml.identical());	// Would fail		
	}
	
	@Test
	public void verifyAccountsByXPath() throws IOException, XpathException, SAXException{
		String xmlUnderTest = textHandler.getStringFromFile("allUser.xml");
		XMLAssert.assertXpathExists("/accounts/account/subscriber/first-name[text()='pani']", xmlUnderTest );
		XMLAssert.assertXpathEvaluatesTo("3","count(//account/id[@type='integer'])", xmlUnderTest);
	}

}
