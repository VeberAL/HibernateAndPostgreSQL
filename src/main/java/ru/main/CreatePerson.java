package ru.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dao.DAO;
import ru.dao.PersonsDAO;
import ru.dbobject.Persons;

public class CreatePerson {
    public static void main(String[] args) {
        SessionFactory factory = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            DAO<Persons, String> personsStringDAO = new PersonsDAO(factory);

            final Persons persons = new Persons();
            persons.setP_Id(5);
            persons.setP_FirstName("Ben");
            persons.setP_LastName("Kenobi");
            persons.setP_Age(50);
            persons.setP_Gender("man");
            persons.setP_City("Mos-Eisli");
            personsStringDAO.create(persons);
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }
}