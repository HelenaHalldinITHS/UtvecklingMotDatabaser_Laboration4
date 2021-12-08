package org.example;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private boolean active;
    @Basic
    private java.sql.Date registrationDate;

    @Enumerated(EnumType.ORDINAL)
    private MembershipType membershipType;

    public Member(){}

    public Member(String firstName, String lastName, boolean active, Date registrationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
        this.registrationDate = registrationDate;
    }

    public Member(String firstName, String lastName, boolean active, Date registrationDate, MembershipType membershipType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
        this.registrationDate = registrationDate;
        this.membershipType = membershipType;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", active=" + active +
                ", registrationDate=" + registrationDate +
                ", membershipType=" + membershipType +
                '}';
    }
}
