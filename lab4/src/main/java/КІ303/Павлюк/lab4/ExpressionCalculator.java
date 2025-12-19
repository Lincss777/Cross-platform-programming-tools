package КІ303.Павлюк.lab4;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Клас для обчислення виразу y = 7x/tan(2x-4).
 * Використовується для демонстрації механізму виключень і запису результатів у файл.
 */
public class ExpressionCalculator {

    /**
     * Обчислює вираз y = 7x/tan(2x-4).
     *
     * @param x значення змінної x
     * @return результат обчислення виразу
     * @throws IllegalArgumentException якщо x = 0, оскільки вираз не визначений
     */
    public double calculate(double x) throws IllegalArgumentException {
        if (x == 0) {
            throw new IllegalArgumentException("Значення x не може бути 0, оскільки вираз не визначений.");
        }

        return (7 * x) / Math.tan(2 * x - 4);

    }

    /**
     * Записує результат обчислення у файл.
     *
     * @param result результат обчислення
     * @param filePath шлях до файлу
     * @throws IOException якщо виникає помилка при записі у файл
     */
    public void writeResultToFile(double result, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Результат обчислення: " + result);
        }
    }
}


