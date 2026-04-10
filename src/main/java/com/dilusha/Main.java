package com.dilusha;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class Main {
    static void main() {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.dilusha.Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();


        // SELECT * FROM laptop WHERE ram=32  -> SQL
        // from laptop where ram=32   -> HQL

        String brand = "Apple";

        Query query = session.createQuery("select brand, model from Laptop where brand like ?1");
        query.setParameter(1, brand);
        List<Object[]> laptops = query.getResultList();

        //Laptop l1 = session.find(Laptop.class, 904);

        for (Object[] data : laptops) {
            System.out.println((String) data[0] + " " + (String)data[1]);
        }

        System.out.println(laptops);


        session.close();

        sf.close();


    }
}
