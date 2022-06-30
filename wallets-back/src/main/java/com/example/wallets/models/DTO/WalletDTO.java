package com.example.wallets.models.DTO;

public class WalletDTO {

    private String currency_name;
    private double currency_amount;
    private long user_id;

    public WalletDTO(String currency_name, double currency_amount, long user_id) {
        this.currency_name = currency_name;
        this.currency_amount = currency_amount;
        this.user_id = user_id;
    }

    public WalletDTO() {
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

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}
