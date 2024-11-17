
arr = [-1, -3, 4, 6, -9, -6, 2, -2, -2, 1]
#for _ in range (10):
#    arr.append(int(input('Введите числа в массив:')))

for i in range(9):
    if arr[i] < 0 and arr[i + 1] < 0:
        print('Пара:', arr[i], arr[i + 1])


