package org.example;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SaxMyParser {

    public static List<Employee> parser(File file) {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }
        SearchingXMLHandler handler = new SearchingXMLHandler();
        try {
            parser.parse(file, handler);
        } catch (SAXException | IOException e) {
            throw new RuntimeException(e);
        }
        return handler.getStaff();
    }
}
