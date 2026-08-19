def merge(arr, left, mid, right):
    left_part = arr[left:mid + 1]
    right_part = arr[mid + 1:right + 1]

    i = j = 0
    k = left

    for _ in range(len(left_part) + len(right_part)):
        if i >= len(left_part) or j >= len(right_part):
            break

        if left_part[i] <= right_part[j]:
            arr[k] = left_part[i]
            i += 1
        else:
            arr[k] = right_part[j]
            j += 1
        k += 1

    for x in range(i, len(left_part)):
        arr[k] = left_part[x]
        k += 1

    for x in range(j, len(right_part)):
        arr[k] = right_part[x]
        k += 1


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


incidents = [34, 7, 23, 32, 5, 62, 15]

merge_sort(incidents, 0, len(incidents) - 1)

print("Sorted Reports:", incidents)
print("Record Found At:", binary_search(incidents, 23, 0, len(incidents) - 1))