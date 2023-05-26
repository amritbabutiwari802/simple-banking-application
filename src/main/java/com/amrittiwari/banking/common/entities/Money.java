package com.amrittiwari.banking.common.entities;

public class Money {
    private long amountInRupees;
    private long amountInPaisa;

    private Money() {
    }

    public Money(long amountInRupees, long amountInPaisa) {
        this.amountInRupees = amountInRupees;
        this.amountInPaisa = amountInPaisa;
    }

    public void setAmountInRupees(long amountInRupees) {
        this.amountInRupees = amountInRupees;
    }

    public void setAmountInPaisa(long amountInPaisa) {
        this.amountInPaisa = amountInPaisa;
    }

    public long getAmountInRupees() {
        return amountInRupees;
    }

    public long getAmountInPaisa() {
        return amountInPaisa;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amountInRupees=" + amountInRupees +
                ", amountInPaisa=" + amountInPaisa +
                '}';
    }

    public static class Builder {
        private final Money money;

        public Builder() {
            money = new Money();
        }

        public Builder withAmountInRupees(long amountInRupees) {
            money.amountInRupees = amountInRupees;
            return this;
        }

        public Builder withAmountInPaisa(long amountInPaisa) {
            money.amountInPaisa = amountInPaisa;
            return this;
        }

        public Money build() {
            return money;
        }
    }
}
