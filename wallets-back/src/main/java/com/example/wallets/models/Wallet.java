package com.example.wallets.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Wallet {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String currency_name;
    private double currency_amount;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Wallet(String currency_name, double currency_amount, User user) {
        this.currency_name = currency_name;
        this.currency_amount = currency_amount;
        this.user = user;
    }

    public Wallet() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCurrency_name() {
        return currency_name;
    }

    public void setCurrency_name(String currency_name) {
        this.currency_name = currency_name;
    }

    public double getCurrency_amount() {
        return currency_amount;
    }

    public void setCurrency_amount(double currency_amount) {
        this.currency_amount = currency_amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
