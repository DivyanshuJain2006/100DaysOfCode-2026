def minimum_groups(n, mentor):
    def get_depth(student):
        depth = 1

        while mentor[student] != -1:
            student = mentor[student] - 1
            depth += 1

        return depth

    answer = 0

    for i in range(n):
        answer = max(answer, get_depth(i))

    return answer


# Example
n = 5
mentor = [-1, 1, 2, 1, -1]

print(minimum_groups(n, mentor))