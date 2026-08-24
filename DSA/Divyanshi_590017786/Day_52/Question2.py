def register_usernames(usernames):
    users = {}

    for name in usernames:
        if name not in users:
            print("OK")
            users[name] = 1
        else:
            new_name = name + str(users[name])
            while new_name in users:
                users[name] += 1
                new_name = name + str(users[name])

            print(new_name)
            users[new_name] = 1
            users[name] += 1


# Input
n = int(input("Enter number of username requests: "))

usernames = []
for _ in range(n):
    usernames.append(input())

# Process requests
register_usernames(usernames)