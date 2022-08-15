package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            session.createQuery("update Person  set name='TEST' where age >= 40").executeUpdate();
            session.createQuery("delete Person  where age <= 20").executeUpdate();

            List<Person> peopleList = session.createQuery("FROM Person where name LIKE 'T%'").getResultList();

            for (Person person: peopleList)
                System.out.println(person);
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
