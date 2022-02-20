package com.umaraliev.crud.repository.impl;

import com.umaraliev.crud.model.Developer;
import com.umaraliev.crud.repository.DeveloperRepository;
import com.umaraliev.crud.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DeveloperRepositoryImpl implements DeveloperRepository {

    private Transaction transaction;

    @Override
    public Developer getById(Integer integer) {

        Developer developer = new Developer();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            developer = session.get(Developer.class, integer);

            transaction.commit();

        }catch (Throwable e){
            transaction.rollback();
            System.out.println("IN get by id exception: " + e.getMessage());
        }
        return developer;
    }

    @Override
    public List<Developer> getAll() {
        
        List<Developer> developerList = null;
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            transaction = session.beginTransaction();

            developerList = session.createQuery("From Developer ").list();

            for (Developer next : developerList) {
                System.out.println("next skill: " + next);
            }

        }catch (Throwable e){
            transaction.rollback();
            System.out.println("IN get all exception: " + e.getMessage());
        }
        return developerList;
    }

    @Override
    public Developer save(Developer developer) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(developer);

            transaction.commit();

        } catch (Throwable e) {
            transaction.rollback();
            System.out.println("IN save exception: " + e.getMessage());
        }

        return developer;
    }

    @Override
    public Developer update(Developer developer) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.saveOrUpdate(developer);

            transaction.commit();

        }catch (Throwable e){
            transaction.rollback();
            System.out.println("IN update exception: " + e.getMessage());
        }

        return developer;

    }

    @Override
    public void deleteById(Integer integer) {

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Developer developer = (Developer) session.get(Developer.class, integer);

            session.delete(developer);

            transaction.commit();

        }catch (Throwable e){
            transaction.rollback();
            System.out.println("IN delete exception: " + e.getMessage());
        }

    }
}
