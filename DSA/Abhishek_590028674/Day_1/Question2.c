#include <stdio.h>

void arrSum(int arr[], int arrSize){
    int sum = 0;
    for(int i=0; i<arrSize; i++){
        sum += arr[i];
    }
    printf("%d", sum);
}

int main(){
    int exampleArr[] = {2 ,3 ,4 ,3};
    arrSum(exampleArr, sizeof(exampleArr)/sizeof(exampleArr[0]));
    return 0;
}