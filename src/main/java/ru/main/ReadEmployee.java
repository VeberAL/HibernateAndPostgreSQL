package ru.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dao.DAO;
import ru.dao.OneToMany.EmployeesDAO;
import ru.dbobject.OneToMany.Employees;


public class ReadEmployee {
    public static void main(String[] args) {
        SessionFactory factory = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            DAO<Employees, String> employeeStringDAO = new EmployeesDAO(factory);

            final Employees result = employeeStringDAO.read("5");
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