import math
import os
import struct
import sys

def calculate(x):
    denominator = math.tan(2 * x - 4)
    if abs(denominator) < 1e-10:
        raise ZeroDivisionError("Ділення на нуль: tan(2x - 4) ≈ 0")
    return (7 * x) / denominator

def write_result_text(filename, result):
    with open(filename, 'w', encoding='utf-8') as f:
        f.write(str(result))

def read_result_text(filename):
    try:
        with open(filename, 'r', encoding='utf-8') as f:
            return float(f.read())
    except Exception as e:
        print("Помилка читання з текстового файлу:", e)
        return None

def write_result_bin(filename, result):
    with open(filename, 'wb') as f:
        f.write(struct.pack('d', result))

def read_result_bin(filename):
    try:
        with open(filename, 'rb') as f:
            return struct.unpack('d', f.read())[0]
    except Exception as e:
        print("Помилка читання з бінарного файлу:", e)
        return None

if __name__ == "__main__":
    try:
        x = float(input("Введіть значення x: "))
        y = calculate(x)
        print(f"Результат: y = {y}")

        write_result_text("result.txt", y)
        write_result_bin("result.bin", y)

        print("Прочитано з текстового файлу:", read_result_text("result.txt"))
        print("Прочитано з бінарного файлу:", read_result_bin("result.bin"))

    except ValueError:
        print("Помилка: введено нечислове значення.")
    except ZeroDivisionError as e:
        print("Помилка обчислення:", e)
    except Exception as err:
        print("Невідома помилка:", repr(err))
        sys.exit(1)
