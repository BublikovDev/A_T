package Lab5;

import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/*import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;*/


import java.io.*;
import java.util.stream.Collectors;

public class Person {
    public String name;
    public int age;
    public boolean isMarried;
    public Address address;

    @Override
    public String toString() {
        return "Name: "+name+"\nAge: "+age+"\nIs Married: "+isMarried+"\n"+address;
    }

    public static void main(String[] args) throws IOException {

        File inputFileJson = new File("input.json");
        FileInputStream inputJson = new FileInputStream(inputFileJson);

        ObjectMapper objectMapper = new ObjectMapper();
        Person personJSON = objectMapper.readValue(inputJson, Person.class);

        personJSON.name = "Kyrylo";
        personJSON.age = 19;
        personJSON.isMarried=false;
        personJSON.address.state = "Ukraine";
        personJSON.address.city = "Lviv";

        objectMapper.writeValue(new File("output.json"), personJSON);

        XmlMapper xmlMapper =new XmlMapper();
        Person personXML = xmlMapper.readValue(new File("input.xml"),Person.class);

        personXML.name = "Dmytro";
        personXML.age = 25;
        personXML.isMarried=true;
        personXML.address.state = "Ukraine";
        personXML.address.city = "Kyiv";

        xmlMapper.writeValue(new File("output.xml"),personXML);
        System.out.println(personXML);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
