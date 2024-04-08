package org.example;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SearchingXMLHandler extends DefaultHandler {
    List<Employee> staff = new ArrayList<>();
    private String lastElementName;
    private String firstName;
    private String lastName;
    private String country;
    private int id;
    private int age;

    public List<Employee> getStaff() {
        return staff;
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElementName = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String information = new String(ch, start, length);
        information = information.replace("\n", "").trim();
        if (!information.isEmpty()) {
            switch (lastElementName) {
                case "id":
                    try {
                        id = Integer.parseInt(information);
                    } catch (NumberFormatException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "firstName":
                    firstName = information;
                    break;
                case "lastName":
                    lastName = information;
                    break;
                case "country":
                    country = information;
                    break;
                case "age":
                    try {
                        age = Integer.parseInt(information);
                    } catch (NumberFormatException e) {
                        throw new RuntimeException(e);
                    }
            }
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ((firstName != null && !firstName.isEmpty()) && ((lastName != null && !lastName.isEmpty())) && ((country != null && !country.isEmpty())) && (id != 0) && (age != 0)) {
            staff.add(new Employee(id, firstName, lastName, country, age));
            id = 0;
            firstName = null;
            lastName = null;
            country = null;
            age = 0;
        }
    }
}

