package КІ300.Павлюк.Lab2;


/**
 * Клас Speaker представляє динамік, який дозволяє управляти рівнем гучності.
 */
public class Speaker {
    private int volume;

    /**
     * Конструктор за замовчуванням, який ініціалізує гучність на рівні 50.
     */
    public Speaker() {
        this.volume = 50;
    }

    /**
     * Конструктор, який ініціалізує гучність з заданим значенням.
     * Гучність обмежується діапазоном від 0 до 100.
     * @param volume початковий рівень гучності
     */
    public Speaker(int volume) {
        this.volume = Math.max(0, Math.min(100, volume));
    }

    /**
     * Змінює рівень гучності.
     * @param delta зміна гучності, яка буде додана до поточного рівня
     */
    public void changeVolume(int delta) {
        this.volume = Math.max(0, Math.min(100, this.volume + delta));
    }

    /**
     * Повертає поточний рівень гучності.
     * @return рівень гучності
     */
    public int getVolume() {
        return volume;
    }
}


