#include <stdio.h>

int main(){
int n;
printf("Enter the size of array: ");
scanf("%d",&n);
int arr[n];
printf("Enter array elements: ");
for(int i=0;i<n;i++){
  scanf("%d",&arr[i]);
}
int sum=0;
for(int i=0;i<n;i++){
    sum=sum+arr[i];
}
printf("The sum of array elements: %d",sum);
return 0;
}
