package КІ300.Павлюк.Lab2;

package група.прізвище.lab3;

/**
 * Клас Track представляє аудіотрек, включаючи інформацію про назву, виконавця та тривалість.
 */
public class Track {
    private String title;
    private String artist;
    private int duration;

    /**
     * Конструктор за замовчуванням, який ініціалізує трек з порожніми значеннями.
     */
    public Track(){
        this.title = "";
        this.artist = "";
        this.duration = 0;
    }

    /**
     * Конструктор, який ініціалізує трек з заданими значеннями.
     * @param title назва треку
     * @param artist виконавець треку
     * @param duration тривалість треку в секундах
     */
    public Track(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    /**
     * Повертає назву треку.
     * @return назва треку
     */
    public String getTitle() {
        return title;
    }

    /**
     * Повертає ім'я виконавця треку.
     * @return ім'я виконавця
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Повертає тривалість треку в секундах.
     * @return тривалість треку
     */
    public int getDuration() {
        return duration;
    }
}
