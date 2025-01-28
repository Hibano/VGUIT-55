input_file = 'vvod.txt'
output_file = 'vivod.txt'

def read(input_file):
    with open(input_file, 'r') as f:
        matrix = [list(map(int, line.split())) for line in f]
    return matrix

def write(output_file, matrix):
    with open(output_file, 'w') as f:
        for row in matrix:
            f.write(' '.join(map(str, row)) + '\n')

def procces(matrix):
    return list(map(list, zip(*matrix)))

matrix = read(input_file)
print('Исходная матрица:', matrix)

result = procces(matrix)
print('Результат обработки:', result)

write(output_file, result)
print(f'Результат сохранен в файл: {output_file}')