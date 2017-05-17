package com.kxw.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by kangxiongwei on 2015/7/13.
 */
public class DomParseTest {

    public static void main(String[] args) throws Exception {
        String path = DomParseTest.class.getResource("").getPath();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(path+"/canlidate.xml"));
        NodeList list = document.getElementsByTagName("person");
        for (int i=0; i<list.getLength(); i++) {
            Element element = (Element)list.item(i);
            String name = element.getElementsByTagName("name").item(0).getFirstChild().getNodeValue();
            String address = element.getElementsByTagName("address").item(0).getFirstChild().getNodeValue();
            String email = element.getElementsByTagName("email").item(0).getFirstChild().getNodeValue();
            System.out.println("person:["+name+","+address+","+email+"]");
        }
    }

}
