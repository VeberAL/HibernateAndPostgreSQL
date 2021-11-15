package ru.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dao.DAOMtoM;
import ru.dao.ManyToMany.CarDAO;
import ru.dao.ManyToMany.EngineDAO;
import ru.dbobject.ManyToMany.Car;
import ru.dbobject.ManyToMany.Engine;

public class ReadEngine {
    public static void main(String[] args) {
        SessionFactory factory = null;
        try{
            factory = new Configuration().configure().buildSessionFactory();
            DAOMtoM<Engine, Integer> engineIntegerDAOMtoM = new EngineDAO(factory);
            DAOMtoM<Car, Integer> carIntegerDAOMtoM = new CarDAO<>(factory);
            //Вывод на экран двигателя с id=2
            final Engine result = engineIntegerDAOMtoM.read(2);
            System.out.println("Read: " + result);
        } finally {
            if (factory != null){
                factory.close();
            }
        }
    }

}
