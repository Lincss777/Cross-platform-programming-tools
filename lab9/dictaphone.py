from audioplayer import AudioPlayer

class Dictaphone(AudioPlayer):
    def __init__(self, brand, battery_life, storage_capacity, mic_sensitivity):
        super().__init__(brand, battery_life, storage_capacity)
        self.__mic_sensitivity = mic_sensitivity  # в dB

    def record(self):
        print(f"Запис звуку... Чутливість мікрофона: {self.__mic_sensitivity} dB")

    def get_dictaphone_info(self):
        base_info = self.get_info()
        return f"{base_info}. Мікрофон: {self.__mic_sensitivity} dB"
