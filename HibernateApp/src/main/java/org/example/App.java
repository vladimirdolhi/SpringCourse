package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            /*Person person = session.get(Person.class, 3);
            System.out.println(person);
            List<Item> items = person.getItems();
            System.out.println(items);*/

           /* Item item = session.get(Item.class, 5);
            System.out.println(item);
            Person owner = item.getOwner();
            System.out.println(owner);*/

           /* Person person2 = session.get(Person.class, 2);
            Item newItem = new Item("2 Item from hibernate", person2);
            person2.getItems().add(newItem);
            session.save(newItem);*/

            /*Person newPerson = new Person("TestPerson", 24);
            Item newItem = new Item("Item from hb 3", newPerson);
            person.setItems(new ArrayList<>(Collections.singletonList(newItem)));
            session.save(newPerson);
            session.save(newItem);*/

            /*Person person = session.get(Person.class, 3);
            List<Item> items = person.getItems();
            for (Item item: items)
                session.remove(item);

            items.clear();*/


            /*Person person = session.get(Person.class, 2);
            session.remove(person);
            person.getItems().forEach(i -> i.setOwner(null));*/

            Person person = session.get(Person.class, 4);
            Item item = session.get(Item.class, 1);

            item.getOwner().getItems().remove(item);
            item.setOwner(person);
            person.getItems().add(item);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
