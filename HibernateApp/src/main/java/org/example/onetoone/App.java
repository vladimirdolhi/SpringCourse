package org.example.onetoone;

import org.example.onetoone.model.Passport;
import org.example.onetoone.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

           /* //Save passport and person

            Person person = new Person("Test person3", 50);
            Passport passport = new Passport(12399);

            person.setPassport(passport);

            session.save(person);*/

           /* //Read passport from person
            Person person = session.get(Person.class, 9);
            System.out.println(person.getPassport().getPassportNumber());
            */

           /* //Read person from passport
            Passport passport = session.get(Passport.class, 9);
            System.out.println(passport.getPerson().getName());*/

           /* //Change persons passport number
            Person person = session.get(Person.class, 9);
            person.getPassport().setPassportNumber(99999);*/

            /*//delete
            Person person = session.get(Person.class, 9);
            session.remove(person);*/


            session.getTransaction().commit();



        } finally {
            sessionFactory.close();
        }
    }
}
