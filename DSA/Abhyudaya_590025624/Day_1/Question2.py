ar=[]
n=int(input("Enter the number of elements in the array: "))
print("Enter the elements in the array: ")
sum=0
for i in range(n):
    ar.append(int(input()))
    sum+=ar[i]
print( sum )
#Question 2 done 