package org.example;

import java.sql.Date;
import java.util.Optional;

public class App {
    public static void main( String[] args ) {
        MemberDao memberDao = new MemberDaoImpl();

        memberDao.create(new Member("Helena", "Halldin", true, Date.valueOf("2011-01-20")));
        memberDao.create(new Member("Stina","Karlsson", false, Date.valueOf("2011-04-05")));
        memberDao.create(new Member("Muhamad","Ali", true, Date.valueOf("2013-03-20")));
        memberDao.create(new Member("Tobias","Eklund", true, Date.valueOf("2017-06-22")));
        memberDao.create(new Member("Sara","Olsson", false, Date.valueOf("2018-12-09")));
        memberDao.create(new Member("Amanda","White", false, Date.valueOf("2019-12-02")));

        // Test av getById:
        System.out.println("Test av getById():");
        System.out.println("Medlem med id 1: " + memberDao.getById(1));
        memberDao.getById(7).ifPresentOrElse(System.out::println, () -> System.out.println("Det finns ingen medlem med id 7"));
        System.out.println();

        //Test av getAll:
        System.out.println("Test av getAll():");
        memberDao.getAll().forEach(System.out::println);
        System.out.println();

        //Test av update:
        System.out.println("Test av update():");
        System.out.print("Efternamnet borde vara Eklund före uppdatering: ");
        Optional<Member> tobias = memberDao.getById(4);
        tobias.ifPresent((System.out::println));
        tobias.ifPresent(member -> member.setLastName("Halldin"));
        tobias.ifPresent(memberDao::update);
        System.out.print("Efternamnet borde vara Halldin efter uppdatering: ");
        memberDao.getById(4).ifPresent((System.out::println));
        System.out.println();

        //test av delete:
        System.out.println("Test av delete():");
        Optional<Member> amanda = memberDao.getById(6);
        amanda.ifPresent(member -> System.out.println("Detta skrivs om amanda finns"));
        System.out.println("delete...");
        amanda.ifPresent(memberDao::delete);
        Optional<Member> amandaAfterDelete = memberDao.getById(6);
        amandaAfterDelete.ifPresentOrElse(member -> System.out.println("Detta skrivs om amanda finns"), () -> System.out.println("Detta skrivs om amanda INTE finns"));
        System.out.println();

        //test av getActiveMembers():
        System.out.println("Test av getActiveMembers: ");
        memberDao.getActiveMembers().forEach(System.out::println);
        System.out.println();

        //test av getInactiveMembers():
        System.out.println("Test av getInactiveMembers: ");
        memberDao.getInactiveMembers().forEach(System.out::println);
        System.out.println();

        //Test av getByLastName
        System.out.println("Test av getByLastName: (borde skriva ut Helena & Tobias) ");
        memberDao.getByLastName("Halldin").forEach(System.out::println);
        System.out.println();

        //Test
        System.out.println("Test av getByRegistrationDateInterval: (borde skriva ut de som registrerat sig mellan 2000 och 2015)");
        memberDao.getByRegistrationDateInterval(Date.valueOf("2000-01-01"), Date.valueOf("2015-12-31")).forEach(System.out::println);
        System.out.println();

    }
}
