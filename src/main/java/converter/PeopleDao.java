package converter;

import entity.Family;
import entity.Person;

import java.io.FileNotFoundException;
import java.util.List;

public interface PeopleDao {

    void jaxb(List<Person> listPerson, List<Family> listOfFamily) throws FileNotFoundException;

    void convertFileToList();


}
