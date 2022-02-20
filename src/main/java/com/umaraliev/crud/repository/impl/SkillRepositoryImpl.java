package com.umaraliev.crud.repository.impl;

import com.umaraliev.crud.model.Developer;
import com.umaraliev.crud.model.Skill;
import com.umaraliev.crud.model.Team;
import com.umaraliev.crud.repository.SkillRepository;
import com.umaraliev.crud.utils.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SkillRepositoryImpl implements SkillRepository{

    private Transaction transaction;

    @Override
    public Skill getById(Integer integer) {

        Skill skill = new Skill();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            skill = session.get(Skill.class, integer);

            transaction.commit();

        }catch (Throwable e){
            transaction.rollback();
            System.out.println("IN get by id exception: " + e.getMessage());
        }
        return skill;
    }

    @Override
    public List<Skill> getAll() {

        List<Skill> skills = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            skills = session.createQuery("From Skill ").list();

            for (Skill next : skills) {
                System.out.println("next skill: " + next);
            }


        }catch (Throwable e){
            transaction.rollback();
            System.out.println("IN get all exception:" + e.getMessage());
        }
            return skills;
    }

    public Skill save(Skill skill) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(skill);

            transaction.commit();

        } catch (Throwable e) {
            transaction.rollback();
            System.out.println("IN save exception: " + e.getMessage());
        }

        return skill;
    }

    public Skill update(Skill skill) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.update(skill);

            transaction.commit();

        }catch (Throwable e){
            transaction.rollback();
            System.out.println("IN update exception: " + e.getMessage());
        }

        return skill;
    }

    public void deleteById(Integer integer) {

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Skill skill = (Skill) session.get(Skill.class, integer);

            session.delete(skill);

            transaction.commit();

        }catch (Throwable e){
            transaction.rollback();
            System.out.println("IN delete exception: " + e.getMessage());
        }
    }
}
