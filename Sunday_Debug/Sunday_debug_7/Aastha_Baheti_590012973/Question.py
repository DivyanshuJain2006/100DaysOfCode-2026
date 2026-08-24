def merge(arr, left, mid, right):
    left_part = arr[left:mid + 1]
    right_part = arr[mid + 1:right + 1]

    i = j = 0
    k = left

    def merge_rec(i, j, k):
        if i == len(left_part):
            copy_right(j, k)
            return
        if j == len(right_part):
            copy_left(i, k)
            return

        if left_part[i] <= right_part[j]:
            arr[k] = left_part[i]
            merge_rec(i + 1, j, k + 1)
        else:
            arr[k] = right_part[j]
            merge_rec(i, j + 1, k + 1)

    def copy_left(i, k):
        if i == len(left_part):
            return
        arr[k] = left_part[i]
        copy_left(i + 1, k + 1)

    def copy_right(j, k):
        if j == len(right_part):
            return
        arr[k] = right_part[j]
        copy_right(j + 1, k + 1)

    merge_rec(i, j, k)


def merge_sort(arr, left, right):
    if left < right:
        mid = (left + right) // 2
        merge_sort(arr, left, mid)
        merge_sort(arr, mid + 1, right)
        merge(arr, left, mid, right)


def binary_search(arr, target, low, high):
    if low > high:
        return -1

    mid = (low + high) // 2

    if arr[mid] == target:
        return mid
    elif arr[mid] < target:
        return binary_search(arr, target, mid + 1, high)
    else:
        return binary_search(arr, target, low, mid - 1)


# Driver Code
incidents = [34, 7, 23, 32, 5, 62, 15]

merge_sort(incidents, 0, len(incidents) - 1)
print("Sorted Reports:", incidents)

print("Record Found At:", binary_search(incidents, 23, 0, len(incidents) - 1))