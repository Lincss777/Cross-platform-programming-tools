package КІ300.Павлюк.Lab2;

import java.io.IOException;

/**
 * The {@code AudioRecordable} interface represents devices that are capable of recording audio.
 * Implementing classes must provide methods to start, stop, and save the recording.
 */
interface AudioRecordable {

    /**
     * Starts recording audio.
     *
     * @throws IOException if an I/O error occurs while starting the recording.
     */
    void startRecording() throws IOException;

    /**
     * Stops recording audio.
     *
     * @throws IOException if an I/O error occurs while stopping the recording.
     */
    void stopRecording() throws IOException;

    /**
     * Saves the recorded audio to a file.
     *
     * @param filename the name of the file where the recording will be saved.
     * @throws IOException if an I/O error occurs while saving the recording.
     */
    void saveRecording(String filename) throws IOException;
}

