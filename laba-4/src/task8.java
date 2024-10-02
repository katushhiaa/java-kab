/* Маючи список продуктів (з полями name і price), напишіть метод, який
знаходить другий найдорожчий продукт і повертає його назву, загорнуту в
Optional.
*/

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Product{
    private String productName;
    private double productPrice;
    public Product(String productName, double productPrice){
        this.productName = productName;
        this.productPrice = productPrice;
    }
    public String getProductName(){
        return productName;
    }
    public double getProductPrice(){
        return productPrice;
    }

}

public class task8 {

    public static void main(String[] args) {
        List products = List.of(
                new Product("Яблуко", 12.5),
                new Product("Банан", 8.00),
                new Product("Вишня", 50.5),
                new Product("Персик", 25.75),
                new Product("Груша", 60.15)
        );
        Optional<String> secondMostExpensiveProduct = findSecondMostExpensiveProduct(products);
        secondMostExpensiveProduct.ifPresent(System.out::println);
    }

    public static Optional<String> findSecondMostExpensiveProduct(List<Product> products) {
        return products.stream()
                .distinct()
                .sorted(Comparator.comparingDouble(Product::getProductPrice).reversed())
                .skip(1)
                .findFirst()
                .map(Product::getProductName);
    }
}
