'''
Two pointers is really an easy and effective technique that is typically used for searching pairs in a sorted array.
Given a sorted array A (sorted in ascending order), having N integers, find if there exists any pair of elements (A[i], A[j]) such that their sum is equal to X.

The algorithm basically uses the fact that the input array is sorted. We start the sum of extreme values (smallest and largest) and conditionally move both pointers. We move left pointer ‘i’ when the sum of A[i] and A[j] is less than X. We do not miss any pair because the sum is already smaller than X. Same logic applies for right pointer j.
'''

'''
Time Complexity: O(n)
Algo's Objective: Find pairs in an array with a sum equal to k
'''


def twopointeralgo(arr, k):
    i = 0              #represents first pointer
    j = len(arr) - 1   #represents second pointer
 
    while i<j:
        if (arr[i] + arr[j] == k):   #If we find a pair
            return 1
        elif(arr[i] + arr[j] < k):
            i = i + 1
        else:
            j -= 1
    return 0
 
arr = [3, 5, 9, 2, 8, 10, 11]
k = 17
print(twopointeralgo(arr, k))


'''
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Input: nums = []
Output: []

Input: nums = [0]
Output: []

Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105

'''

def twopointeralgo(arr, k, i):             #represents first pointer
    j = len(arr) - 1   #represents second pointer
 
    while i<j:
        if (arr[i] + arr[j] == k):   #If we find a pair
            return 1
        elif(arr[i] + arr[j] < k):
            i = i + 1
        else:
            j -= 1
    return 0

def triplets(arr):
    n = len(arr)
    arr.sort()

    for i in range(n-2):
        if(twopointeralgo(arr[i], -arr[i], i+1)):
            return True
    return False

arr = [3, 5, 9, 2, 8, 10, 11]
print(triplets(arr))