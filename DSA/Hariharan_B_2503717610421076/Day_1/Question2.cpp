#include<iostream>
using namespace std;

int main()
{
    int n, i, sum;
    cin>>n;  
    int num[n];
    
    for(i=0;i<n;i++)
    {
                    cin>>num[i];
    }
    
    for(i=0;i<n;i++)
    {
                    sum+=num[i];
    }
    
    cout<<sum;
    
    
    return 0;
}
