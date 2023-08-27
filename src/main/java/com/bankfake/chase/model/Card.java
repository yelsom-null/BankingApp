package com.bankfake.chase.model;


import jakarta.persistence.*;

import java.util.Random;
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customers customers;
    protected long cardNumber = generateRandomCardNumber();
    protected int cvvNumber = generateRandomCVVNumber();
    protected String expirationDate = "07/27";

    public Card() {
    }


    public long generateRandomCardNumber() {
        Random random = new Random();
        return random.nextInt(1_000_000_000 + random.nextInt(900_000_000));
    }

    public int generateRandomCVVNumber() {
        Random random = new Random();
        return  random.nextInt(1_000 + random.nextInt(90));
    }

    @Override
    public String toString() {
        return "CardNumber:" + cardNumber + "\n" +
                "CVV: " + cvvNumber + "\n" +
                "Expiration Date: " + expirationDate;
    }
}
