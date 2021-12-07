package org.example;

import java.util.Optional;

public class App {
    public static void main( String[] args ) {
        MemberDao memberDao = new MemberDaoImpl();

        memberDao.create(new Member("Helena", "Halldin", true));
        memberDao.create(new Member("Stina","Karlsson", false));
        memberDao.create(new Member("Muhamad","Ali", true));
        memberDao.create(new Member("Tobias","Eklund", true));
        memberDao.create(new Member("Sara","Olsson", false));
        memberDao.create(new Member("Amanda","White", false));

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

    }
}
