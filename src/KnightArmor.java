import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Клас KnightArmor представляє амуніцію лицаря, яка складається з різних елементів броні.
 * Він дозволяє додавати елементи амуніції, підраховувати загальну вартість, сортувати амуніцію за вагою,
 * а також знаходити елементи амуніції, що відповідають заданому діапазону цін.
 *
 * @author Vasiliev Taras
 */
public class KnightArmor {
    private String name;
    private List<ArmorPiece> armorPieces;

    /**
     * Конструктор класу, який ініціалізує список елементів амуніції та ім'я амуніції.
     *
     * @param name ім'я амуніції
     */
    public KnightArmor(String name) {
        armorPieces = new ArrayList<>();
        this.name = name;
    }

    /**
     * Метод для додавання елемента амуніції до списку.
     *
     * @param piece елемент амуніції (типу ArmorPiece), який додається
     */
    public void addArmorPiece(ArmorPiece piece) {
        armorPieces.add(piece);
    }

    /**
     * Геттер для отримання імені амуніції.
     *
     * @return ім'я амуніції
     */
    public String getName() {
        return name;
    }

    /**
     * Метод для обчислення загальної вартості всіх елементів амуніції в списку.
     *
     * @return загальна вартість амуніції
     */
    public double getTotalCost() {
        double totalCost = 0;
        for (ArmorPiece piece : armorPieces) {
            totalCost += piece.getPrice();
        }
        return totalCost;
    }

    /**
     * Метод для сортування елементів амуніції за вагою в порядку зростання.
     */
    public void sortByWeight() {
        Collections.sort(armorPieces, Comparator.comparingDouble(ArmorPiece::getWeight));
    }

    /**
     * Метод для пошуку елементів амуніції, ціна яких знаходиться в заданому діапазоні.
     *
     * @param minPrice мінімальна ціна
     * @param maxPrice максимальна ціна
     * @return список елементів амуніції, що підходять під вказаний діапазон цін
     */
    public List<ArmorPiece> findArmorByPriceRange(double minPrice, double maxPrice) {
        List<ArmorPiece> foundPieces = new ArrayList<>();
        for (ArmorPiece piece : armorPieces) {
            if (piece.getPrice() >= minPrice && piece.getPrice() <= maxPrice) {
                foundPieces.add(piece);
            }
        }
        return foundPieces;
    }

    /**
     * Метод для виведення інформації про всі елементи амуніції в списку.
     * Для кожного елемента виводиться його назва, ціна та вага.
     */
    public void printArmorPieces() {
        for (ArmorPiece piece : armorPieces) {
            System.out.println(piece.getName() + ": ціна - " + piece.getPrice() + ", вага - " + piece.getWeight());
        }
    }
}
