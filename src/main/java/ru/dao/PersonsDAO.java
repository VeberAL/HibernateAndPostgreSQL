package ru.dao;
import com.sun.istack.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.dbobject.Persons;

public class PersonsDAO implements DAO<Persons, String> {

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
    //Чтение строки из таблице Persons.
    @Override
    public Persons read(@NotNull final int p_id) {
        try (final Session session = factory.openSession()) {
            final Persons result = session.get(Persons.class, p_id);
            return result != null ? result : new Persons();
        }
    }

    @Override
    public void update(Persons persons) {

    }

    @Override
    public void delete(Persons persons) {

    }
}