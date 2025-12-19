from dictaphone import Dictaphone

if __name__ == "__main__":
    device = Dictaphone("Sony", 10, 32, -42)

    print(device.get_dictaphone_info())
    device.play_music("Relaxing Sounds.mp3")
    device.record()
