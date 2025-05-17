def reverse(n):
    if n < 10:
        return str(n)

    return str(n % 10) + reverse(n // 10)

number = int(input('Введите число:'))
print('Число в обратном порядке:', reverse(number))