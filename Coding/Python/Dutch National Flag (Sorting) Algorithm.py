'''
The Dutch national flag (DNF) problem is one of the most popular programming problems proposed by Edsger Dijkstra. The flag of the Netherlands consists of three colors: white, red, and blue. The task is to randomly arrange balls of white, red, and blue such that balls of the same color are placed together.
'''

def dutchflagalgo(arr):
    low = 0
    mid = 0
    high = len(arr) - 1
    while mid<=high:
        if arr[mid] == 0:   #Swap low with mid
            arr[low], arr[mid] = arr[mid], arr[low]
            low = low + 1
            mid = mid + 1
        elif arr[mid] == 1: #Increment the mid counter i.e. 1's
            mid = mid + 1
        else:   #Swap mid with high
            arr[mid], arr[high] = arr[high], arr[mid]
            high = high - 1
    return arr

     #low
arr = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
     #mid                              #high
print(dutchflagalgo(arr))