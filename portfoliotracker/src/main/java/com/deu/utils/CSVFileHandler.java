/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deu.utils;

/**
 *
 * @author melihaltin
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVFileHandler {

    public static void removeCurrencyFromCSV(String filePath, String currencyToRemove) throws IOException {
        // Geçici dosya oluşturuyoruz
        File tempFile = new File("temp.csv");

        // Orijinal dosyayı okumak için BufferedReader oluşturuyoruz
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        // Geçici dosyaya yazmak için BufferedWriter oluşturuyoruz
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            String currency = fields[0]; // currency sütununun indeksi 0 olduğunu varsayıyoruz
            if (!currency.equals(currencyToRemove)) {
                writer.write(line);
                writer.newLine();
            }
        }

        // Dosyaları kapatıyoruz
        reader.close();
        writer.close();

        // Orijinal dosyayı siliyoruz
        new File(filePath).delete();

        // Geçici dosyayı orijinal dosya adıyla yeniden adlandırıyoruz
        tempFile.renameTo(new File(filePath));
    }
}