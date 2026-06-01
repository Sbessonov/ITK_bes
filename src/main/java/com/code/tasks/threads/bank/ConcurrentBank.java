package com.code.tasks.threads.bank;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ConcurrentBank {
    private final AtomicLong accountCounter = new AtomicLong(1);
    private final Map<Long, BankAccount> accounts = new ConcurrentHashMap<>();

    public BankAccount createAccount(BigDecimal initialValue) {
        BankAccount acc = new BankAccount(accountCounter.getAndIncrement(), initialValue);
        accounts.put(acc.number, acc);
        return acc;
    }

    public void transfer(BankAccount fromAccount, BankAccount toAccount, BigDecimal money) {

        fromAccount.locker.lock();
        toAccount.locker.lock();
        BigDecimal withdrawAccBalance = fromAccount.getBalance();
        BigDecimal depositAccBalance = toAccount.getBalance();

        try {
            fromAccount.withdraw(money);
            toAccount.deposit(money);
        } catch (Exception ex) {
            fromAccount.restore(withdrawAccBalance);
            toAccount.restore(depositAccBalance);
        } finally {
            toAccount.locker.unlock();
            fromAccount.locker.unlock();
        }
    }

    public BigDecimal getTotalBalance() {
        BigDecimal totalBalance = new BigDecimal("0");
        for (BankAccount acc : accounts.values()) {
            totalBalance = totalBalance.add(acc.getBalance());
        }

        return totalBalance;
    }
}
