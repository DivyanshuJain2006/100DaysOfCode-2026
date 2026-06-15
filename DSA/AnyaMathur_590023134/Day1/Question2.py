#sum of array elements

def array_sum(arr):
    total = 0
    for i in range(len(arr)):
        total += arr[i]
    print(total)
    
arr = list(map(int, input("Enter array elements separated by space: ").split()))

array_sum(arr)