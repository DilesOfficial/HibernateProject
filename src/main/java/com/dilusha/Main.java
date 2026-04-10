package com.dilusha;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    static void main() {

        Laptop l1 = new Laptop();
        l1.setLid(900);
        l1.setBrand("Apple");
        l1.setModel("Macbook Pro");
        l1.setRam(16);

        Laptop l2 = new Laptop();
        l2.setLid(901);
        l2.setBrand("Asus");
        l2.setModel("Zenbook Pro");
        l2.setRam(32);

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Dilusha");
        a1.setTech("Java");
        a1.setLaptops(Arrays.asList(l1,l2));

        l1.setAlien(a1);
        l2.setAlien(a1);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.dilusha.Alien.class)
                .addAnnotatedClass(com.dilusha.Laptop.class)
                .configure()
                .buildSessionFactory(); //cfg.buildSessionFactory();

        Session session = sf.openSession();

        session.persist(l1);
        session.persist(l2);
        session.persist(a1);

        Transaction transaction = session.beginTransaction();

        transaction.commit();

        Alien a2 = session.find(Alien.class, 101);
        System.out.println(a2);

        session.close();
        sf.close();


    }
}
