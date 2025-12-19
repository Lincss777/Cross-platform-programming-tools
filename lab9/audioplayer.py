class AudioPlayer:
    def __init__(self, brand, battery_life, storage_capacity):
        self._brand = brand
        self._battery_life = battery_life  # у годинах
        self._storage_capacity = storage_capacity  # у ГБ

    def play_music(self, track):
        print(f"Програється трек: {track}")

    def get_info(self):
        return f"Аудіоплеєр {self._brand}: акумулятор {self._battery_life} год., памʼять {self._storage_capacity} ГБ"
