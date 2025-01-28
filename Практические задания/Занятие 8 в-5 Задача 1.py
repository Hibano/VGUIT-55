A = (int(input('Введите значение A:')))
B = (int(input('Введите значение B:')))
C = (int(input('Введите значение C:')))
D = (int(input('Введите значение D:')))

chisl = A * D + B * C
znam = B * D

a, b = chisl, znam

while a != b:
    if a > b:
        a -= b
    else:
        b -= a

print(f'Результат вычисления: {chisl // a}/{znam // a} ')