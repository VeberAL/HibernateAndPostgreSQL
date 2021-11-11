package ru.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dao.DAO;
import ru.dao.EmployeesDAO;
import ru.dbobject.Employees;

public class DeleteEmployee {
    public static void main(String[] args) {

        SessionFactory factory = null;

        try {

            factory = new Configuration().configure().buildSessionFactory();
            DAO<Employees, String> employeeStringDAO = new EmployeesDAO(factory);

            final Employees result = employeeStringDAO.read("4");
            System.out.println("Read : " + result);
            System.out.println();
            employeeStringDAO.delete(new Employees(4,"Senior Ingineer","2000"));
            System.out.println("Удалена строка : " + employeeStringDAO.read("4"));
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }
}
