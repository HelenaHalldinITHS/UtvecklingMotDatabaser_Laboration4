package org.example;

public class App {
    public static void main( String[] args ) {
        MemberDao memberDao = new MemberDaoImpl();

        Member helena = new Member("Helena", "Halldin", true);
        memberDao.create(helena);
    }
}
