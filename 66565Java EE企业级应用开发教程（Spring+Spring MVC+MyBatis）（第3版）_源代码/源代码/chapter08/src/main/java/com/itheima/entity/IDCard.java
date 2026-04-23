package com.itheima.entity;

public class IDCard {
    private int cardId;
    private String cardNumber;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "IDCard{" +
                "cardId=" + cardId +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}