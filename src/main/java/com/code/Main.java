package com.code;

import com.code.tasks.threads.bank.BankAccount;
import com.code.tasks.threads.bank.ConcurrentBank;

import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ConcurrentBank bank = new ConcurrentBank();

        // Создание счетов
        BankAccount account1 = bank.createAccount(new BigDecimal("1000"));
        BankAccount account2 = bank.createAccount(new BigDecimal("500"));

        // Перевод между счетами
        Thread transferThread1 = new Thread(() -> bank.transfer(account1, account2, new BigDecimal("200")));
        Thread transferThread2 = new Thread(() -> bank.transfer(account2, account1, new BigDecimal("100")));

        transferThread1.start();
        transferThread2.start();

        try {
            transferThread1.join();
            transferThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Вывод общего баланса
        System.out.println("Total balance: " + bank.getTotalBalance());
        // Вывод общего баланса
        System.out.println("Total 1balance: " + account1.getBalance());
        // Вывод общего баланса
        System.out.println("Total 2balance: " + account2.getBalance());
    }
}