package org.ariose.util;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.ariose.model.GmlcResponse;
import org.hsqldb.lib.StringInputStream;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GmlcResponseParser {
	// No generics
	GmlcResponse response;
	String xmlResponse;

	public GmlcResponse getResponse() {
		return response;
	}

	public GmlcResponseParser(String xmlResponse) {
		this.xmlResponse = xmlResponse;
		response = new GmlcResponse();
	}

	public void execute() throws ParserConfigurationException,
			SAXException, IOException, XPathExpressionException {

		//TODO exception handling based on needed fields
		
		DocumentBuilderFactory domFactory = DocumentBuilderFactory
				.newInstance();
		domFactory.setNamespaceAware(true); // never forget this!
		DocumentBuilder builder = domFactory.newDocumentBuilder();
		Document doc = builder.parse(new StringInputStream(xmlResponse));

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("//msid/text()");
		String txt = (String) expr.evaluate(doc, XPathConstants.STRING);
		response.setMsid(txt);

		expr = xpath.compile("//time");
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList nodes = (NodeList) result;
		if (nodes.getLength() > 0) {
			Node node = nodes.item(0);
			NamedNodeMap map = node.getAttributes();
			response.setUtcOff(map.getNamedItem("utc_off").getNodeValue());
			response.setTime(node.getTextContent());
		}

		expr = xpath.compile("//x/text()");
		txt = (String) expr.evaluate(doc, XPathConstants.STRING);
		response.setXCoord(txt);

		expr = xpath.compile("//y/text()");
		txt = (String) expr.evaluate(doc, XPathConstants.STRING);
		response.setYCoord(txt);

		expr = xpath.compile("//radius/text()");
		txt = (String) expr.evaluate(doc, XPathConstants.STRING);
		response.setRadius(txt);

		expr = xpath.compile("//resp_status/text()");
		txt = (String) expr.evaluate(doc, XPathConstants.STRING);
		response.setRespStatus(txt);
		
		expr = xpath.compile("//site_name/text()");
		txt = (String) expr.evaluate(doc, XPathConstants.STRING);
		response.setSiteName(txt);
		
		expr = xpath.compile("//city/text()");
		txt = (String) expr.evaluate(doc, XPathConstants.STRING);
		response.setCity(txt);
		
		expr = xpath.compile("//cellId/text()");
		txt = (String) expr.evaluate(doc, XPathConstants.STRING);
		response.setCellId(txt);
		
		expr = xpath.compile("//siteId/text()");
		txt = (String) expr.evaluate(doc, XPathConstants.STRING);
		response.setSiteId(txt);
	}

}
