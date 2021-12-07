package org.example;

import java.util.List;

public interface MemberDao {
    Member getById(int id);
    List<Member> getAll();
    void update(Member student);
    void create(Member student);
    void delete(Member student);
    List<Member> getActiveMembers();
    List<Member> getInactiveMembers();
}
