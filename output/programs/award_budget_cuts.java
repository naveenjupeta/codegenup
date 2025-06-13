
Here is a Python implementation of the binary search algorithm:

```python
def find_grant_cap(grantsArray, newBudget):
    grantsArray = sorted(grantsArray, reverse=True)
    low = 0
    high = newBudget / len(grantsArray)
    while low < high:
        mid = (low + high) / 2
        remaining_budget = newBudget
        for grant in grantsArray: