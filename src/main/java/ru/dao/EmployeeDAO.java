package ru.dao;
import com.sun.istack.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.dbobject.Employee;
import ru.dbobject.Persons;

public class EmployeeDAO implements DAO<Employee, String> {

    //Соединение с БД.
    private final SessionFactory factory;

    public EmployeeDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public void create(@NotNull final Employee employee) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        }
    }

    @Override
    public Employee read(@NotNull final String E_Id) {
        try (final Session session = factory.openSession()) {
            final Employee result = session.get(Employee.class, E_Id);
            return result != null ? result : new Employee();
        }
    }

    @Override
    public void update(Employee employee) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Employee employee) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(employee);
            session.getTransaction().commit();
        }
    }
}