package ru.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dao.DAO;
import ru.dao.EmployeesDAO;
import ru.dbobject.Employees;


public class CreateEmployee {
    public static void main(String[] args) {
        SessionFactory factory = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            DAO<Employees, String> employeeStringDAO = new EmployeesDAO(factory);

            final Employees employees = new Employees();
            employees.setE_Id(4);
            employees.setE_Title("Senior Ingineer");
            employees.setE_Salary("2000");
            employeeStringDAO.create(employees);
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }
}