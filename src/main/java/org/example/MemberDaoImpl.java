package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MemberDaoImpl implements MemberDao{
    EntityManagerFactory emf;
    EntityManager em;

    public MemberDaoImpl() {
        emf = Persistence.createEntityManagerFactory("jpa");
        em = emf.createEntityManager();
    }

    @Override
    public void create(Member member) {
        em.getTransaction().begin();
        em.persist(member);
        em.getTransaction().commit();
    }

    @Override
    public Member getById(int id) {
        return em.find(Member.class,id);
    }

    @Override
    public List<Member> getAll() {
        return em.createQuery("select m from Member m",Member.class).getResultList();
    }

    @Override
    public void update(Member member) {
        em.getTransaction().begin();
        em.merge(member);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Member member) {
        em.getTransaction().begin();
        em.remove(member);
        em.getTransaction().commit();
    }

    @Override
    public List<Member> getActiveMembers() {
        return null;
    }

    @Override
    public List<Member> getInactiveMembers() {
        return null;
    }
}
