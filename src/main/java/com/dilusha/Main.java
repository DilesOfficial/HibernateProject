package com.dilusha;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    static void main() {

        Student s1 = new  Student();
        s1.setsName("Vishal");
        s1.setRollNo(007);
        s1.setsAge(23);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(com.dilusha.Student.class);
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(s1);
        transaction.commit();

        System.out.println(s1);
    }
}
