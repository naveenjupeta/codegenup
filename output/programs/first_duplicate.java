def first_duplicate(a):
    seen = set()
    for x in a:
        if x in seen:
            return x
        else:
            seen.add(x)