package ru.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dao.DAO;
import ru.dao.PersonDAO;
import ru.dbobject.Person;

public class Update {
    public static void main(String[] args) {
        SessionFactory factory = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            DAO<Person, Integer> personsD = new PersonDAO(factory);

            final Person result = personsD.read(1);
            System.out.println("Найдена строка : " + result);
            System.out.println();
            result.setP_FirstName("Obe One");
            result.setP_LastName("Kenobi");
            result.getEmployees().setE_Title("Engineer");
            result.getEmployees().setE_Salary(1500);
            personsD.update(result);
            System.out.println("Строка модифицирована: "+personsD.read(1));
        }
        finally{
            if (factory != null) {
                factory.close();
            }
        }
    }
}
