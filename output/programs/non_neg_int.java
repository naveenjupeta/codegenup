def find_int(arr):
    arr_set = set(arr)
    for i in range(max(arr) + 1):
        if i not in arr_set:
            return i