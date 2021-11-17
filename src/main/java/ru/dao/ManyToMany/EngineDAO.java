package ru.dao.ManyToMany;
//import com.sun.istack.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.dao.DAOMtoM;
import ru.dbobject.ManyToMany.Engine;

import javax.validation.constraints.NotNull;

public class EngineDAO implements DAOMtoM<Engine, Integer> {

    private final SessionFactory factory;
    public EngineDAO(@NotNull final SessionFactory factory){this.factory = factory;}
    @Override
    public Engine read(@NotNull final Integer id) {
        try(final Session session = factory.openSession()){
            return session.get(Engine.class, id);
        }
    }
}
