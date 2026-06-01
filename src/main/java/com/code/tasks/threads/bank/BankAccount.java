package com.code.tasks.threads.bank;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    public final long number;
    private BigDecimal money;
    public final Lock locker = new ReentrantLock();

    public BankAccount(long number, BigDecimal initialMoney) {
        this.number = number;
        this.money = initialMoney;
    }

    public void deposit(BigDecimal money) throws IllegalArgumentException {
        locker.lock();
        this.money = this.money.add(money);
        locker.unlock();
    }

    void restore(BigDecimal money) {
        locker.lock();
        this.money = money;
        locker.unlock();
    }

    public void withdraw(BigDecimal money) throws IllegalArgumentException {
        locker.lock();
        this.money = this.money.subtract(money);
        locker.unlock();
    }

    public BigDecimal getBalance() throws IllegalArgumentException {
        locker.lock();
        BigDecimal balance = money;
        locker.unlock();
        return balance;
    }
}
