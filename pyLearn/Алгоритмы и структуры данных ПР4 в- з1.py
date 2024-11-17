input_file = 'Патока_Михаил_Александрович_ЗИТ-241_vvod.txt'
output_file = 'Патока_Михаил_Александрович_ЗИТ-241_vivod.txt'

def read_matrix(input_file):
    with open(input_file, 'r') as f:
        matrix = [list(map(int, line.split())) for line in f]
    return matrix

def write_matrix(output_file, matrix):
    with open(output_file, 'w') as f:
        for row in matrix:
            f.write(' '.join(map(str, row)) + '\n')

def procces_matrix(matrix):
    return list(map(list, zip(*matrix)))

matrix = read_matrix(input_file)
print('Исходная матрица:', matrix)

result_matrix = procces_matrix(matrix)
print('Результат обработки:', result_matrix)

write_matrix(output_file, result_matrix)
print(f'Результат сохранен в файл: {output_file}')