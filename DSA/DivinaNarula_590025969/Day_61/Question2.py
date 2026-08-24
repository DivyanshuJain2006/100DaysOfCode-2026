# The Wizard Academy

def minimumGroups(n, mentor):
    depth = [0] * n

    def findDepth(student):
        if depth[student] != 0:
            return depth[student]

        if mentor[student] == -1:
            depth[student] = 1
        else:
            depth[student] = findDepth(mentor[student] - 1) + 1

        return depth[student]

    answer = 0

    for student in range(n):
        answer = max(answer, findDepth(student))

    return answer


n = int(input("Enter number of students: "))
mentor = list(map(int, input("Enter mentor array: ").split()))

print("Minimum number of groups:", minimumGroups(n, mentor))