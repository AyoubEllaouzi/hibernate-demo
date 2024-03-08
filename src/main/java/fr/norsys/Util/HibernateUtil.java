package fr.norsys.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

     static SessionFactory sessionFactory;
     static Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

    public static Session getSession() {
        sessionFactory = configuration.buildSessionFactory();
        return sessionFactory.openSession();
    }

    public static void closeSession(Session session) {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
}
