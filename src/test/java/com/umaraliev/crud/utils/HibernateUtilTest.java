package com.umaraliev.crud.utils;

import junit.framework.TestCase;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class HibernateUtilTest{

    private static SessionFactory sessionFactory;


    static {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Before
    public void testGetSessionFactoryOpen() {
        getSessionFactory().openSession();
    }

    @Test
    public void testGetSessionFactory() {
        Assert.assertEquals(true, getSessionFactory().isOpen());
    }

    @After
    public void testGetSessionFactoryClose() {
        getSessionFactory().close();
    }
}