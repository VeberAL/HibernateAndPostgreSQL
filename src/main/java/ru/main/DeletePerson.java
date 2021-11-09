package ru.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dao.DAO;
import ru.dao.PersonsDAO;
import ru.dbobject.Persons;

public class DeletePerson {
    public static void main(String[] args) {

        SessionFactory factory = null;

        try {

            factory = new Configuration().configure().buildSessionFactory();
            DAO<Persons, String> personsDAO = new PersonsDAO(factory);

            final Persons result = personsDAO.read(5);
            System.out.println("Read : " + result);
            System.out.println();
            personsDAO.delete(new Persons(5,"Ben","Kenobi",50,"man","Mos-Eisli",3));
            System.out.println("Удалена строка : " + personsDAO.read(5));
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }
}
