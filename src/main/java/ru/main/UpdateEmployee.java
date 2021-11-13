package ru.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dao.DAO;
import ru.dao.OneToMany.EmployeesDAO;
import ru.dbobject.OneToMany.Employees;


public class UpdateEmployee {
    public static void main(String[] args) {
        SessionFactory factory = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            DAO<Employees, String> employeeStringDAO = new EmployeesDAO(factory);
            //Считываем строку с id=5 и устанавливаем сеттером новое значение поля P_FirstName, затем обновляем с помощью update
            final Employees result = employeeStringDAO.read("3");
            result.setE_Salary(1900);
            employeeStringDAO.update(result);

            final Employees update = employeeStringDAO.read("3");
            System.out.println("Изменено : " + update);
            System.out.println();}
              finally{
                if (factory != null) {
                    factory.close();
                }
            }
    }
}
