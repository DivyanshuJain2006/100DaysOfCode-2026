def find_anagrams(log, pattern):
    result = []

    if len(pattern) > len(log):
        return result

    p_count = {}
    w_count = {}

    # Frequency of pattern
    for ch in pattern:
        p_count[ch] = p_count.get(ch, 0) + 1

    # First window
    for i in range(len(pattern)):
        ch = log[i]
        w_count[ch] = w_count.get(ch, 0) + 1

    if w_count == p_count:
        result.append(0)

    # Slide the window
    for i in range(len(pattern), len(log)):
        left_char = log[i - len(pattern)]
        w_count[left_char] -= 1
        if w_count[left_char] == 0:
            del w_count[left_char]

        right_char = log[i]
        w_count[right_char] = w_count.get(right_char, 0) + 1

        if w_count == p_count:
            result.append(i - len(pattern) + 1)

    return result


# Input
log = input("Enter log string: ")
pattern = input("Enter pattern: ")

# Output
print("Starting Indices:", find_anagrams(log, pattern))
