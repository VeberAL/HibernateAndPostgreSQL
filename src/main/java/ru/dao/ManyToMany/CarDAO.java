package ru.dao.ManyToMany;

//import com.sun.istack.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.dao.DAO;
import ru.dao.DAOMtoM;
import ru.dbobject.ManyToMany.Car;

import javax.validation.constraints.NotNull;

public class CarDAO<Entity, Key> implements DAOMtoM<Car, Integer> {
    /**
     * Connection factory to database.
     */
    private final SessionFactory factory;

    public CarDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Car read(Integer id) {
        try (final Session session = factory.openSession()) {
            return session.get(Car.class, id);
        }
    }
}