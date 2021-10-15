import converter.PeopleDaoImpl;
import entity.Family;
import entity.People;
import entity.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {







        PeopleDaoImpl peopleDao = new PeopleDaoImpl();
        peopleDao.convertFileToList();


/*
        peopleDao.convertFileToList();


        temp.add(new Person("a","b","c","d"));
        temp.add(new Family("1","3","4"));

        peopleDao.jaxbListToXML(temp);

        //peopleDao.jaxbObjectToXML(asd);
*/


    }
}



