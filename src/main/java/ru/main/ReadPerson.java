package ru.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dao.DAO;
import ru.dao.PersonsDAO;
import ru.dbobject.Persons;

public class ReadPerson {
    public static void main(String[] args) {
        SessionFactory factory = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            DAO<Persons, String> personsStringDAO = new PersonsDAO(factory);

            final Persons result = personsStringDAO.read(5);
            System.out.println("Найдена строка : " + result);
            System.out.println();
            }
        finally{
                if (factory != null) {
                    factory.close();
                }
            }
        }
    }