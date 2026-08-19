root = [4, 2, 5, 1, 3]
target = 3

closest = root[0]

for value in root:
    if abs(value - target) < abs(closest - target):
        closest = value
    elif abs(value - target) == abs(closest - target):
        closest = min(closest, value)

print(closest)