package com.switchfully.parkshark.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "parking_lot")
public class ParkingLot {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parking_lot_seq")
    @SequenceGenerator(name = "parking_lot_seq", sequenceName = "parking_lot_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private ParkingCategory category;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "price_per_hour")
    private double pricePerHour;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;


    @ManyToOne
    @JoinColumn(name = "contact_person_id")
    private Contact contact;

    @ManyToOne
    @JoinColumn(name="division_id")
    private Division division;

    public ParkingLot() {
    }

    public Long getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ParkingCategory getCategory() {
        return category;
    }

    public void setCategory(ParkingCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactEmail() {
        return contact.getEmail();
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Address getContactAddress() {
        return contact.getAddress();
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public void allocateOne() {
        this.capacity--;
    }

    public void deallocateOne() {
        this.capacity++;
    }
}
