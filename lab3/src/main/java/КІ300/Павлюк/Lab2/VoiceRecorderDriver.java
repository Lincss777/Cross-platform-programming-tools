package КІ300.Павлюк.Lab2;

import java.io.IOException;

/**
 * Клас AudioPlayerDriver є точкою входу в програму.
 * Він демонструє основні операції з аудіоплеєром шляхом виклику різних методів.
 */
public class VoiceRecorderDriver {
    /**
     * Точка входу в програму. Демонструє роботу з телевізором шляхом виклику різних методів.
     *
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        try {
            VoiceRecorder voiceRecorder = new VoiceRecorder();

            // Демонстрація запису
            voiceRecorder.startRecording();
            Thread.sleep(2000); // Імітація запису протягом 2 секунд
            voiceRecorder.stopRecording();
            voiceRecorder.saveRecording("Запис_1.mp3");

            // Демонстрація відтворення
            voiceRecorder.play();
            Thread.sleep(1000); // Імітація відтворення протягом 1 секунди
            voiceRecorder.stop();

            // Демонстрація інших функцій
            voiceRecorder.addTrack(new Track("Аудіонотатка", "Користувач", 120));
            voiceRecorder.changeVolume(10);
            voiceRecorder.chargeBattery(50);

            // Ще один цикл запису
            voiceRecorder.startRecording();
            Thread.sleep(3000); // Імітація запису протягом 3 секунд
            voiceRecorder.stopRecording();
            voiceRecorder.saveRecording("Запис_2.mp3");

            // Відтворення нового запису
            voiceRecorder.nextTrack();
            voiceRecorder.play();
            Thread.sleep(1000); // Імітація відтворення протягом 1 секунди
            voiceRecorder.stop();

            voiceRecorder.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


