package com.dilusha;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    static void main() {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.dilusha.Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Laptop laptop = session.getReference(Laptop.class, 900);
        //System.out.println(laptop);


        session.close();

        sf.close();


    }
}
