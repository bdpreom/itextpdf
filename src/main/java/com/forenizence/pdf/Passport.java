package com.forenizence.pdf;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;


@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String passportNumber;

    @Column(nullable = false)
    private String nationality;

    @Column(nullable = false)
    private String expiryDate;

    // Default constructor is required by JPA
    protected Passport() {}

    public Passport(String passportNumber, String nationality, String expiryDate) {
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.expiryDate = expiryDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return String.format("Passport[id=%d, passportNumber='%s', nationality='%s', expiryDate='%s']",
                id, passportNumber, nationality, expiryDate);
    }

}
