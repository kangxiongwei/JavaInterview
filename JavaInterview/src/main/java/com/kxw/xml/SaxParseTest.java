package com.kxw.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Created by kangxiongwei on 2015/7/13.
 */
public class SaxParseTest {

    public static void main(String[] args) throws Exception {
        String path = SaxParseTest.class.getClassLoader().getResource("").getPath();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File(path + "/canlidate.xml"), new MySAXHandler());
    }

    private static class MySAXHandler extends DefaultHandler {

        @Override
        public void startDocument() throws SAXException {
            System.out.println("~~~~~~~~~~~~~~~~~start document parse~~~~~~~~~~~~~~~~~");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start Element name: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String content = new String(ch, start, length);
            System.out.println("Element content: " + content);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element name: " + qName);
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("~~~~~~~~~~~~~~~~~end document parse~~~~~~~~~~~~~~~~~");
        }
    }

}
