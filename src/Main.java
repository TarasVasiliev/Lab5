import java.util.List;

/**
 * Клас Main є головним класом програми, що відповідає за тестування роботи амуніції лицаря.
 * У ньому створюється екземпляр класу KnightArmor, до якого додаються різні елементи амуніції.
 * Після цього програма обчислює загальну вартість амуніції, сортує елементи за вагою,
 * та знаходить елементи амуніції, що відповідають заданому діапазону цін.
 *
 * @author Vasiliev Taras
 */
public class Main {
    /**
     * Основний метод, який тестує роботу програми та виводить результат.
     * Створюється амуніція лицаря, додаються елементи амуніції, рахується вартість,
     * сортується за вагою та шукаються елементи амуніції в заданому діапазоні цін.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        // Обчислення залишку від ділення 2213 на 13
        int c13 = 2203 % 13;
        System.out.println("Завдання за варіантом 2213 mod 13 = " + c13 + ": Визначити ієрархію амуніції лицаря. Екіпірувати лицаря. \n " +
                "Порахувати вартість амуніції. Провести сортування амуніції за вагою. \n" +
                "Знайти елементи амуніції, що відповідають заданому діапазону цін.\n");

        // Створення екземпляра KnightArmor
        KnightArmor knightArmor = new KnightArmor("Амуніція лицаря");

        // Додаємо елементи амуніції
        knightArmor.addArmorPiece(new Helmet(200, 150));
        knightArmor.addArmorPiece(new Chestplate(500, 500));
        knightArmor.addArmorPiece(new Gauntlets(100, 75));
        knightArmor.addArmorPiece(new Boots(150, 100));

        // Виведення вартості амуніції
        System.out.println("\nВартість амуніції '" + knightArmor.getName() + "': " + knightArmor.getTotalCost());

        // Сортування амуніції за вагою
        knightArmor.sortByWeight();
        System.out.println("Відсортована амуніція за вагою:");
        knightArmor.printArmorPieces();

        // Пошук елементів амуніції за діапазоном цін
        double minPrice = 100;
        double maxPrice = 300;
        List<ArmorPiece> armorInPriceRange = knightArmor.findArmorByPriceRange(minPrice, maxPrice);

        if (armorInPriceRange.isEmpty()) {
            System.out.println("\nЕлементів амуніції за ціною в діапазоні (" + minPrice + ", " + maxPrice + ") не знайдено.");
        } else {
            System.out.println("\nЗнайдені елементи амуніції в діапазоні цін (" + minPrice + ", " + maxPrice + "):");
            for (ArmorPiece piece : armorInPriceRange) {
                System.out.println(piece.getName() + ": ціна - " + piece.getPrice() + ", вага - " + piece.getWeight());
            }
        }
    }
}
