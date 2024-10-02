/*Маючи список транзакцій (з полями сума та категорія), напишіть лямбдафункцію,
 яка фільтрує транзакції за категоріями, підсумовує їхні суми та
складає в Map.*/

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class Transaction {
    private double amount;
    private String category;

    public Transaction(double amount, String category) {
        this.amount = amount;
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }
}

public class task7 {
    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
                new Transaction(100.0, "Їжа"),
                new Transaction(50.0, "Транспорт"),
                new Transaction(200.0, "Їжа"),
                new Transaction(150.0, "Транспорт"),
                new Transaction(80.0, "Розваги")
        );

        Map<String, Double> summary = transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getCategory,  // Групуємо за категорією
                        Collectors.summingDouble(Transaction::getAmount)
                ));

        summary.forEach((category, total) ->
                System.out.println("Категорія: " + category + ", Загальні витрати: " + total));
    }
}
