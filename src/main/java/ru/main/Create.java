package ru.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dao.DAO;
import ru.dao.EmployeesDAO;
import ru.dao.PersonDAO;
import ru.dbobject.Employees;
import ru.dbobject.Person;

public class Create {
    public static void main(String[] args) {
        SessionFactory factory = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            DAO<Person, Integer> personDAO = new PersonDAO(factory);

            final Person person = new Person();
            person.setP_FirstName("Ben");
            person.setP_LastName("Kenobi");
            person.setP_Gender("man");
            person.setP_Age(58);
            person.setP_City("Mos Eosli");
            Employees employees = new Employees();
            employees.setE_Title("Technique");
            employees.setE_Salary(1000);
            person.setEmployees(employees);
            personDAO.create(person);
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }
}