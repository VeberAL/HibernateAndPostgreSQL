package ru.dao.AnnotationConfig;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        System.out.println("uuu");
    }
}
