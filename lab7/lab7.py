def create_inner_border_matrix(n, filler):
    matrix = []
    for i in range(n):
        row = []
        for j in range(n):
            # умова для ВНУТРІШНЬОЇ рамки
            if 1 <= i <= n - 2 and 1 <= j <= n - 2:
                if i == 1 or i == n - 2 or j == 1 or j == n - 2:
                    row.append(filler)
                else:
                    row.append(" ")
            else:
                row.append(" ")
        matrix.append(row)
    return matrix

def print_matrix(matrix):
    for row in matrix:
        print(" ".join(row))

def main():
    try:
        n = int(input("Введіть розмір квадратної матриці (n ≥ 3): "))
        if n < 3:
            raise ValueError("Матриця повинна мати розмір не менше 3x3")

        filler = input("Введіть символ-заповнювач: ")

        if len(filler) != 1:
            raise ValueError("Потрібен лише один символ-заповнювач!")

        matrix = create_inner_border_matrix(n, filler)
        print("\nМатриця з внутрішньою рамкою:")
        print_matrix(matrix)

    except ValueError as ve:
        print("Помилка:", ve)

if __name__ == "__main__":
    main()
