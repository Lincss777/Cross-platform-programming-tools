package КІ300.Павлюк.Lab2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Клас AudioPlayer представляє аудіоплеєр, який дозволяє управляти плейлистом треків,
 * відтворювати музику, змінювати гучність, заряджати батарею та багато іншого.
 */
public abstract class AudioPlayer {
    protected List<Track> playList;
    protected Battery battery;
    protected Speaker speaker;
    protected Logger logger;
    protected boolean isPlaying;
    protected int currentTrackIndex;

    /**
     * Конструктор за замовчуванням, який ініціалізує плейлист, батарею, динамік і логер.
     * @throws IOException якщо виникає помилка при створенні логера
     */
    public AudioPlayer() throws IOException {
        this.playList = new ArrayList<>();
        this.battery = new Battery();
        this.speaker = new Speaker();
        this.isPlaying = false;
        this.currentTrackIndex = 0;

        this.logger = new Logger("audio_player_log.txt");
        logger.log(String.format("Аудіоплеєр %s створено.", this.toString()));
    }

    /**
     * Конструктор, який ініціалізує плейлист, батарею та динамік з наданими параметрами.
     * @param playList список треків
     * @param battery батарея
     * @param speaker динамік
     * @throws IOException якщо виникає помилка при створенні логера
     */
    public AudioPlayer(List<Track> playList, Battery battery, Speaker speaker) throws IOException {
        this.playList = playList;
        this.battery = battery;
        this.speaker = speaker;
        this.isPlaying = false;
        this.currentTrackIndex = -1;

        this.logger = new Logger("audio_player_log.txt");
        logger.log(String.format("Аудіоплеєр %s створено.", this.toString()));
    }

    /**
     * Абстрактний метод для відтворення аудіо.
     * @throws IOException якщо виникає помилка при запису в лог
     */
    public abstract void play() throws IOException;

    /**
     * Абстрактний метод для зупинки відтворення.
     * @throws IOException якщо виникає помилка при запису в лог
     */
    public abstract void stop() throws IOException;

    /**
     * Додає трек до плейлиста.
     * @param track трек для додавання
     * @throws IOException якщо виникає помилка при запису в лог
     */
    public void addTrack(Track track) throws IOException {
        if(!playList.contains(track)) {
            playList.add(track);
        } else {
            logger.log(String.format("Трек %s вже додано до плейлісту", track.getTitle()));
            System.out.printf("Трек %s вже додано до плейлісту\n", track.getTitle());
        }

        logger.log(String.format("Додано трек %s до плейлісту", track.getTitle()));
        System.out.printf("Додано трек %s до плейлісту\n", track.getTitle());
    }

    /**
     * Видаляє трек з плейлиста за його назвою.
     * @param title назва треку для видалення
     * @throws IOException якщо виникає помилка при запису в лог
     */
    public void removeTrack(String title) throws IOException {
        boolean removed = playList.removeIf(track -> track.getTitle().equals(title));

        if (!removed) {
            logger.log(String.format("Трек %s не знайдено у плейлісті", title));
            System.out.printf("Трек %s не знайдено у плейлісті\n", title);
        } else {
            logger.log(String.format("Трек %s видалено з плейлісту", title));
            System.out.printf("Трек %s видалено з плейлісту\n", title);
        }
    }

    /**
     * Переходить до наступного треку в плейлисті.
     * @throws IOException якщо виникає помилка при запису в лог
     */
    public void nextTrack() throws IOException {
        if (!playList.isEmpty()) {
            currentTrackIndex = (currentTrackIndex + 1) % playList.size();

            logger.log(String.format("Перехід до наступного треку: %s", playList.get(currentTrackIndex).getTitle()));
            System.out.printf("Перехід до наступного треку: %s\n", playList.get(currentTrackIndex).getTitle());
        }
    }

    /**
     * Переходить до попереднього треку в плейлисті.
     * @throws IOException якщо виникає помилка при запису в лог
     */
    public void previousTrack() throws IOException {
        if (!playList.isEmpty()) {
            currentTrackIndex = (currentTrackIndex - 1 + playList.size()) % playList.size();

            logger.log(String.format("Перехід до попереднього треку: %s", playList.get(currentTrackIndex).getTitle()));
            System.out.printf("Перехід до попереднього треку: %s\n", playList.get(currentTrackIndex).getTitle());
        }
    }

    /**
     * Змінює гучність динаміка.
     * @param delta зміна гучності
     * @throws IOException якщо виникає помилка при запису в лог
     */
    public void changeVolume(int delta) throws IOException {
        speaker.changeVolume(delta);

        logger.log(String.format("Зміна гучності на %s", delta));
        System.out.printf("Зміна гучності на %s\n", delta);
    }

    /**
     * Заряджає батарею.
     * @param amount кількість заряду для додавання
     * @throws IOException якщо виникає помилка при запису в лог
     */
    public void chargeBattery(int amount) throws IOException {
        battery.charge(amount);

        logger.log(String.format("Заряджено батарею на %s", amount));
        System.out.printf("Заряджено батарею на %s\n", amount);
    }

    /**
     * Шукає трек у плейлисті за його назвою.
     * @param title назва треку для пошуку
     * @return індекс знайденого треку або -1, якщо трек не знайдено
     * @throws IOException якщо виникає помилка при запису в лог
     */
    public int findTrack(String title) throws IOException {
        for (int i = 0; i < playList.size(); i++) {
            if (playList.get(i).getTitle().equalsIgnoreCase(title)) {
                logger.log(String.format("Знайдено трек: %s", title));
                System.out.printf("Знайдено трек: %s\n", title);
                return i;
            }
        }
        logger.log(String.format("Трек не знайдено: %s", title));
        System.out.printf("Трек не знайдено: %s\n", title);
        return -1;
    }

    /**
     * Створює випадковий плейлист із заданою кількістю треків.
     * @param count кількість треків у новому плейлисті
     * @throws IOException якщо виникає помилка при запису в лог
     */
    public void createRandomPlaylist(int count) throws IOException {
        if (count <= 0 || count > playList.size()) {
            logger.log("Неможливо створити випадковий плейлист: некоректна кількість треків");
            System.out.println("Неможливо створити випадковий плейлист: некоректна кількість треків");
            return;
        }

        List<Track> newPlaylist = new ArrayList<>(playList);
        Collections.shuffle(newPlaylist);
        playList = new ArrayList<>(newPlaylist.subList(0, count));
        currentTrackIndex = 0;

        logger.log(String.format("Створено новий випадковий плейлист з %s треків", count));
        System.out.printf("Створено новий випадковий плейлист з %s треків\n", count);
    }

    /**
     * Закриває логер для збереження даних у файл.
     * @throws IOException якщо виникає помилка під час закриття логера
     */
    public void closeLogger() throws IOException {
        logger.close();
    }
}

