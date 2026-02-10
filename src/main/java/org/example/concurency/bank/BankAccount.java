package org.example.concurency.bank;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {
    private AtomicInteger balance;
    private UUID id;

    public BankAccount(Integer balance) {
        this.balance = new AtomicInteger(balance);
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public AtomicInteger deposit(){
        return balance;
    }
    public void withdraw(Integer amount){
        if (balance.addAndGet(amount) < 0 ){
            System.out.println("It's not enough money");
        } else {
            balance.addAndGet(amount);
            System.out.println("Your balance is now "+balance.get());
        }
    }
    public AtomicInteger getBalance(){
        return balance;
    }
}
