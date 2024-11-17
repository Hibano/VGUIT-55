def odd_print():
    def helper(index = 1):
        num = int(input())
        if num == 0:
            return
        if index % 2 == 1:
            print(num)
        helper(index + 1)

    helper()

odd_print()