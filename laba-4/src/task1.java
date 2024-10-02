import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*У списку рядків знайти перший рядок, який починається з «X» і містить
більше 5 символів. Якщо такого рядка не існує, поверніть Optional, що
містить "Default".*/
public class task1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Zxcvbnm", "Xwertyy", "Xswe");
        Optional<String> res = list.stream()
                .filter(str -> str.startsWith("X") && str.length() > 5)
                .findFirst()
                .or(() -> Optional.of("Default"));
        System.out.println(res.get());
    }
}
