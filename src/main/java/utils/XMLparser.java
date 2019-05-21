package utils;

import model.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLparser {

	public User getUser() throws ParserConfigurationException, IOException, SAXException {
		File file = new File("src/main/resources/userXML.xml");
		User user = new User();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse(file);

		Element usersElement = (Element) document.getElementsByTagName("users").item(0);

		NodeList userNodeList = document.getElementsByTagName("user");

		for (int i = 0; i < userNodeList.getLength(); i++) {
			if (userNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Element userElement = (Element) userNodeList.item(i);

				user.setNumber(Integer.valueOf(userElement.getAttribute("number")));

				NodeList childNode = userElement.getChildNodes();
				for (int j = 0; j < childNode.getLength(); j++) {
					if (childNode.item(j).getNodeType() == Node.ELEMENT_NODE) {
						Element childElement = (Element) childNode.item(j);

						switch (childElement.getNodeName()) {

							case "login": {
								user.setLogin(childElement.getTextContent());
							}

							case "password": {
								user.setPassword(childElement.getTextContent());
							}

							case "adressee": {
								user.setAdressee(childElement.getTextContent());
							}

							case "subject": {
								user.setSubject(childElement.getTextContent());
							}

							case "text": {
								user.setTextMessage(childElement.getTextContent());
							}
						}
					}
				}

			}
		}
		return user;
	}
}