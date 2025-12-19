package КІ300.Павлюк.Lab2;

import java.io.IOException;

/**
 * Клас VoiceRecorder розширює AudioPlayer та реалізує інтерфейс AudioRecordable.
 */
public class VoiceRecorder extends AudioPlayer implements AudioRecordable {
    private boolean isRecording;
    private String currentRecording;

    /**
     * Конструктор за замовчуванням.
     * @throws IOException якщо виникає помилка при створенні логера
     */
    public VoiceRecorder() throws IOException {
        super();
        this.isRecording = false;
        this.currentRecording = null;
        logger.log("Диктофон створено.");
    }

    @Override
    public void play() throws IOException {
        if (!isPlaying && !playList.isEmpty() && battery.getCharge() > 0) {
            isPlaying = true;
            logger.log(String.format("Початок відтворення запису: %s", playList.get(currentTrackIndex).getTitle()));
            System.out.printf("Початок відтворення запису: %s\n", playList.get(currentTrackIndex).getTitle());
        } else {
            logger.log("Неможливо почати відтворення");
            System.out.println("Неможливо почати відтворення");
        }
    }

    @Override
    public void stop() throws IOException {
        if (isPlaying) {
            isPlaying = false;
            logger.log("Зупинка відтворення запису");
            System.out.println("Зупинка відтворення запису");
        } else {
            logger.log("Відтворення вже зупинено");
            System.out.println("Відтворення вже зупинено");
        }
    }

    @Override
    public void startRecording() throws IOException {
        if (!isRecording && battery.getCharge() > 0) {
            isRecording = true;
            currentRecording = "Новий запис " + System.currentTimeMillis();
            logger.log("Початок запису");
            System.out.println("Початок запису");
        } else {
            logger.log("Неможливо почати запис");
            System.out.println("Неможливо почати запис");
        }
    }

    @Override
    public void stopRecording() throws IOException {
        if (isRecording) {
            isRecording = false;
            logger.log("Зупинка запису");
            System.out.println("Зупинка запису");
        } else {
            logger.log("Запис вже зупинено");
            System.out.println("Запис вже зупинено");
        }
    }

    @Override
    public void saveRecording(String filename) throws IOException {
        if (currentRecording != null) {
            // Тут мав би бути код для збереження запису у файл
            addTrack(new Track(filename, "Voice Recording", 0));
            logger.log(String.format("Запис збережено як %s", filename));
            System.out.printf("Запис збережено як %s\n", filename);
            currentRecording = null;
        } else {
            logger.log("Немає поточного запису для збереження");
            System.out.println("Немає поточного запису для збереження");
        }
    }
}

