val = (int(input('Введите число:')))
print(f'Делители числа {val}:',[i for i in range(1, val + 1) if val % i == 0])