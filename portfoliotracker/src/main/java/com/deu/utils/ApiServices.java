/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deu.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author melihaltin
 */
public class ApiServices {
    private static final String API_URL = "https://api.blockchain.com/v3/exchange/tickers/";
    private static final String USER_AGENT = "Mozilla/5.0";

    public ApiServices() {
        // Constructor body
    }

    public String getData(String coin) {
        String price24h = "";

        try {
            // Create a URL object with the API endpoint
            URL url = new URL(API_URL + coin + "-USD");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Set any headers if required
            connection.setRequestProperty("User-Agent", USER_AGENT);

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();

                JSONObject jsonResponse = new JSONObject(response.toString());

                // Extract data from the JSON object
                String symbol = jsonResponse.getString("symbol");
                price24h = jsonResponse.getString("price_24h");
                double volume24h = jsonResponse.getDouble("volume_24h");
                double lastTradePrice = jsonResponse.getDouble("last_trade_price");
            } else {
                System.out.println("HTTP GET request failed with response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return price24h;
    }
}