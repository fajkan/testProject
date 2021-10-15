package converter;

import entity.Family;
import entity.Person;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlElement;



public class PeopleDaoImpl implements PeopleDao {


    @XmlElement
    private Person person;


    public void jaxb(List<Person> listPerson, List<Family> listOfFamily) throws FileNotFoundException {

        try {
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class, Family.class);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        File file = new File("src/main/resources/people.xml");
        PrintWriter out = new PrintWriter(file);


        for(Person person : listPerson){

                jaxbMarshaller.marshal(person, out);
            }
        for (Family family : listOfFamily){
            jaxbMarshaller.marshal(family,out);
        }

    } catch (JAXBException e) {
        e.printStackTrace();
    }

    }



    public void convertFileToList() {
        String line;
        char[] chars;
        char lastPeople = ' ';
        int counter = 0;
        String[] parts = null;
        String firstName = null;
        String lastName = null;
        String birthYear = null;
        String address = null;
        String street = null;
        String mobileNo = null;
        String landLine = null;
        List<Person> listPersons = new ArrayList<>();
        List<Family> listFamily = new ArrayList<>();
        File file = new File("src/main/java/converter/PeopleToConvert.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            while ((line = br.readLine()) != null){
                chars = line.toCharArray();


                if(chars[0] == 'P') {
                    if (counter > 0 && chars[0] == 'P') {
                        if (lastPeople == 'P') {
                            //Person person = new Person(firstName,lastName,mobileNo, landLine, address, street);
                            this.person = new Person(firstName,lastName,mobileNo, landLine, address, street);
                            listPersons.add(person);
                            counter = 0;
                        } else if (lastPeople == 'F') {
                            Family family = new Family(firstName,birthYear,mobileNo,landLine,address,street);
                            listFamily.add(family);

                            counter = 0;
                        }
                    }

                    counter++;
                    lastPeople = 'P';
                    parts = line.split("\\|");
                    firstName = parts[1];
                    lastName = parts[2];
                    System.out.println(firstName);
                }else if (chars[0] == 'F'){
                    if (counter > 0 && chars[0] == 'F') {
                        if (lastPeople == 'P') {
                            Person person = new Person(firstName,lastName,mobileNo, landLine, address, street);
                            listPersons.add(person);
                            counter = 0;
                        } else if (lastPeople == 'F') {
                            Family family = new Family(firstName,birthYear,mobileNo,landLine,address,street);
                            listFamily.add(family);
                            counter = 0;
                        }


                        counter++;
                        lastPeople = 'F';
                        parts = line.split("\\|");
                        firstName = parts[1];
                        birthYear = parts[2];

                    }

                    }else if (chars[0] == 'A'){
                        counter++;
                        parts = line.split("\\|");
                        address = parts[1];
                        street = parts[2];
                    }else if (chars[0] == 'T'){
                        counter++;
                        parts = line.split("\\|");
                        mobileNo = parts[1];
                        landLine = parts[2];
                    }
                }
            if (counter>0){
                if(lastPeople == 'P'){
                    Person person = new Person(firstName,lastName,mobileNo, landLine, address, street);
                    listPersons.add(person);
                    counter = 0;
                }else if(lastPeople =='F'){
                    Family family = new Family(firstName,birthYear,mobileNo,landLine,address,street);
                    listFamily.add(family);
                    counter = 0;
                }

            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            jaxb(listPersons,listFamily);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }


}
