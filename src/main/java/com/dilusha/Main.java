package com.dilusha;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    static void main() {

        Student s1 = new  Student();
//        s1.setsName("Pasindu");
//        s1.setRollNo(8);
//        s1.setsAge(23);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.dilusha.Student.class)
                .configure()
                .buildSessionFactory(); //cfg.buildSessionFactory();

        Session session = sf.openSession();
        s1 = session.find(Student.class, 10);

        Transaction transaction = session.beginTransaction();
        session.remove(s1);
        transaction.commit();

        session.close();
        sf.close();

        System.out.println(s1);
    }
}
