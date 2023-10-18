package com.dsp.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.dsp.streams.Transactions.*;
public class TransactionStreamPractice {

    public static void main(String[] args) {

        List<Transaction> transactionsIn2011 = transactions.stream()
                .filter(transaction -> transaction.getYear()==2011)
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                .collect(Collectors.toList());

        display(transactionsIn2011);

        List<String> distinctCities = traders.stream()
                .map(trader -> trader.getCity())
                .distinct().collect(Collectors.toList());

        display(distinctCities);

        List<Trader> tradersFromCambridge = traders.stream()
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        display(tradersFromCambridge);

        List<String> allTraders = traders.stream()
                .sorted(Comparator.comparing(Trader::getName))
                .map(Trader::getName)
                .collect(Collectors.toList());

        display(allTraders);

        System.out.println(traders.stream().filter(trader -> trader.getCity().equals("Milan")).findAny().get());

        List<Transaction> transactionsFromCambridgeTraders = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .collect(Collectors.toList());

        display(transactionsFromCambridgeTraders);

        System.out.println(transactions.stream().max(Comparator.comparing(Transaction::getValue)));

        System.out.println(transactions.stream().min(Comparator.comparing(Transaction::getValue)));
    }
}
