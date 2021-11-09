package ru.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dao.DAO;
import ru.dao.EmployeeDAO;
import ru.dbobject.Employee;


public class CreateEmployee {
    public static void main(String[] args) {
        SessionFactory factory = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            DAO<Employee, String> employeeStringDAO = new EmployeeDAO(factory);

            final Employee employee = new Employee();
            employee.setE_Id(4);
            employee.setE_Title("Senior Ingineer");
            employee.setE_Salary("2000");
            employeeStringDAO.create(employee);
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }
}