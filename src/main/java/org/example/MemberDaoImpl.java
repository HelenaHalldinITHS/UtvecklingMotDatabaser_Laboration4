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
    public Member getById(int id) {
        return null;
    }

    @Override
    public List<Member> getAll() {
        return null;
    }

    @Override
    public void update(Member student) {

    }

    @Override
    public void create(Member student) {

    }

    @Override
    public void delete(Member student) {

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
