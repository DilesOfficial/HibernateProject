package com.dilusha;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    static void main() {

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Dilusha");
        a1.setTech("Java");


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.dilusha.Alien.class)
                .configure()
                .buildSessionFactory(); //cfg.buildSessionFactory();

        Session session = sf.openSession();

        session.persist(a1);

        Transaction transaction = session.beginTransaction();

        transaction.commit();

        session.close();
        sf.close();


    }
}
