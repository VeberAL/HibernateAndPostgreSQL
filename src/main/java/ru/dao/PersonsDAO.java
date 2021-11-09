package ru.dao;
import com.sun.istack.NotNull;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.dbobject.Persons;

public class PersonsDAO implements DAO<Persons, Integer> {

    //Соединение с БД.
    private final SessionFactory factory;

    public PersonsDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    //Создание новой строки в таблице Persons.
    @Override
    public void create(@NotNull final Persons persons) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(persons);
            session.getTransaction().commit();
        }
    }

    @Override
    public Persons read(@NotNull final Integer p_id) {
        try (final Session session = factory.openSession()) {
            final Persons result = session.get(Persons.class, p_id);
            if (result != null) {
                Hibernate.initialize(result.getEmployee());
            }

            return result;
        }
    }



    @Override
    public void update(@NotNull final Persons persons) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(persons);
            session.getTransaction().commit();
        }
    }


    @Override
    public void delete(@NotNull final Persons persons) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(persons);
            session.getTransaction().commit();
        }
    }
}