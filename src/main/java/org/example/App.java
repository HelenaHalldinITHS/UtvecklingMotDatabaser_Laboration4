package org.example;

public class App {
    public static void main( String[] args ) {
        MemberDao memberDao = new MemberDaoImpl();

        /*
        memberDao.create(new Member("Helena", "Halldin", true));
        memberDao.create(new Member("Stina","Karlsson", false));
        memberDao.create(new Member("Muhamad","Ali", true));
        memberDao.create(new Member("Tobias","Eklund", true));
        memberDao.create(new Member("Sara","Olsson", false));
        memberDao.create(new Member("Amanda","White", false));

        System.out.println(memberDao.getById(1));

        memberDao.getAll().forEach(System.out::println);

        Member tobias = memberDao.getById(4);
        tobias.setLastName("Halldin");
        memberDao.update(tobias);

        Member amanda = memberDao.getById(6);
        memberDao.delete(amanda);

        memberDao.getActiveMembers().forEach(System.out::println);

        memberDao.getInactiveMembers().forEach(System.out::println);
         */
        memberDao.getById(7).ifPresentOrElse(System.out::println, () -> System.out.println("Det finns ingen member med detta id"));





    }
}
