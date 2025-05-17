from random import randint

n, m = 5, 5
a = [[randint(10, 20) for _ in range(m)] for _ in range(n)]
print('Сортировка по возрастанию:')
for i in a:
    print(sorted(i))