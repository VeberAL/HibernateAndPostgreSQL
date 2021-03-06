package ru.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dao.DAO;
import ru.dao.OneToMany.PersonDAO;
import ru.dbobject.OneToMany.Person;

public class ReadPersonAndEmployee {
    public static void main(String[] args) {
        SessionFactory factory = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            DAO<Person, Integer> personsD = new PersonDAO(factory);

            final Person result = personsD.read(1);
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
