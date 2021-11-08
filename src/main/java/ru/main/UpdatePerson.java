package ru.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dao.DAO;
import ru.dao.PersonsDAO;
import ru.dbobject.Persons;

public class UpdatePerson {
    public static void main(String[] args) {
        SessionFactory factory = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            DAO<Persons, String> personsStringDAO = new PersonsDAO(factory);
            //Считываем строку с id=5 и устанавливаем сеттером новое значение поля P_FirstName, затем обновляем с помощью update
            final Persons result = personsStringDAO.read(5);
            result.setP_FirstName("Obe One");
            personsStringDAO.update(result);

            final Persons update = personsStringDAO.read(5);
            System.out.println("Изменено : " + update);
            System.out.println();}
              finally{
                if (factory != null) {
                    factory.close();
                }
            }
    }
}
