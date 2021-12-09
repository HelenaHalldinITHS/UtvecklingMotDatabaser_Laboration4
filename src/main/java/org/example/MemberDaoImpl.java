package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class MemberDaoImpl implements MemberDao {
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
    public Optional<Member> getById(int id) {
        return Optional.ofNullable(em.find(Member.class, id));
    }

    @Override
    public List<Member> getAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
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
        return em.createQuery("select m from Member m where m.active = true", Member.class).getResultList();
    }

    @Override
    public List<Member> getInactiveMembers() {
        return em.createQuery("select m from Member m where m.active = false", Member.class).getResultList();
    }

    @Override
    public List<Member> getByLastName(String lastName) {
        TypedQuery<Member> query = em.createQuery("select m from Member m where m.lastName = :lastname", Member.class);
        query.setParameter("lastname", lastName);
        return query.getResultList();
    }

    @Override
    public List<Member> getByRegistrationDateInterval(Date from, Date to) {
        TypedQuery<Member> query = em.createQuery("select m from Member m where m.registrationDate between :from and :to", Member.class);
        query.setParameter("from", from);
        query.setParameter("to", to);
        return query.getResultList();
    }

    @Override
    public List<Member> getByMembershipType(MembershipType membershipType) {
        TypedQuery<Member> query = em.createQuery("select m from Member m where m.membershipType = :membershipType", Member.class);
        query.setParameter("membershipType", membershipType);
        return query.getResultList();

    }
}
