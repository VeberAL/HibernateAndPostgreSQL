package ru.dao.OneToMany;
//import com.sun.istack.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.dao.DAO;
import ru.dbobject.OneToMany.Employees;

import javax.validation.constraints.NotNull;

public class EmployeesDAO implements DAO<Employees, String> {

    //Соединение с БД.
    private final SessionFactory factory;

    public EmployeesDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public void create(@NotNull final Employees employees) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(employees);
            session.getTransaction().commit();
        }
    }

    @Override
    public Employees read(@NotNull final String E_Id) {
        try (final Session session = factory.openSession()) {
            final Employees result = session.get(Employees.class, E_Id);
            return result != null ? result : new Employees();
        }
    }

    @Override
    public void update(Employees employees) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(employees);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Employees employees) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(employees);
            session.getTransaction().commit();
        }
    }
}