package com.umaraliev.crud.repository.impl;

import com.umaraliev.crud.model.Developer;
import com.umaraliev.crud.model.Skill;
import com.umaraliev.crud.model.Team;
import com.umaraliev.crud.repository.TeamRepository;
import com.umaraliev.crud.utils.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TeamRepositoryImpl implements TeamRepository {

    private Transaction transaction;

    @Override
    public Team getById(Integer integer) {

        Team team = new Team();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            team = session.get(Team.class, integer);

            transaction.commit();

        }catch(Throwable e){
            transaction.rollback();
            System.out.println("IN get by id exception: " + e.getMessage());
        }
        return team;
    }

    @Override
    public List<Team> getAll() {

        List<Team> teamList = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            teamList = session.createQuery("From Team ").list();

            for (Team team : teamList) {
                System.out.println("team: " + team);
            }

        }catch (Throwable e){
            transaction.rollback();
            System.out.println("In get all exception: " + e.getMessage());
        }
        return teamList;
    }

    @Override
    public Team save(Team team) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(team);

            transaction.commit();

        } catch (Throwable e) {
            transaction.rollback();
            System.out.println("IN save exception: " + e.getMessage());
        }
        return team;
    }

    @Override
    public Team update(Team team) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.update(team);

            transaction.commit();

        }catch (Throwable e){
            transaction.rollback();
            System.out.println("IN update exception: " + e.getMessage());
        }
        return team;
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
