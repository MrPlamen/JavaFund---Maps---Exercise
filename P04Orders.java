package MapsExcercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04Orders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Double> namePrice = new LinkedHashMap<>();
        HashMap<String, Integer> nameQuantity = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!input.equals("buy")) {
            String[] inputLine = input.split(" ");
            String name = inputLine[0];
            double price = Double.parseDouble(inputLine[1]);
            int quantity = Integer.parseInt(inputLine[2]);
            if (!nameQuantity.containsKey(name)) {
                nameQuantity.put(name, quantity);
                namePrice.put(name, price);
            } else {
                nameQuantity.put(name, nameQuantity.get(name) + quantity);
                if (namePrice.get(name) != price) {
                    namePrice.put(name, price);
                }
            }
            input = sc.nextLine();
        }
        for (Map.Entry<String, Double> entry : namePrice.entrySet()) {
            double quantity = nameQuantity.get(entry.getKey());
            namePrice.put(entry.getKey(), quantity*entry.getValue());
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue());
        }
    }
}
