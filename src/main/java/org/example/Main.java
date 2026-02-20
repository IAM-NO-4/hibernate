package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

class Main {
    public static void main(String[] args) {
        SessionFactory fac = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();

        Session session = fac.openSession();

        try {
            session.beginTransaction();

       for(int i = 0; i <31; i++){
           Student s = new Student("Name" + i, i%20,"class"+ i);
           session.save(s);
           if(i%10 == 0){
                session.flush();
                session.clear();
           }

       }

            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("bigaanye");
            e.printStackTrace();
        } finally {
            session.close();
            fac.close();
        }
    }
}
