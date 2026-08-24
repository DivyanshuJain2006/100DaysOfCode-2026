a = list(map(int, input().split()))
b = list(map(int, input().split()))

if len(a) != len(b):
    print("NO")
else:
    ok = True

    for i in range(len(a)):
        if a[i] != b[i]:
            ok = False
            break

    if ok:
        print("YES")
    else:
        print("NO")