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
        l1.setRam(24);

        Laptop l2 = new Laptop();
        l2.setLid(901);
        l2.setBrand("Asus");
        l2.setModel("Zenbook Pro");
        l2.setRam(32);

        Laptop l3 = new Laptop();
        l3.setLid(902);
        l3.setBrand("Microsoft");
        l3.setModel("Surface Pro");
        l3.setRam(32);

        Alien a1 = new Alien();
        a1.setAid(100);
        a1.setAname("Dilusha");
        a1.setTech("Java");

        Alien a2 = new Alien();
        a2.setAid(101);
        a2.setAname("Eshan");
        a2.setTech("JavaScript");

        Alien a3 = new Alien();
        a3.setAid(102);
        a3.setAname("Fernando");
        a3.setTech("Python");

        a1.setLaptops(Arrays.asList(l1,l2));
        a2.setLaptops(Arrays.asList(l2,l3));
        a3.setLaptops(Arrays.asList(l1));

        l1.setAliens(Arrays.asList(a1,a3));
        l2.setAliens(Arrays.asList(a1,a2));
        l3.setAliens(Arrays.asList(a2));

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.dilusha.Alien.class)
                .addAnnotatedClass(com.dilusha.Laptop.class)
                .configure()
                .buildSessionFactory(); //cfg.buildSessionFactory();

        Session session = sf.openSession();

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        session.persist(a1);
        session.persist(a2);
        session.persist(a3);


        Transaction transaction = session.beginTransaction();

        transaction.commit();

        Alien a5 = session.find(Alien.class, 101);
        System.out.println(a2);

        session.close();
        sf.close();


    }
}
