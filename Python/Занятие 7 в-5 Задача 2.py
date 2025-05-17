arr = [1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
arr_new = []


for num in arr:
    if num not in arr_new:
        arr_new.append(num)

print(arr_new)
