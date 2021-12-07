package org.example;

import java.util.List;

public interface MemberDao {
    Member getById(int id);
    List<Member> getAll();
    void update(Member member);
    void create(Member member);
    void delete(Member member);
    List<Member> getActiveMembers();
    List<Member> getInactiveMembers();
}
