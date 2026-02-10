package org.example.concurency.bank;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentBank {
    private ConcurrentMap<UUID, BankAccount> map;
    private Integer amount;
    private final Object lock = new Object();

    public ConcurrentBank() {
        this.map = new ConcurrentHashMap<>();
    }

    public BankAccount createAccount(Integer amount) {
        BankAccount account = new BankAccount(amount);
        map.put(account.getId(), account);
        return account;
    }
    public void transfer (BankAccount from, BankAccount to, Integer amount) {//BigDecimal amount поменял на инт под тест
        if (from != null && to != null) {
            synchronized (lock) {
                map.get(from.getId()).withdraw(-amount);
                map.get(to.getId()).withdraw(amount);
            }
        }

    }

    public Integer getTotalBalance () {
        return map.values().stream()
                .map(x -> x.getBalance().get())
                .reduce( 0, Integer::sum);
    }
}
