/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deu.utils;

/**
 *
 * @author melihaltin
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.raven.model.Currency;
import com.deu.utils.ApiServices;

public class WalletReader {
    public static List<Currency> readCryptoWalletsFromCSV(String filePath) {
        List<Currency> wallet = new ArrayList<>();
         ApiServices apiService = new ApiServices();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String name = values[0];
                double amount = Double.parseDouble(values[1]);
                

                Currency currency = new Currency(name, amount ,Double.parseDouble(apiService.getData(name)));
                wallet.add(currency);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wallet;
    }

    public static void main(String[] args) {
        List<Currency> cryptoWallets = readCryptoWalletsFromCSV("/Users/melihaltin/Downloads/portfoliotracker/src/main/java/Wallet.csv");
        for (Currency cryptoWallet : cryptoWallets) {
            System.out.println(cryptoWallet.getName() + ": " + cryptoWallet.getTotalValue());
        }
    }
}