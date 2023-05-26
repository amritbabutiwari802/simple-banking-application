package com.amrittiwari.banking.balance.utils;

import com.amrittiwari.banking.common.entities.Money;

public class BalanceUtil {
    public static Money addMoney(Money amount, Money addend){
        long totalPaisa =  amount.getAmountInPaisa() + addend.getAmountInPaisa();
        long carryOver_rupee = totalPaisa/100;
        long remainder_paisa = totalPaisa%100;
        long totalRupees = amount.getAmountInRupees() + amount.getAmountInRupees() + carryOver_rupee;
        Money sum = new Money.Builder().withAmountInRupees(totalRupees).withAmountInPaisa(remainder_paisa).build();
        return sum;

    }

    public static Money substractMoney(Money amount, Money substractend) throws SubstractException{
        long totalPaisa_amount = amount.getAmountInRupees()*100 + amount.getAmountInPaisa();
        long totalPaisa_substactend = substractend.getAmountInRupees()*100 + substractend.getAmountInPaisa();
        if(totalPaisa_substactend>totalPaisa_amount){
            throw new SubstractException();
        }
        long result = totalPaisa_amount - totalPaisa_substactend;
        long resultInRupee = result/100;
        long remainderPaisa = result%100;
        Money finalAmount = new Money.Builder()
                .withAmountInRupees(resultInRupee)
                .withAmountInPaisa(remainderPaisa)
                .build();
        return finalAmount;
    }

}
