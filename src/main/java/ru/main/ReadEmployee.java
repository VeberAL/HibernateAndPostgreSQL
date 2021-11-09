package ru.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dao.DAO;
import ru.dao.EmployeeDAO;
import ru.dbobject.Employee;


public class ReadEmployee {
    public static void main(String[] args) {
        SessionFactory factory = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            DAO<Employee, String> employeeStringDAO = new EmployeeDAO(factory);

            final Employee result = employeeStringDAO.read("5");
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