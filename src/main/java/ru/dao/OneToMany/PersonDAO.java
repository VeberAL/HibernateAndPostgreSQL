package ru.dao.OneToMany;
import com.sun.istack.NotNull;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.dao.DAO;
import ru.dbobject.OneToMany.Person;

public class PersonDAO implements DAO<Person, Integer> {

    //Соединение с БД.
    private final SessionFactory factory;

    public PersonDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    //Создание новой строки в таблице Persons.
    @Override
    public void create(@NotNull final Person person) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        }
    }

    @Override
    public Person read(@NotNull final Integer p_id) {
        try (final Session session = factory.openSession()) {
            final Person result = session.get(Person.class, p_id);
            if (result != null) {
                Hibernate.initialize(result.getEmployees());
            }

            return result;
        }
    }



    @Override
    public void update(@NotNull final Person person) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(person);
            session.getTransaction().commit();
        }
    }


    @Override
    public void delete(@NotNull final Person person) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(person);
            session.getTransaction().commit();
        }
    }
}